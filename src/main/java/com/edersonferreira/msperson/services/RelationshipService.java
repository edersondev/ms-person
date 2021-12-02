package com.edersonferreira.msperson.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edersonferreira.msperson.dto.PersonRelCreateDTO;
import com.edersonferreira.msperson.dto.RelationShipDTO;
import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.model.entities.Relationship;
import com.edersonferreira.msperson.model.enums.RelationshipType;
import com.edersonferreira.msperson.repositories.RelationshipRepository;
import com.edersonferreira.msperson.services.exceptions.RelationshipViolationException;
import com.edersonferreira.msperson.services.exceptions.ResourceNotFoundException;
import com.edersonferreira.msperson.services.util.Translator;

@Service
public class RelationshipService {

	@Autowired
	private RelationshipRepository repository;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private Translator translator;
	
	public List<RelationShipDTO> findAllByIdPerson(Long id) {
		Person idPerson = personService.findPersonById(id);
		List<Relationship> list = repository.findAllByIdPerson(idPerson); 
		return list.stream().map(entity -> new RelationShipDTO(entity)).collect(Collectors.toList());
	}
	
	@Transactional
	public RelationShipDTO create(Long id, PersonRelCreateDTO dto) {
		Relationship relationship = new Relationship();
		
		Person idPerson = personService.findPersonById(id);
		
		if(dto.getRelationshipType() == RelationshipType.FATHER || dto.getRelationshipType() == RelationshipType.MOTHER) {
			checkRelationshipType(idPerson,dto);
		}
		
		Person idPersonParent = personService.findPersonById(dto.getIdPersonParent());
		
		checkPersonPersonParent(idPerson, idPersonParent);
		
		relationship.setIdPerson(idPerson);
		relationship.setIdPersonParent(idPersonParent);
		relationship.setRelationshipType(dto.getRelationshipType());
		relationship.setBondType(dto.getBondType());
		
		relationship = repository.save(relationship);
		
		return new RelationShipDTO(relationship);
	}
	
	private void checkRelationshipType(Person idPerson, PersonRelCreateDTO dto) {
		boolean existsRelationship = repository.existsByIdPersonAndRelationshipTypeAndBondType(
				idPerson, dto.getRelationshipType().getCode(), dto.getBondType().getCode()
		);
		if(existsRelationship) {
			String parentType = (dto.getRelationshipType() == RelationshipType.FATHER ? "relationship.type.father" : "relationship.type.mother");
			String tranlatorParentType = translator.toLocale(parentType);
			throw new RelationshipViolationException(translator.toLocale("relationship.exception.type", new String[] {tranlatorParentType}));
		}
	}
	
	private void checkPersonPersonParent(Person idPerson, Person idPersonParent) {
		boolean exists = repository.existsByIdPersonAndIdPersonParent(idPerson, idPersonParent);
		if(exists) {
			throw new RelationshipViolationException(translator.toLocale("relationship.exception.exists"));
		}
	}
	
	public void deleteById(Long id) {
		try {			
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(translator.toLocale("resource.exception.not-found", new Long[] {id}));
		}
	}
}

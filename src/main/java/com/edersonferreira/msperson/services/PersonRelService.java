package com.edersonferreira.msperson.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edersonferreira.msperson.dto.PersonRelCreateDTO;
import com.edersonferreira.msperson.dto.RelationShipDTO;
import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.model.entities.Relationship;
import com.edersonferreira.msperson.repositories.PersonRelRepository;
import com.edersonferreira.msperson.repositories.PersonRepository;
import com.edersonferreira.msperson.services.exceptions.ResourceNotFoundException;

@Service
public class PersonRelService {

	@Autowired
	private PersonRelRepository repository;
	
	@Autowired
	private PersonRepository personRepository;
	
	public List<RelationShipDTO> findAllByIdPerson(Long id) {
		Person idPerson = findPersonById(id);
		List<Relationship> list = repository.findAllByIdPerson(idPerson); 
		return list.stream().map(entity -> new RelationShipDTO(entity)).collect(Collectors.toList());
	}
	
	@Transactional
	public RelationShipDTO create(Long id, PersonRelCreateDTO dto) {
		Relationship relationship = new Relationship();
		
		Person idPerson = findPersonById(id);
		Person idPersonParent = findPersonById(dto.getIdPersonParent());
		
		relationship.setIdPerson(idPerson);
		relationship.setIdPersonParent(idPersonParent);
		relationship.setRelationshipType(dto.getRelationshipType());
		relationship.setBondType(dto.getBondType());
		
		relationship = repository.save(relationship);
		
		return new RelationShipDTO(relationship);
	}
	
	private Person findPersonById(Long id) {
		Optional<Person> person = personRepository.findById(id);
		return person.orElseThrow(() -> new ResourceNotFoundException("Person code does not exist"));
	}
	
	public void deleteById(Long id) {
		try {			
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Resource not found: " + id);
		}
	}
}

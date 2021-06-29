package com.edersonferreira.msperson.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edersonferreira.msperson.dto.PersonRelCreateDTO;
import com.edersonferreira.msperson.dto.PersonRelDTO;
import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.model.entities.Relationship;
import com.edersonferreira.msperson.repositories.PersonRelRepository;
import com.edersonferreira.msperson.repositories.PersonRepository;
import com.edersonferreira.msperson.services.exceptions.ResourceNotFoundException;

@Service
public class PersonRelService {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PersonRelRepository personRelRepository;
	
	@Transactional(readOnly = true)
	public PersonRelDTO findById(Long id) {
		Optional<Person> obj = repository.findById(id);
		return obj.map(entity -> setObjDTO(entity)).orElseThrow(() -> new ResourceNotFoundException());
	}
	
	private PersonRelDTO setObjDTO(Person entity) {
		return new PersonRelDTO(entity);
	}
	
	@Transactional
	public PersonRelDTO create(Long id, PersonRelCreateDTO dto) {
		Relationship relationship = new Relationship();
		
		Person idPerson = findPersonById(id);
		Person idPersonParent = findPersonById(dto.getIdPersonParent());
		
		relationship.setIdPerson(idPerson);
		relationship.setIdPersonParent(idPersonParent);
		relationship.setRelationshipType(dto.getRelationshipType());
		relationship.setBondType(dto.getBondType());
		
		relationship = personRelRepository.save(relationship);
		
		return new PersonRelDTO(idPerson);
	}
	
	private Person findPersonById(Long id) {
		Optional<Person> person = repository.findById(id);
		return person.orElseThrow(() -> new ResourceNotFoundException("Person code does not exist"));
	}
}

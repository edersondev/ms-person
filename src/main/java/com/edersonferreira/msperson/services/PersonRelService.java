package com.edersonferreira.msperson.services;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	private PersonRelRepository repositoryRel;
	
	@Transactional(readOnly = true)
	public PersonRelDTO findById(Long id) {
		Optional<Person> obj = repository.findById(id);
		return obj.map(entity -> setObjDTO(entity)).orElseThrow(() -> new ResourceNotFoundException());
	}
	
	private PersonRelDTO setObjDTO(Person entity) {
		Set<Relationship> rels = repositoryRel.findByIdPerson(entity.getId());
		entity.setParents(rels);
		return new PersonRelDTO(entity);
	}
}

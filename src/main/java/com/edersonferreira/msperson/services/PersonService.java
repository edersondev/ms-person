package com.edersonferreira.msperson.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edersonferreira.msperson.dto.PersonDTO;
import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public PersonDTO findById(Long id) {
		Optional<Person> obj = repository.findById(id);
		return obj.map(entity -> new PersonDTO(entity)).orElseThrow(() -> new IllegalArgumentException());
	}
}

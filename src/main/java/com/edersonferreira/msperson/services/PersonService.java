package com.edersonferreira.msperson.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	public Optional<Person> findById(Long id) {
		return repository.findById(id);
	}
}

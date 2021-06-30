package com.edersonferreira.msperson.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edersonferreira.msperson.dto.DocumentDTO;
import com.edersonferreira.msperson.model.entities.Document;
import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.repositories.DocumentRepository;
import com.edersonferreira.msperson.repositories.PersonRepository;
import com.edersonferreira.msperson.services.exceptions.ResourceNotFoundException;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository repository;
	
	@Autowired
	private PersonRepository personRepository;
	
	public List<DocumentDTO> findAllByIdPerson(Long id){
		Person person = findPersonById(id);
		List<Document> list = repository.findAllByIdPerson(person);
		return list.stream().map(entity -> new DocumentDTO(entity)).collect(Collectors.toList());
	}
	
	private Person findPersonById(Long id) {
		Optional<Person> person = personRepository.findById(id);
		return person.orElseThrow(() -> new ResourceNotFoundException("Person code does not exist"));
	}
}

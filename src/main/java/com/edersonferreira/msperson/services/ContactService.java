package com.edersonferreira.msperson.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edersonferreira.msperson.dto.ContactDTO;
import com.edersonferreira.msperson.model.entities.Contact;
import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.repositories.ContactRepository;

@Service
public class ContactService {

	@Autowired
	private ContactRepository repository;
	
	@Autowired
	private PersonService personService;
	
	public List<ContactDTO> findAllByIdPerson(Long id) {
		Person person = personService.findPersonById(id);
		List<Contact> list = repository.findAllByIdPerson(person);
		return list.stream().map(entity -> new ContactDTO(entity)).collect(Collectors.toList());
	}
}

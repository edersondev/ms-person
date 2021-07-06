package com.edersonferreira.msperson.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edersonferreira.msperson.dto.ContactCreateDTO;
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
	
	public ContactDTO create(Long id, ContactCreateDTO dto) {
		Person person = personService.findPersonById(id);
		Contact contact = new Contact();
		contact.setContent(dto.getContent());
		contact.setContactType(dto.getContactType());
		contact.setPerson(person);
		contact = repository.save(contact);
		return new ContactDTO(contact);
	}
}

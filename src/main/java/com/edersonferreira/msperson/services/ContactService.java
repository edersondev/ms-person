package com.edersonferreira.msperson.services;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edersonferreira.msperson.dto.ContactCreateDTO;
import com.edersonferreira.msperson.dto.ContactDTO;
import com.edersonferreira.msperson.model.entities.Contact;
import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.model.enums.ContactType;
import com.edersonferreira.msperson.repositories.ContactRepository;
import com.edersonferreira.msperson.services.exceptions.ContactContentException;

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
		
		validateContent(dto.getContent(), dto.getContactType());
		
		if(dto.getContactType() == ContactType.EMAIL) {
			checkEmailExists(dto.getContent());
		}
		
		Person person = personService.findPersonById(id);
		
		Contact contact = new Contact();
		contact.setContent(dto.getContent());
		contact.setContactType(dto.getContactType());
		contact.setPerson(person);
		contact = repository.save(contact);
		return new ContactDTO(contact);
	}
	
	private void validateContent(String content, ContactType contactType) {
		String patternRegex = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
		String messageException = "Invalid email";
		
		if(contactType != ContactType.EMAIL) {
			patternRegex = "^\\d{10,11}$";
			messageException = "Invalid phone";
		}
		
		Pattern regex = Pattern.compile(patternRegex);
		Matcher matcher = regex.matcher(content);
		if(!matcher.find()) {
			throw new ContactContentException(messageException);
		}
	}
	
	private void checkEmailExists(String email) {
		boolean exists = repository.existsByContent(email);
		if(exists) {
			throw new ContactContentException("The email " + email + " alredy exists");
		}
	}
}

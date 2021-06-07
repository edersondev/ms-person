package com.edersonferreira.msperson.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edersonferreira.msperson.dto.PersonCreateDTO;
import com.edersonferreira.msperson.dto.PersonDTO;
import com.edersonferreira.msperson.model.entities.Country;
import com.edersonferreira.msperson.model.entities.Document;
import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.model.enums.DocumentType;
import com.edersonferreira.msperson.repositories.CountryRepository;
import com.edersonferreira.msperson.repositories.DocumentRepository;
import com.edersonferreira.msperson.repositories.PersonRepository;
import com.edersonferreira.msperson.services.exceptions.ResourceNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@Transactional(readOnly = true)
	public PersonDTO findById(Long id) {
		Optional<Person> obj = repository.findById(id);
		return obj.map(entity -> new PersonDTO(entity)).orElseThrow(() -> new ResourceNotFoundException());
	}
	
	@Transactional
	public PersonDTO create(PersonCreateDTO dto) {
		Country country = this.findCountryById(dto.getIdCountry());
		
		Person person = new Person();
		person.setName(dto.getName());
		person.setBirthday(dto.getBirthday());
		person.setGender(dto.getGender());
		person.setSkinColor(dto.getSkinColor());
		person.setCountry(country);
		
		person = repository.save(person);
		
		Document document = new Document();
		document.setDocumentType(DocumentType.CPF);
		document.setNumber(dto.getDocumentNumber());
		document.setPerson(person);
		document = documentRepository.save(document);
		
		Set<Document> documents = new HashSet<>();
		documents.add(document);
		person.setDocuments(documents);
		
		return new PersonDTO(person);
	}
	
	private Country findCountryById(Long id) {
		Optional<Country> obj = countryRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Código do país informado não existe."));
	}
}

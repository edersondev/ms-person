package com.edersonferreira.msperson.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edersonferreira.msperson.dto.PersonCreateDTO;
import com.edersonferreira.msperson.dto.PersonDTO;
import com.edersonferreira.msperson.model.entities.Document;
import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.model.enums.DocumentType;
import com.edersonferreira.msperson.repositories.DocumentRepository;
import com.edersonferreira.msperson.repositories.PersonRepository;
import com.edersonferreira.msperson.services.exceptions.ResourceNotFoundException;
import com.edersonferreira.msperson.services.exceptions.ValidationCpfCnpjException;
import com.edersonferreira.msperson.validator.ValidationCpfCnpj;

@Service
public class PersonService {
	
	private final Integer CODE_BRAZIL = 76;

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@Transactional(readOnly = true)
	public PersonDTO findById(Long id) {
		Optional<Person> obj = repository.findById(id);
		return obj.map(entity -> new PersonDTO(entity)).orElseThrow(() -> new ResourceNotFoundException());
	}
	
	@Transactional
	public PersonDTO create(PersonCreateDTO dto) {
		
		if(dto.getCountryCodeOrigin() == CODE_BRAZIL) {
			cpfCnpjIsValid(dto.getDocumentNumber());
		}
		
		Person person = new Person();
		person.setName(dto.getName());
		person.setBirthday(dto.getBirthday());
		person.setGender(dto.getGender());
		person.setSkinColor(dto.getSkinColor());
		person.setCountryCodeOrigin(dto.getCountryCodeOrigin());
		
		person = repository.save(person);
		
		Document document = saveDocumentPerson(person, dto.getDocumentNumber(), dto.getCountryCodeOrigin());
		
		Set<Document> documents = new HashSet<>();
		documents.add(document);
		person.setDocuments(documents);
		
		return new PersonDTO(person);
	}
	
	private Document saveDocumentPerson(Person person, String documentNumber, Integer countryCodeOrigin) {
		DocumentType documentType = (countryCodeOrigin == CODE_BRAZIL ? DocumentType.CPF : DocumentType.PASSAPORT);
		Document document = new Document();
		document.setDocumentType(documentType);
		document.setPerson(person);
		document.setNumber(documentNumber);
		document = documentRepository.save(document);
		return document;
	}
	
	private void cpfCnpjIsValid(String documentNumber) {
		ValidationCpfCnpj validationDoc = new ValidationCpfCnpj(documentNumber);
		if(!validationDoc.documentIsValid()) {
			throw new ValidationCpfCnpjException("CPF/CNPJ inválido");
		}
		boolean docExists = documentRepository.existsByNumber(documentNumber);
		if(docExists) {
			throw new ValidationCpfCnpjException("Document number already exists");
		}
	}
	
	public PersonDTO findByCpf(String nucpf) {
		Optional<PersonDTO> obj = repository.findByCpf(nucpf);
		return obj.orElseThrow(() -> new ResourceNotFoundException("CPF informado não existe."));
	}
	
	public Person findPersonById(Long id) {
		Optional<Person> person = repository.findById(id);
		return person.orElseThrow(() -> new ResourceNotFoundException("Person code does not exist"));
	}
}

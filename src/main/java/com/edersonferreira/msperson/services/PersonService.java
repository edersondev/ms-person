package com.edersonferreira.msperson.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
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
import com.edersonferreira.msperson.services.util.Translator;
import com.edersonferreira.msperson.specification.AppSpecificationsBuilder;
import com.edersonferreira.msperson.validator.ValidationCpfCnpj;

@Service
public class PersonService {
	
	private final Integer CODE_BRAZIL = 76;

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	private Translator translator;
	
	public Page<PersonDTO> findAll(Integer pageNo,Integer pageSize,String sortBy, String search) {
		if(pageSize > 50) { pageSize = 50; }
		Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
		
		Specification<Person> spec = this.getSpecification(search);
		
		Page<Person> page = repository.findAll(spec,pageable);
		return page.map(PersonDTO::fromEntity);
	}
	
	public Specification<Person> getSpecification(String search) {
		AppSpecificationsBuilder<Person> builder = new AppSpecificationsBuilder<Person>();
		Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),", Pattern.UNICODE_CHARACTER_CLASS);
		Matcher matcher = pattern.matcher(search + ",");
		while(matcher.find()) {
			builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
		}
		return builder.build();
	}
	
	public PersonDTO findById(Long id) {
		Person person = findPersonById(id);
		return new PersonDTO(person);
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
		DocumentType documentType = (countryCodeOrigin == CODE_BRAZIL ? DocumentType.CPF : DocumentType.PASSPORT);
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
			throw new ValidationCpfCnpjException(translator.toLocale("document.invalid"));
		}
		boolean docExists = documentRepository.existsByNumber(documentNumber);
		if(docExists) {
			throw new ValidationCpfCnpjException(translator.toLocale("document.exists"));
		}
	}
	
	public PersonDTO findByCpf(String nucpf) {
		Optional<PersonDTO> obj = repository.findByCpf(nucpf);
		return obj.orElseThrow(() -> new ResourceNotFoundException(translator.toLocale("document.not-found")));
	}
	
	public Person findPersonById(Long id) {
		Optional<Person> person = repository.findById(id);
		return person.orElseThrow(() -> new ResourceNotFoundException(translator.toLocale("person.not-found")));
	}
}

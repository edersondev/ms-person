package com.edersonferreira.msperson.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edersonferreira.msperson.dto.DocumentCreateDTO;
import com.edersonferreira.msperson.dto.DocumentDTO;
import com.edersonferreira.msperson.model.entities.Document;
import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.repositories.DocumentRepository;
import com.edersonferreira.msperson.services.exceptions.ValidationCpfCnpjException;

@Service
public class DocumentService {

	@Autowired
	private DocumentRepository repository;

	@Autowired
	private PersonService personService;
	
	public List<DocumentDTO> findAllByIdPerson(Long id){
		Person person = personService.findPersonById(id);
		List<Document> list = repository.findAllByIdPerson(person);
		return list.stream().map(entity -> new DocumentDTO(entity)).collect(Collectors.toList());
	}
	
	public DocumentDTO create(Long id, DocumentCreateDTO dto) {
		Person person = personService.findPersonById(id);
		
		checkDocumentTypeExists(person,dto.getDocumentType().getCode());
		
		Document document = new Document();
		document.setNumber(dto.getNumber());
		document.setDocumentType(dto.getDocumentType());
		document.setPerson(person);
		document = repository.save(document);
		return new DocumentDTO(document);
	}
	
	public void checkDocumentTypeExists(Person idPerson, Integer documentType) {
		boolean check = repository.existsByidPersonAndDocumentType(idPerson, documentType);
		if(check) {
			throw new ValidationCpfCnpjException("The document type alredy exists");
		}
	}
	
}

package com.edersonferreira.msperson.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edersonferreira.msperson.model.entities.Document;
import com.edersonferreira.msperson.model.entities.Person;

public interface DocumentRepository extends JpaRepository<Document, Long> {

	boolean existsByNumber(String documentNumber);

	List<Document> findAllByIdPerson(Person idPerson);
	
	boolean existsByidPersonAndDocumentType(Person idPerson,Integer documentType);
}

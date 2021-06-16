package com.edersonferreira.msperson.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edersonferreira.msperson.model.entities.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {

	boolean existsByNumber(String documentNumber);

}

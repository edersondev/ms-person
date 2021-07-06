package com.edersonferreira.msperson.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edersonferreira.msperson.model.entities.Contact;
import com.edersonferreira.msperson.model.entities.Person;

public interface ContactRepository extends JpaRepository<Contact, Long> {

	List<Contact> findAllByIdPerson(Person idPerson);
	
	boolean existsByContent(String content);
}

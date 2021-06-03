package com.edersonferreira.msperson;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.services.PersonService;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

	@Autowired
	private PersonService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Optional<Person>> findById(@PathVariable Long id) {
		Optional<Person> obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

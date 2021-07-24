package com.edersonferreira.msperson.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edersonferreira.msperson.dto.ContactCreateDTO;
import com.edersonferreira.msperson.dto.ContactDTO;
import com.edersonferreira.msperson.services.ContactService;

@RestController
@RequestMapping(value = "/persons/contacts")
@Validated
public class ContactController {

	@Autowired
	private ContactService service;
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<List<ContactDTO>> findAllByIdPerson(@PathVariable Long id) {
		List<ContactDTO> list = service.findAllByIdPerson(id);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<ContactDTO> create(@PathVariable Long id, @Valid @RequestBody ContactCreateDTO dto) {
		ContactDTO obj = service.create(id, dto);
		return ResponseEntity.created(URI.create("/persons/contacts" + id)).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
}

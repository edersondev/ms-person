package com.edersonferreira.msperson.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edersonferreira.msperson.dto.ContactDTO;
import com.edersonferreira.msperson.services.ContactService;

@RestController
@RequestMapping(value = "/persons/contacts")
public class ContactController {

	@Autowired
	private ContactService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<ContactDTO>> findAllByIdPerson(@PathVariable Long id) {
		List<ContactDTO> list = service.findAllByIdPerson(id);
		return ResponseEntity.ok().body(list);
	}
}

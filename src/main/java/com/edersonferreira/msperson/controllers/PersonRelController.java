package com.edersonferreira.msperson.controllers;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.edersonferreira.msperson.dto.PersonRelCreateDTO;
import com.edersonferreira.msperson.dto.PersonRelDTO;
import com.edersonferreira.msperson.services.PersonRelService;

@RestController
@RequestMapping(value = "/persons/relationship")
@Validated
public class PersonRelController {

	@Autowired
	private PersonRelService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PersonRelDTO> findById(@PathVariable Long id) {
		PersonRelDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<PersonRelDTO> create(@PathVariable Long id, @Valid @RequestBody PersonRelCreateDTO dto){
		PersonRelDTO obj = service.create(id, dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
}

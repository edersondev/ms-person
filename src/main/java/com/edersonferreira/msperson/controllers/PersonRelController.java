package com.edersonferreira.msperson.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edersonferreira.msperson.dto.PersonRelDTO;
import com.edersonferreira.msperson.services.PersonRelService;

@RestController
@RequestMapping(value = "/persons-rel")
public class PersonRelController {

	@Autowired
	private PersonRelService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<PersonRelDTO> findById(@PathVariable Long id) {
		PersonRelDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}

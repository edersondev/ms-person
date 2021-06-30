package com.edersonferreira.msperson.controllers;

import java.net.URI;
import java.util.List;

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

import com.edersonferreira.msperson.dto.PersonRelCreateDTO;
import com.edersonferreira.msperson.dto.RelationShipDTO;
import com.edersonferreira.msperson.services.PersonRelService;

@RestController
@RequestMapping(value = "/persons/relationship")
@Validated
public class PersonRelController {

	@Autowired
	private PersonRelService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<RelationShipDTO>> findAllByIdPerson(@PathVariable Long id) {
		List<RelationShipDTO> list = service.findAllByIdPerson(id);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<RelationShipDTO> create(@PathVariable Long id, @Valid @RequestBody PersonRelCreateDTO dto){
		RelationShipDTO obj = service.create(id, dto);
		return ResponseEntity.created(URI.create("/persons/relationship" + id)).body(obj);
	}
}

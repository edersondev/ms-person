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

import com.edersonferreira.msperson.dto.PersonRelCreateDTO;
import com.edersonferreira.msperson.dto.RelationShipDTO;
import com.edersonferreira.msperson.services.RelationshipService;

@RestController
@RequestMapping(value = "/persons/relationship")
@Validated
public class RelationshipController {

	@Autowired
	private RelationshipService service;
	
	@GetMapping(value = "/{id_person}", produces = "application/json")
	public ResponseEntity<List<RelationShipDTO>> findAllByIdPerson(@PathVariable Long id_person) {
		List<RelationShipDTO> list = service.findAllByIdPerson(id_person);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(value = "/{id_person}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<RelationShipDTO> create(@PathVariable Long id_person, @Valid @RequestBody PersonRelCreateDTO dto){
		RelationShipDTO obj = service.create(id_person, dto);
		return ResponseEntity.created(URI.create("/persons/relationship" + id_person)).body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build();
	}
}

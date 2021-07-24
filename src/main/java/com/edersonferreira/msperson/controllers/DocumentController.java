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

import com.edersonferreira.msperson.dto.DocumentCreateDTO;
import com.edersonferreira.msperson.dto.DocumentDTO;
import com.edersonferreira.msperson.services.DocumentService;

@RestController
@RequestMapping(value = "/persons/documents")
@Validated
public class DocumentController {

	@Autowired
	private DocumentService service;
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<List<DocumentDTO>> findAllByIdPerson(@PathVariable Long id) {
		List<DocumentDTO> list = service.findAllByIdPerson(id);
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping(value = "/{id}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<DocumentDTO> create(@PathVariable Long id, @Valid @RequestBody DocumentCreateDTO dto){
		DocumentDTO obj = service.create(id, dto);
		return ResponseEntity.created(URI.create("/persons/documents" + id)).body(obj);
	}
}

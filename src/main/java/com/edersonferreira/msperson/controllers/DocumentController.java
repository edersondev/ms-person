package com.edersonferreira.msperson.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edersonferreira.msperson.dto.DocumentDTO;
import com.edersonferreira.msperson.services.DocumentService;

@RestController
@RequestMapping(value = "/persons/documents")
public class DocumentController {

	@Autowired
	private DocumentService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<List<DocumentDTO>> findAllByIdPerson(@PathVariable Long id) {
		List<DocumentDTO> list = service.findAllByIdPerson(id);
		return ResponseEntity.ok().body(list);
	}
}

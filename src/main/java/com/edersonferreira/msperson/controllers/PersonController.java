package com.edersonferreira.msperson.controllers;

import java.net.URI;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

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

import com.edersonferreira.msperson.annotation.CpfCnpj;
import com.edersonferreira.msperson.dto.PersonCreateDTO;
import com.edersonferreira.msperson.dto.PersonDTO;
import com.edersonferreira.msperson.services.PersonService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/persons")
@Validated
public class PersonController {

	@Autowired
	private PersonService service;
	
	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<PersonDTO> findById(@PathVariable Long id) {
		PersonDTO obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<PersonDTO> create(@Valid @RequestBody PersonCreateDTO dto) {
		PersonDTO obj =  service.create(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@ApiResponses(value = {
			@ApiResponse(code = 400, message = "Bad request")
	})
	@GetMapping(value = "/number/{nucpf}", produces = "application/json")
	public ResponseEntity<PersonDTO> findByCpf(@PathVariable("nucpf") @NotBlank @CpfCnpj String nucpf) {
		PersonDTO obj = service.findByCpf(nucpf);
		return ResponseEntity.ok().body(obj);
	}
}

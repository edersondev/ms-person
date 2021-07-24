package com.edersonferreira.msperson.controllers;

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

import com.edersonferreira.msperson.dto.AddressCreateDTO;
import com.edersonferreira.msperson.dto.AddressDTO;
import com.edersonferreira.msperson.services.AddressService;

@RestController
@RequestMapping(value = "/persons/address")
@Validated
public class AddressController {

	@Autowired
	private AddressService service;
	
	@GetMapping(value = "/{id_person}", produces = "application/json")
	public ResponseEntity<AddressDTO> findByPerson(@PathVariable Long id_person){
		AddressDTO address = service.findByPerson(id_person);
		return ResponseEntity.ok().body(address);
	}
	
	@PostMapping(value = "/{id_person}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<AddressDTO> createOrUpdate(@PathVariable Long id_person, @Valid @RequestBody AddressCreateDTO dto) {
		AddressDTO address = service.createOrUpdate(id_person, dto);
		return ResponseEntity.ok().body(address);
	}
}

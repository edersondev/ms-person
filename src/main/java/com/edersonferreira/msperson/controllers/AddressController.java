package com.edersonferreira.msperson.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edersonferreira.msperson.dto.AddressDTO;
import com.edersonferreira.msperson.services.AddressService;

@RestController
@RequestMapping(value = "/persons/address")
public class AddressController {

	@Autowired
	private AddressService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AddressDTO> findByPerson(@PathVariable Long id){
		AddressDTO address = service.findByPerson(id);
		return ResponseEntity.ok().body(address);
	}
}

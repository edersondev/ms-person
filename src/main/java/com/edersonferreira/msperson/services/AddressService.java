package com.edersonferreira.msperson.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edersonferreira.msperson.dto.AddressDTO;
import com.edersonferreira.msperson.model.entities.Address;
import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.repositories.AddressRepository;
import com.edersonferreira.msperson.services.exceptions.ResourceNotFoundException;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;
	
	@Autowired
	private PersonService personService;
	
	public AddressDTO findByPerson(Long id) {
		Person person = personService.findPersonById(id);
		Optional<Address> address = repository.findByIdPerson(person);
		return address.map(entity -> new AddressDTO(entity)).orElseThrow(() -> new ResourceNotFoundException("Address not found"));
	}
}

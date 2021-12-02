package com.edersonferreira.msperson.services;

import java.time.Instant;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edersonferreira.msperson.dto.AddressCreateDTO;
import com.edersonferreira.msperson.dto.AddressDTO;
import com.edersonferreira.msperson.model.entities.Address;
import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.repositories.AddressRepository;
import com.edersonferreira.msperson.services.exceptions.ResourceNotFoundException;
import com.edersonferreira.msperson.services.util.Translator;

@Service
public class AddressService {

	@Autowired
	private AddressRepository repository;
	
	@Autowired
	private PersonService personService;
	
	@Autowired
	private Translator translator;
	
	public AddressDTO findByPerson(Long id) {
		Person person = personService.findPersonById(id);
		Optional<Address> address = repository.findByIdPerson(person);
		return address.map(entity -> new AddressDTO(entity)).orElseThrow(() -> new ResourceNotFoundException(translator.toLocale("address.not-found")));
	}
	
	public AddressDTO createOrUpdate(Long id, AddressCreateDTO dto) {
		Person person = personService.findPersonById(id);
		Optional<Address> addressExists = repository.findByIdPerson(person);
		
		Address address = new Address();
		address.setPostCode(dto.getPostCode());
		address.setStreet(dto.getStreet());
		address.setNumber(dto.getNumber());
		address.setComplement(dto.getComplement());
		address.setCityCode(dto.getCityCode());
		address.setDistrict(dto.getDistrict());
		address.setIdPerson(person);
		address.setCreatedAt(Instant.now());
		
		if(addressExists.isPresent()) {
			address.setId(addressExists.get().getId());
			address.setUpdatedAt(Instant.now());
		}
		
		address = repository.save(address);
		
		return new AddressDTO(address);
	}
}

package com.edersonferreira.msperson.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edersonferreira.msperson.dto.PersonCreateDTO;
import com.edersonferreira.msperson.dto.PersonDTO;
import com.edersonferreira.msperson.model.entities.Country;
import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.repositories.CountryRepository;
import com.edersonferreira.msperson.repositories.PersonRepository;
import com.edersonferreira.msperson.services.exceptions.ResourceNotFoundException;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private CountryRepository countryRepository;
	
	public PersonDTO findById(Long id) {
		Optional<Person> obj = repository.findById(id);
		return obj.map(entity -> new PersonDTO(entity)).orElseThrow(() -> new ResourceNotFoundException());
	}
	
	public PersonDTO create(PersonCreateDTO dto) {
		Country country = this.findCountryById(dto.getIdCountry());
		
		Person person = new Person();
		person.setName(dto.getName());
		person.setBirthday(dto.getBirthday());
		person.setGender(dto.getGender());
		person.setSkinColor(dto.getSkinColor());
		person.setCountry(country);
		
		person = repository.save(person);
		
		return new PersonDTO(person);
	}
	
	private Country findCountryById(Long id) {
		Optional<Country> obj = countryRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Código do país informado não existe."));
	}
}

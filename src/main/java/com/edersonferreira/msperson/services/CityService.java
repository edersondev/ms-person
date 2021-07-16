package com.edersonferreira.msperson.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edersonferreira.msperson.model.entities.City;
import com.edersonferreira.msperson.repositories.CityRepository;
import com.edersonferreira.msperson.services.exceptions.ResourceNotFoundException;

@Service
public class CityService {

	@Autowired
	private CityRepository repository;
	
	public City findByCode(Long code) {
		Optional<City> city = repository.findByCode(code);
		return city.orElseThrow(() -> new ResourceNotFoundException("City code does not exist"));
	}
}

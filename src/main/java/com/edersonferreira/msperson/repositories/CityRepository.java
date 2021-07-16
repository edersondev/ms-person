package com.edersonferreira.msperson.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edersonferreira.msperson.model.entities.City;

public interface CityRepository extends JpaRepository<City, Long> {

	Optional<City> findByCode(Long code);
}

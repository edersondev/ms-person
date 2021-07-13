package com.edersonferreira.msperson.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edersonferreira.msperson.model.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

	Optional<Country> findByIsoCode3(String isoCode3);
}

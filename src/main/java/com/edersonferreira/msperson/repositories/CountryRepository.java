package com.edersonferreira.msperson.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edersonferreira.msperson.model.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}

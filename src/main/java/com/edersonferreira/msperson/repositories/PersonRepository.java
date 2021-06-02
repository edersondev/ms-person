package com.edersonferreira.msperson.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edersonferreira.msperson.model.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}

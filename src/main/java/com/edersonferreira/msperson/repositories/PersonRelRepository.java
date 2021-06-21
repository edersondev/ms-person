package com.edersonferreira.msperson.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edersonferreira.msperson.model.entities.Relationship;

public interface PersonRelRepository extends JpaRepository<Relationship, Long> {

	Set<Relationship> findByIdPerson(Long id);
}

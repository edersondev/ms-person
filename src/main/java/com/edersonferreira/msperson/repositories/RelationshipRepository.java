package com.edersonferreira.msperson.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.model.entities.Relationship;

public interface RelationshipRepository extends JpaRepository<Relationship, Long> {

	List<Relationship> findAllByIdPerson(Person idPerson);
	
	boolean existsByIdPersonAndRelationshipTypeAndBondType(Person idPerson,Integer relationshipType,Integer bondType);
	
	boolean existsByIdPersonAndIdPersonParent(Person idPerson, Person idPersonParent);
}

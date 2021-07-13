package com.edersonferreira.msperson.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edersonferreira.msperson.dto.PersonDTO;
import com.edersonferreira.msperson.model.entities.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

	@Query("SELECT new com.edersonferreira.msperson.dto.PersonDTO(obj) "
			+ "FROM Person AS obj INNER JOIN obj.documents AS doc WHERE doc.documentType = 1 AND doc.number = :nucpf")
	Optional<PersonDTO> findByCpf(@Param("nucpf") String nucpf);
}

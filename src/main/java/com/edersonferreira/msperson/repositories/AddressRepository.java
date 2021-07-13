package com.edersonferreira.msperson.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edersonferreira.msperson.model.entities.Address;
import com.edersonferreira.msperson.model.entities.Person;

public interface AddressRepository extends JpaRepository<Address, Long> {

	Optional<Address> findByIdPerson(Person idPerson);
}

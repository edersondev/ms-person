package com.edersonferreira.msperson.dto;

import java.util.HashSet;
import java.util.Set;

import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.model.entities.Relationship;

public class PersonRelDTO extends PersonDTO {

	private static final long serialVersionUID = 1L;

	private Set<Relationship> parents = new HashSet<>();
	
	public PersonRelDTO() {
	}

	public PersonRelDTO(Person entity) {
		super(entity);
		setParents(entity.getParents());
	}
	
	public Set<Relationship> getParents() {
		return parents;
	}

	public void setParents(Set<Relationship> set) {
		this.parents = set;
	}
	
}

package com.edersonferreira.msperson.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.edersonferreira.msperson.model.entities.Person;

public class PersonRelDTO extends PersonDTO {

	private static final long serialVersionUID = 1L;

	private List<RelationShipDTO> parents = new ArrayList<>();
	
	public PersonRelDTO() {
	}

	public PersonRelDTO(Person entity) {
		super(entity);
		parents = entity.getParents().stream().map(x -> new RelationShipDTO(x)).collect(Collectors.toList());
	}

	public List<RelationShipDTO> getParents() {
		return parents;
	}
	
}

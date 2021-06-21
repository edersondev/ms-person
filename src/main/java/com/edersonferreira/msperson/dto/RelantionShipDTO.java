package com.edersonferreira.msperson.dto;

import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.model.enums.BondType;
import com.edersonferreira.msperson.model.enums.RelationshipType;

public class RelantionShipDTO {

	private Long id;
	private String name;
	private Integer gender;
	
	private Integer relationshipType;
	private Integer bondType;
	
	public RelantionShipDTO() {
	}

	public RelantionShipDTO(Long id, String name, Integer gender, RelationshipType relationshipType, BondType bondType) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		setRelationshipType(relationshipType);
		setBondType(bondType);
	}
	
	public RelantionShipDTO(Person entity) {
		id = entity.getId();
		name = entity.getName();
		gender = entity.getGender().getCode();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getRelationshipType() {
		RelationshipType obj = RelationshipType.valueOf(relationshipType);
		switch (obj) {
		case FATHER:
			return "Pai";
		case MOTHER:
			return "Mãe";
		case CHILDREN:
			return "Filho(a)";
		case SPOUSE:
			return "Cônjuge";
		default:
			return "Outro";
		}
		
	}

	public void setRelationshipType(RelationshipType relationshipType) {
		if(relationshipType != null) {
			this.relationshipType = relationshipType.getCode();			
		}
	}

	public String getBondType() {
		BondType obj = BondType.valueOf(bondType);
		switch (obj) {
		case GENETIC:
			return "Genético";
		case SOCIAL:
			return "Social";
		default:
			return "Outro";
		}
	}

	public void setBondType(BondType bondType) {
		if(bondType != null) {
			this.bondType = bondType.getCode();			
		}
	}
	
}

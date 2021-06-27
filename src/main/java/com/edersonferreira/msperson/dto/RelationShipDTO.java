package com.edersonferreira.msperson.dto;

import com.edersonferreira.msperson.model.entities.Relationship;
import com.edersonferreira.msperson.model.enums.BondType;
import com.edersonferreira.msperson.model.enums.RelationshipType;

public class RelationShipDTO {

	private String name;
	private Integer relationshipType;
	private Integer bondType;
	
	public RelationShipDTO() {
	}
	
	public RelationShipDTO(String name, RelationshipType relationshipType, BondType bondType) {
		this.name = name;
		setRelationshipType(relationshipType);
		setBondType(bondType);
	}

	public RelationShipDTO(Relationship entity) {
		relationshipType = entity.getRelationshipType().getCode();
		bondType = entity.getBondType().getCode();
		name = entity.getIdPersonParent().getName();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		return (obj == BondType.GENETIC ? "Genético" : "Social");
	}

	public void setBondType(BondType bondType) {
		if(bondType != null) {
			this.bondType = bondType.getCode();			
		}
	}
	
}

package com.edersonferreira.msperson.dto;

import com.edersonferreira.msperson.model.entities.Relationship;
import com.edersonferreira.msperson.model.enums.BondType;
import com.edersonferreira.msperson.model.enums.RelationshipType;

public class RelationShipDTO {

	private Long idPersonParent;
	private Integer relationshipType;
	private Integer bondType;
	
	public RelationShipDTO() {
	}
	
	public RelationShipDTO(Long idPersonParent, RelationshipType relationshipType, BondType bondType) {
		this.idPersonParent = idPersonParent;
		setRelationshipType(relationshipType);
		setBondType(bondType);
	}

	public RelationShipDTO(Relationship entity) {
		idPersonParent = entity.getIdPersonParent();
		relationshipType = entity.getRelationshipType().getCode();
		bondType = entity.getBondType().getCode();
	}

	public Long getIdPersonParent() {
		return idPersonParent;
	}

	public void setIdPersonParent(Long idPersonParent) {
		this.idPersonParent = idPersonParent;
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

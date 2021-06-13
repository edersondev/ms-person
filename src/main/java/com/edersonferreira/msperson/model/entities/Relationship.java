package com.edersonferreira.msperson.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.edersonferreira.msperson.model.enums.BondType;
import com.edersonferreira.msperson.model.enums.RelationshipType;

@Entity
@Table(name = "tb_relationship")
public class Relationship {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Long idPerson;
	
	@Column(nullable = false)
	private Long idPersonParent;
	
	@Column(nullable = false)
	private Integer relationshipType;
	
	@Column(nullable = false)
	private Integer bondType;
	
	public Relationship() {
	}

	public Relationship(Long idPerson, Long idPersonParent, RelationshipType relationshipType, BondType bondType) {
		this.idPerson = idPerson;
		this.idPersonParent = idPersonParent;
		setRelationshipType(relationshipType);
		setBondType(bondType);
	}

	public Long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}

	public Long getIdPersonParent() {
		return idPersonParent;
	}

	public void setIdPersonParent(Long idPersonParent) {
		this.idPersonParent = idPersonParent;
	}

	public RelationshipType getRelationshipType() {
		return RelationshipType.valueOf(relationshipType);
	}

	public void setRelationshipType(RelationshipType relationshipType) {
		if(relationshipType != null) {
			this.relationshipType = relationshipType.getCode();			
		}
	}

	public BondType getBondType() {
		return BondType.valueOf(bondType);
	}

	public void setBondType(BondType bondType) {
		if(bondType != null) {
			this.bondType = bondType.getCode();			
		}
	}
	
}

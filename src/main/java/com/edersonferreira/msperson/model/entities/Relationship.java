package com.edersonferreira.msperson.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.edersonferreira.msperson.model.enums.BondType;
import com.edersonferreira.msperson.model.enums.RelationshipType;

@Entity
@Table(name = "tb_relationship")
public class Relationship {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_person", nullable = false)
	private Person idPerson;
	
	@ManyToOne
	@JoinColumn(name = "id_person_parent", nullable = false)
	private Person idPersonParent;
	
	@Column(nullable = false)
	private Integer relationshipType;
	
	@Column(nullable = false)
	private Integer bondType;
	
	public Relationship() {
	}

	public Relationship(RelationshipType relationshipType, BondType bondType) {
		setRelationshipType(relationshipType);
		setBondType(bondType);
	}

	public Person getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Person idPerson) {
		this.idPerson = idPerson;
	}

	public Person getIdPersonParent() {
		return idPersonParent;
	}

	public void setIdPersonParent(Person idPersonParent) {
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

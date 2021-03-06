package com.edersonferreira.msperson.dto;

import java.io.Serializable;

import org.springframework.context.support.ResourceBundleMessageSource;

import com.edersonferreira.msperson.model.entities.Relationship;
import com.edersonferreira.msperson.model.enums.BondType;
import com.edersonferreira.msperson.model.enums.RelationshipType;
import com.edersonferreira.msperson.services.util.Translator;

public class RelationShipDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Translator translator;
	
	private Long id;
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
		id = entity.getIdPersonParent().getId();
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("i18n/messages");
		messageSource.setDefaultEncoding("utf-8");
		translator = new Translator(messageSource);
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

	public String getRelationshipType() {
		RelationshipType obj = RelationshipType.valueOf(relationshipType);
		String type = "";
		switch (obj) {
			case FATHER:
				type = translator.toLocale("relationship.type.father");
				break;
			case MOTHER:
				type = translator.toLocale("relationship.type.mother");
				break;
			case CHILDREN:
				type = translator.toLocale("relationship.type.children");
				break;
			case SPOUSE:
				type = translator.toLocale("relationship.type.spouse");
				break;
			default:
				type = translator.toLocale("enum.type.other");
		}
		return type;
	}

	public void setRelationshipType(RelationshipType relationshipType) {
		if(relationshipType != null) {
			this.relationshipType = relationshipType.getCode();			
		}
	}

	public String getBondType() {
		BondType obj = BondType.valueOf(bondType);
		return (obj == BondType.GENETIC ? translator.toLocale("relationship.bound.type.genetic") : translator.toLocale("relationship.bound.type.social"));
	}

	public void setBondType(BondType bondType) {
		if(bondType != null) {
			this.bondType = bondType.getCode();			
		}
	}
	
}

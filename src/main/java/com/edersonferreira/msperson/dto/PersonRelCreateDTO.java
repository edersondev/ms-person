package com.edersonferreira.msperson.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.edersonferreira.msperson.annotation.EnumValidator;
import com.edersonferreira.msperson.model.enums.BondType;
import com.edersonferreira.msperson.model.enums.RelationshipType;

import io.swagger.annotations.ApiModelProperty;

public class PersonRelCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Id person parent",required = true)
	@NotNull
	private Long idPersonParent;
	
	@ApiModelProperty(allowableValues = "father,mother,children,spouse",example = "spouse",required = true)
	@NotBlank
	@Pattern(regexp="^[A-Za-z]*$",message = "Allow only string")
	@EnumValidator(enumClass = RelationshipType.class)
	private String relationshipType;
	
	@ApiModelProperty(allowableValues = "genetic,social",example = "social",required = true)
	@NotBlank
	@Pattern(regexp="^[A-Za-z]*$",message = "Allow only string")
	@EnumValidator(enumClass = BondType.class)
	private String bondType;
	
	public PersonRelCreateDTO() {
	}

	public PersonRelCreateDTO(Long idPersonParent, String relationshipType, String bondType) {
		this.idPersonParent = idPersonParent;
		this.relationshipType = relationshipType;
		this.bondType = bondType;
	}

	public Long getIdPersonParent() {
		return idPersonParent;
	}

	public void setIdPersonParent(Long idPersonParent) {
		this.idPersonParent = idPersonParent;
	}

	public RelationshipType getRelationshipType() {
		return RelationshipType.valueOf(relationshipType.toUpperCase());
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	public BondType getBondType() {
		return BondType.valueOf(bondType.toUpperCase());
	}

	public void setBondType(String bondType) {
		this.bondType = bondType;
	}
	
}

package com.edersonferreira.msperson.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.edersonferreira.msperson.annotation.EnumValidator;
import com.edersonferreira.msperson.model.enums.DocumentType;

import io.swagger.annotations.ApiModelProperty;

public class DocumentCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "Document number",example = "2155933",required = true)
	@NotNull
	private String number;
	
	@ApiModelProperty(allowableValues = "cpf,rg,passport",example = "rg",required = true)
	@NotNull
	@Pattern(regexp="^[A-Za-z]*$",message = "Allow only string")
	@EnumValidator(enumClass = DocumentType.class)
	private String documentType;
	
	public DocumentCreateDTO() {
		
	}

	public DocumentCreateDTO(String number, String documentType) {
		this.number = number;
		this.documentType = documentType;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public DocumentType getDocumentType() {
		return DocumentType.valueOf(documentType.toUpperCase());
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
}

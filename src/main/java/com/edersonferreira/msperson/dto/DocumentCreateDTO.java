package com.edersonferreira.msperson.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.edersonferreira.msperson.annotation.EnumValidator;
import com.edersonferreira.msperson.model.enums.DocumentType;

public class DocumentCreateDTO {

	@NotNull
	private String number;
	
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

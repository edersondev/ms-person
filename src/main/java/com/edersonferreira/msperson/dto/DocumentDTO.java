package com.edersonferreira.msperson.dto;

import com.edersonferreira.msperson.model.entities.Document;
import com.edersonferreira.msperson.model.enums.DocumentType;

public class DocumentDTO {

	private Long id;
	private String number;
	private DocumentType documentType;
	
	public DocumentDTO() {
	}

	public DocumentDTO(Long id, String number, DocumentType documentType) {
		this.id = id;
		this.number = number;
		this.documentType = documentType;
	}
	
	public DocumentDTO(Document entity) {
		id = entity.getId();
		number = entity.getNumber();
		documentType = entity.getDocumentType();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public DocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(DocumentType documentType) {
		this.documentType = documentType;
	}
	
}

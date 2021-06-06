package com.edersonferreira.msperson.model.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.edersonferreira.msperson.model.enums.DocumentType;

@Entity
@Table(name = "tb_document")
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = false, unique = true)
	private String number;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Instant createdAt;
	
	private Instant updatedAt;
	
	@Column(nullable = false)
	private Integer documentType;
	
	@ManyToOne
	@JoinColumn(name = "id_person", nullable = false)
	private Person person;
	
	public Document() {
	}

	public Document(Long id, String number, Instant createdAt, Instant updatedAt, DocumentType documentType) {
		this.id = id;
		this.number = number;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		setDocumentType(documentType);
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

	public Instant getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}

	public DocumentType getDocumentType() {
		return DocumentType.valueOf(documentType);
	}

	public void setDocumentType(DocumentType documentType) {
		if(documentType != null) {
			this.documentType = documentType.getCode();
		}
	}
}

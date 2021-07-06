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

import com.edersonferreira.msperson.model.enums.ContactType;

@Entity
@Table(name = "tb_contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String content;
	
	@Column(nullable = false)
	private Integer contactType;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Instant createdAt;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Instant updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "id_person", nullable = false)
	private Person idPerson;
	
	public Contact() {
	}

	public Contact(Long id, String content, ContactType contactType, Instant createdAt, Instant updatedAt) {
		this.id = id;
		this.content = content;
		setContactType(contactType);
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ContactType getContactType() {
		return ContactType.valueOf(contactType);
	}

	public void setContactType(ContactType contactType) {
		if(contactType != null) {
			this.contactType = contactType.getCode();			
		}
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
	
	public Person getPerson() {
		return idPerson;
	}

	public void setPerson(Person person) {
		this.idPerson = person;
	}
	
}

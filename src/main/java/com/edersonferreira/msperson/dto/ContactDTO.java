package com.edersonferreira.msperson.dto;

import java.io.Serializable;

import com.edersonferreira.msperson.model.entities.Contact;
import com.edersonferreira.msperson.model.enums.ContactType;

public class ContactDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String content;
	private ContactType contactType;
	
	public ContactDTO() {
	}

	public ContactDTO(Long id, String content, ContactType contactType) {
		this.id = id;
		this.content = content;
		this.contactType = contactType;
	}
	
	public ContactDTO(Contact entity) {
		id = entity.getId();
		content = entity.getContent();
		contactType = entity.getContactType();
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
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
	}
	
}

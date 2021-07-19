package com.edersonferreira.msperson.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.edersonferreira.msperson.annotation.EnumValidator;
import com.edersonferreira.msperson.model.enums.ContactType;

public class ContactCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private String content;
	
	@NotNull
	@Pattern(regexp="^[A-Za-z]*$",message = "Allow only string")
	@EnumValidator(enumClass = ContactType.class)
	private String contactType;
	
	public ContactCreateDTO() {
	}

	public ContactCreateDTO(String content, String contactType) {
		this.content = content;
		this.contactType = contactType;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public ContactType getContactType() {
		return ContactType.valueOf(contactType.toUpperCase());
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	
}

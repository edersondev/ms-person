package com.edersonferreira.msperson.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.edersonferreira.msperson.annotation.EnumValidator;
import com.edersonferreira.msperson.model.enums.ContactType;

import io.swagger.annotations.ApiModelProperty;

public class ContactCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "The content can be a email or phone",example = "618550688",required = true)
	@NotNull
	private String content;
	
	@ApiModelProperty(allowableValues = "email,cellphone,telephone",example = "cellphone",required = true)
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

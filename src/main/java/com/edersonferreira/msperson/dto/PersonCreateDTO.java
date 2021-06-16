package com.edersonferreira.msperson.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.edersonferreira.msperson.annotation.EnumValidator;
import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.model.enums.Gender;
import com.edersonferreira.msperson.model.enums.SkinColor;

public class PersonCreateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String name;
	
	@NotNull
	@Past
	private LocalDate birthday;
	
	@NotNull
	@Pattern(regexp="^[A-Za-z]*$",message = "Allow only string")
	@EnumValidator(enumClass=Gender.class)
	private String gender;
	
	@NotNull
	@Pattern(regexp="^[A-Za-z]*$",message = "Allow only string")
	@EnumValidator(enumClass=SkinColor.class)
	private String skinColor;
	
	@NotEmpty
	@Pattern(regexp="^[A-Za-z]*$",message = "Allow only string")
	@Size(max = 3)
	private String countryIsoCode;
	
	@NotNull
	private String documentNumber;
	
	public PersonCreateDTO() {
	}

	public PersonCreateDTO(String name, LocalDate birthday, String gender, String skinColor, String countryIsoCode, String documentNumber) {
		this.name = name;
		this.birthday = birthday;
		this.countryIsoCode = countryIsoCode;
		this.gender = gender.toUpperCase();
		this.skinColor = skinColor;
		this.documentNumber = documentNumber;
	}
	
	public PersonCreateDTO(Person entity) {
		this.name = entity.getName();
		this.birthday = entity.getBirthday();
		this.gender = entity.getGender().toString();
		this.skinColor = entity.getSkinColor().toString();
		this.countryIsoCode = entity.getCountry().getIsoCode3();
	}

	public String getName() {
		return name.trim();
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Gender getGender() { 
		return Gender.valueOf(gender.toUpperCase());
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public SkinColor getSkinColor() {
		return SkinColor.valueOf(skinColor.toUpperCase());
	}

	public void setSkinColor(String skinColor) {
		this.skinColor = skinColor;
	}

	public String getCountryIsoCode() {
		return countryIsoCode;
	}

	public void setCountryIsoCode(String countryIsoCode) {
		this.countryIsoCode = countryIsoCode;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	
}

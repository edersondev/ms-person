package com.edersonferreira.msperson.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.model.enums.Gender;
import com.edersonferreira.msperson.model.enums.SkinColor;

public class PersonDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private LocalDate birthday;
	private Integer gender;
	private Integer skinColor;
	private Integer countryCodeOrigin;
	
	public PersonDTO() {
	}
	
	public PersonDTO(Long id, String name, LocalDate birthday, Gender gender, SkinColor skinColor, Integer countryCodeOrigin) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.countryCodeOrigin = countryCodeOrigin;
		setGender(gender);
		setSkinColor(skinColor);
	}
	
	public PersonDTO(Person entity) {
		id = entity.getId();
		name = entity.getName();
		birthday = entity.getBirthday();
		gender = entity.getGender().getCode();
		skinColor = entity.getSkinColor().getCode();
		countryCodeOrigin = entity.getCountryCodeOrigin();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
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

	public String getGender() {
		Gender obj = Gender.valueOf(gender); 
		return (obj == Gender.MALE ? "Masculino" : "Feminino");
	}

	public void setGender(Gender gender) {
		if(gender != null) {
			this.gender = gender.getCode();
		}
	}

	public String getSkinColor() {
		SkinColor obj = SkinColor.valueOf(skinColor);
		switch (obj) {
		case BLACK:
			return "Negro";
		case WHITE:
			return "Branco";
		case BROWN:
			return "Pardo";
		case YELLOW:
			return "Amarelo";
		case INDIGENOUS:
			return "Indígena";
		default:
			return "Outro";
		}
	}

	public void setSkinColor(SkinColor skinColor) {
		if(skinColor != null) {
			this.skinColor = skinColor.getCode();			
		}
	}

	public Integer getCountryCodeOrigin() {
		return countryCodeOrigin;
	}

	public void setCountryCodeOrigin(Integer countryCodeOrigin) {
		this.countryCodeOrigin = countryCodeOrigin;
	}
	
}

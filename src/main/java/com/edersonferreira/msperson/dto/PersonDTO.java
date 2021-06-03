package com.edersonferreira.msperson.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.edersonferreira.msperson.model.entities.Country;
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
	private Country country;
	
	public PersonDTO() {
	}
	
	public PersonDTO(Long id, String name, LocalDate birthday, Gender gender, SkinColor skinColor, Country country) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.country = country;
		setGender(gender);
		setSkinColor(skinColor);
	}
	
	public PersonDTO(Person entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.birthday = entity.getBirthday();
		this.gender = entity.getGender().getCode();
		this.skinColor = entity.getSkinColor().getCode();
		this.country = entity.getCountry();
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

	public String getCountry() {
		return country.getName();
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
}

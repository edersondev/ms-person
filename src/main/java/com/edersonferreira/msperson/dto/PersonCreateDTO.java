package com.edersonferreira.msperson.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

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
	private Integer skinColor;
	
	@NotNull
	private Long idCountry;
	
	public PersonCreateDTO() {
	}

	public PersonCreateDTO(String name, LocalDate birthday, String gender, Integer skinColor, Long idCountry) {
		this.name = name;
		this.birthday = birthday;
		this.idCountry = idCountry;
		this.gender = gender.toUpperCase();
		this.skinColor = skinColor;
	}
	
	public PersonCreateDTO(Person entity) {
		this.name = entity.getName();
		this.birthday = entity.getBirthday();
		this.gender = entity.getGender().toString();
		this.skinColor = entity.getSkinColor().getCode();
		this.idCountry = entity.getCountry().getId();
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

	public Gender getGender() { 
		return Gender.valueOf(gender.toUpperCase());
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public SkinColor getSkinColor() {
		return SkinColor.valueOf(skinColor);
	}

	public void setSkinColor(Integer skinColor) {
		this.skinColor = skinColor;
	}

	public Long getIdCountry() {
		return idCountry;
	}

	public void setIdCountry(Long idCountry) {
		this.idCountry = idCountry;
	}
}

package com.edersonferreira.msperson.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.edersonferreira.msperson.annotation.EnumValidator;
import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.model.enums.Gender;
import com.edersonferreira.msperson.model.enums.SkinColor;

import io.swagger.annotations.ApiModelProperty;

public class PersonCreateDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "Persons name",example = "Beltrano Souza da Silva",required = true)
	@NotBlank
	private String name;
	
	@ApiModelProperty(value = "Date format must be Year-Month-Day",example = "1985-05-21",required = true)
	@NotNull
	@DateTimeFormat(iso = ISO.DATE)
	@PastOrPresent
	private LocalDate birthday;
	
	@ApiModelProperty(allowableValues = "male,female",example = "male",required = true)
	@NotNull
	@Pattern(regexp="^[A-Za-z]*$",message = "Allow only string")
	@EnumValidator(enumClass=Gender.class)
	private String gender;
	
	@ApiModelProperty(allowableValues = "black,white,brown,yellow,indigenous",required = true)
	@NotNull
	@Pattern(regexp="^[A-Za-z]*$",message = "Allow only string")
	@EnumValidator(enumClass=SkinColor.class)
	private String skinColor;
	
	@ApiModelProperty(value = "Country of origin code",example = "76")
	@NotNull
	private Integer countryCodeOrigin;
	
	@ApiModelProperty(value = "For people from Brazil this field receives the CPF number, for other countries the passport number.",example = "60810088002")
	@NotNull
	private String documentNumber;
	
	public PersonCreateDTO() {
	}

	public PersonCreateDTO(String name, LocalDate birthday, String gender, String skinColor, Integer countryCodeOrigin, String documentNumber) {
		this.name = name;
		this.birthday = birthday;
		this.countryCodeOrigin = countryCodeOrigin;
		this.gender = gender.toUpperCase();
		this.skinColor = skinColor;
		this.documentNumber = documentNumber;
	}
	
	public PersonCreateDTO(Person entity) {
		this.name = entity.getName();
		this.birthday = entity.getBirthday();
		this.gender = entity.getGender().toString();
		this.skinColor = entity.getSkinColor().toString();
		this.countryCodeOrigin = entity.getCountryCodeOrigin();
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

	public Integer getCountryCodeOrigin() {
		return countryCodeOrigin;
	}

	public void setCountryCodeOrigin(Integer countryCodeOrigin) {
		this.countryCodeOrigin = countryCodeOrigin;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	
}

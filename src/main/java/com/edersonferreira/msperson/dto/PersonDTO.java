package com.edersonferreira.msperson.dto;

import java.io.Serializable;
import java.time.LocalDate;

import org.springframework.context.support.ResourceBundleMessageSource;

import com.edersonferreira.msperson.model.entities.Person;
import com.edersonferreira.msperson.model.enums.Gender;
import com.edersonferreira.msperson.model.enums.SkinColor;
import com.edersonferreira.msperson.services.util.Translator;

public class PersonDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Translator translator;
	
	private Long id;
	private String name;
	private LocalDate birthday;
	private Integer gender;
	private Integer skinColor = SkinColor.OTHER.getCode();
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
		if(entity.getSkinColor() != null) {
			skinColor = entity.getSkinColor().getCode();			
		}
		countryCodeOrigin = entity.getCountryCodeOrigin();
		
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("i18n/messages");
		messageSource.setDefaultEncoding("utf-8");
		translator = new Translator(messageSource);
	}
	
	public static PersonDTO fromEntity(Person entity) {
		return new PersonDTO(entity);
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
		return (obj == Gender.MALE ? translator.toLocale("person.gender.male") : translator.toLocale("person.gender.female"));
	}

	public void setGender(Gender gender) {
		if(gender != null) {
			this.gender = gender.getCode();
		}
	}

	public String getSkinColor() {
		SkinColor obj = SkinColor.valueOf(skinColor);
		String skinColor = "";
		switch (obj) {
		case BLACK:
			skinColor = translator.toLocale("person.skin.black");
			break;
		case WHITE:
			skinColor = translator.toLocale("person.skin.white");
			break;
		case BROWN:
			skinColor = translator.toLocale("person.skin.brown");
			break;
		case YELLOW:
			skinColor = translator.toLocale("person.skin.yellow");
			break;
		case INDIGENOUS:
			skinColor = translator.toLocale("person.skin.indigenous");
			break;
		default:
			skinColor = translator.toLocale("enum.type.other");
		}
		return skinColor;
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

package com.edersonferreira.msperson.model.entities;

import java.time.Instant;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.edersonferreira.msperson.model.enums.CivilStatus;
import com.edersonferreira.msperson.model.enums.Gender;
import com.edersonferreira.msperson.model.enums.SkinColor;

@Entity
@Table(name = "tb_person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private LocalDate birthday;
	
	@Column(nullable = false)
	private Integer gender;
	
	@Column(nullable = false)
	private Integer skinColor;
	
	@Column(nullable = false, columnDefinition = "integer default 1")
	private Integer civilStatus = 1;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Instant createdAt = Instant.now();
	
	private Instant updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "id_country_origin",nullable = false)
	private Country country;
	
	@OneToMany(mappedBy = "idPerson")
	private Set<Document> documents = new HashSet<>();
	
	@OneToMany(mappedBy = "idPerson")
	private Set<Relationship> parents = new HashSet<>();
	
	public Person() {
	}
	
	public Person(Long id, String name, LocalDate birthday, Gender gender, SkinColor skinColor, CivilStatus civilStatus) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		setGender(gender);
		setSkinColor(skinColor);
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

	public Gender getGender() {
		return Gender.valueOf(gender);
	}

	public void setGender(Gender gender) {
		if(gender != null) {
			this.gender = gender.getCode();			
		}
	}

	public SkinColor getSkinColor() {
		return SkinColor.valueOf(skinColor);
	}

	public void setSkinColor(SkinColor skinColor) {
		if(skinColor != null) {
			this.skinColor = skinColor.getCode();			
		}
	}

	public CivilStatus getCivilStatus() {
		return CivilStatus.valueOf(civilStatus);
	}

	public void setCivilStatus(CivilStatus civilStatus) {
		if(civilStatus != null) {
			this.civilStatus = civilStatus.getCode();			
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

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}
	
	public Set<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}

	public Set<Relationship> getParents() {
		return parents;
	}

	public void setParents(Set<Relationship> parents) {
		this.parents = parents;
	}
	
}

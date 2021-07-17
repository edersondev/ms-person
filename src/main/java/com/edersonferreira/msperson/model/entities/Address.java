package com.edersonferreira.msperson.model.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 8, nullable = false)
	private String postCode;
	
	@Column(nullable = false)
	private String street;
	
	@Column(nullable = false)
	private Integer number;
	
	private String complement;
	
	@Column(nullable = false)
	private Long cityCode;
	
	private String district;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Instant createdAt;
	
	private Instant updatedAt;
	
	@OneToOne
	@JoinColumn(name = "id_person", nullable = false, unique = true)
	private Person idPerson;
	
	public Address() {
	}

	public Address(Long id, String postCode, String street, Integer number, String complement, Long cityCode,
			String district) {
		this.id = id;
		this.postCode = postCode;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.cityCode = cityCode;
		this.district = district;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}

	public Long getCityCode() {
		return cityCode;
	}

	public void setCityCode(Long cityCode) {
		this.cityCode = cityCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
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

	public Person getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Person idPerson) {
		this.idPerson = idPerson;
	}
	
}

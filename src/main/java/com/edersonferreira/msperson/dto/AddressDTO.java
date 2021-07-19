package com.edersonferreira.msperson.dto;

import java.io.Serializable;
import java.time.Instant;

import com.edersonferreira.msperson.model.entities.Address;

public class AddressDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String postCode;
	private String street;
	private Integer number;
	private String complement;
	private Long cityCode;
	private String district;
	private Instant createdAt;
	private Instant updatedAt;
	
	public AddressDTO() {
	}

	public AddressDTO(Long id, String postCode, String street, Integer number, String complement, Long cityCode,
			String district, Instant createdAt, Instant updatedAt) {
		this.id = id;
		this.postCode = postCode;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.cityCode = cityCode;
		this.district = district;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public AddressDTO(Address entity) {
		id = entity.getId();
		postCode = entity.getPostCode();
		street = entity.getStreet();
		number = entity.getNumber();
		complement = entity.getComplement();
		cityCode = entity.getCityCode();
		district = entity.getDistrict();
		createdAt = entity.getCreatedAt();
		updatedAt = entity.getUpdatedAt();
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
	
}

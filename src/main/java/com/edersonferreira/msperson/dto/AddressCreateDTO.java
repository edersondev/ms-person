package com.edersonferreira.msperson.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class AddressCreateDTO {

	@NotNull
	@Pattern(regexp = "\\d{8,12}")
	private String postCode;
	
	@NotNull
	private String street;
	
	@NotNull
	private Integer number;
	
	private String complement;
	
	@NotNull
	private Long codeCity;
	
	@NotNull
	private String district;
	
	public AddressCreateDTO() {
	}

	public AddressCreateDTO(String postCode, String street, Integer number, String complement, Long codeCity, String district) {
		this.postCode = postCode;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.codeCity = codeCity;
		this.district = district;
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

	public Long getCodeCity() {
		return codeCity;
	}

	public void setCodeCity(Long codeCity) {
		this.codeCity = codeCity;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}
	
}

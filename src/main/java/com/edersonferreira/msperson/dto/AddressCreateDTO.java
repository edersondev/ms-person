package com.edersonferreira.msperson.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;

public class AddressCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(example = "70684405",required = true)
	@NotNull
	@Pattern(regexp = "\\d{8,12}")
	private String postCode;
	
	@ApiModelProperty(example = "Quadra CRNW 504 Bloco B Lote 6",required = true)
	@NotNull
	private String street;
	
	@ApiModelProperty(example = "333",required = true)
	@NotNull
	private Integer number;
	
	@ApiModelProperty(example = "apto 333")
	private String complement;
	
	@ApiModelProperty(value = "City code from IBGE",example = "5300108",required = true)
	@NotNull
	private Long cityCode;
	
	@ApiModelProperty(example = "Asa Sul",required = true)
	@NotNull
	private String district;
	
	public AddressCreateDTO() {
	}

	public AddressCreateDTO(String postCode, String street, Integer number, String complement, Long cityCode, String district) {
		this.postCode = postCode;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.cityCode = cityCode;
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
	
}

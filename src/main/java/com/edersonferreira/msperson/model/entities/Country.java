package com.edersonferreira.msperson.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 80, nullable = false)
	private String name;
	
	@Column(length = 2, nullable = false)
	private String isoCode;
	
	@Column(length = 3, nullable = false)
	private String isoCode3;
	
	@Column(length = 6, nullable = false)
	private Integer numberCode;
	
	@Column(length = 4, nullable = false)
	private Integer dial;
	
	public Country() {
	}

	public Country(Long id, String name, String isoCode, Integer numberCode, Integer dial, String isoCode3) {
		this.id = id;
		this.name = name;
		this.isoCode = isoCode;
		this.numberCode = numberCode;
		this.dial = dial;
		this.isoCode3 = isoCode3;
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

	public String getIsoCode() {
		return isoCode;
	}

	public void setIsoCode(String isoCode) {
		this.isoCode = isoCode;
	}

	public Integer getNumberCode() {
		return numberCode;
	}

	public void setNumberCode(Integer numberCode) {
		this.numberCode = numberCode;
	}

	public Integer getDial() {
		return dial;
	}

	public void setDial(Integer dial) {
		this.dial = dial;
	}

	public String getIsoCode3() {
		return isoCode3;
	}

	public void setIsoCode3(String isoCode3) {
		this.isoCode3 = isoCode3;
	}
	
}

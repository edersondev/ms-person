package com.edersonferreira.msperson.model.entities;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.edersonferreira.msperson.model.enums.Status;

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
	private String city;
	
	private String district;
	
	@Column(nullable = false)
	private Integer status;
	
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Instant createdAt;
	
	private Instant updatedAt;
	
	@ManyToOne
	@JoinColumn(name = "id_state", nullable = false)
	private State state;
	
	@ManyToOne
	@JoinColumn(name = "id_person", nullable = false)
	private Person idPerson;
	
	public Address() {
	}

	public Address(Long id, String postCode, String street, Integer number, String complement, String city,
			String district, State state) {
		this.id = id;
		this.postCode = postCode;
		this.street = street;
		this.number = number;
		this.complement = complement;
		this.city = city;
		this.district = district;
		this.state = state;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public Status getStatus() {
		return Status.valueOf(status);
	}

	public void setStatus(Status status) {
		if(status != null) {
			this.status = status.getCode();			
		}
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Person getPerson() {
		return idPerson;
	}

	public void setPerson(Person person) {
		this.idPerson = person;
	}
	
}

package com.edersonferreira.msperson.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_city")
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private Long code;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "id_state", nullable = false)
	private State idState;
	
	public City() {
	}

	public City(Long id, Long code, String name, State idState) {
		this.id = id;
		this.code = code;
		this.name = name;
		this.idState = idState;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public State getIdState() {
		return idState;
	}

	public void setIdState(State idState) {
		this.idState = idState;
	}
	
}

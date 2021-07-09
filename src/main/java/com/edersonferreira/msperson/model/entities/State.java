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
@Table(name = "tb_state")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable = false)
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "id_region", nullable = false)
	private Region region;
	
	public State() {
	}

	public State(Long id, String name) {
		this.id = id;
		this.name = name;
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
	
	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}
	
}

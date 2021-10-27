package com.miniproject.backend_course.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Interviewer_Table")
public class Interviewer {

	@Id
	// @GeneratedValue
	private int id;
	@NotNull(message = "not empty")
	private String name;

	protected Interviewer() {

	}

	public Interviewer(int id, String name) {
		super();
		this.id = id;
		this.name = name;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}

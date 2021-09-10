package com.miniproject.backend_course.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@DTO
public class RoundDto {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int sequence;

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

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

}

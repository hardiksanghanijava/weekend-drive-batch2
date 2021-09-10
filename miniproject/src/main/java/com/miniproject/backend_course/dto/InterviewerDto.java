package com.miniproject.backend_course.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@DTO
public class InterviewerDto {
	@Id
	// @GeneratedValue
	private int id;
	@NotNull(message = "not empty")
	private String name;

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

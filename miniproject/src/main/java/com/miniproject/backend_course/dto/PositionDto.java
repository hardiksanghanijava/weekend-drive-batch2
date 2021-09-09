package com.miniproject.backend_course.dto;

import lombok.Data;

@Data
public class PositionDto {
    
	private int id;
	private String title;
	private String descriString;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescriString() {
		return descriString;
	}
	public void setDescriString(String descriString) {
		this.descriString = descriString;
	}
	
	
}

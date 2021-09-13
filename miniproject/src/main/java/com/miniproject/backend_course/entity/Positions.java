package com.miniproject.backend_course.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Position_table")
public class Positions {
	@Id
	@GeneratedValue
	private int id;
	@NotNull(message = "Not empty")
	private String title;
	private String description;

	public Positions(int id, String title, String description) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
	}

	public Positions() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String descriptionString) {
		this.description = descriptionString;
	}

	@Override
	public String toString() {
		return "Positions [id=" + id + ", title=" + title + ", description=" + description + "]";
	}

}

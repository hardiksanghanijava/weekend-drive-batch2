package com.miniproject.backend_course.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Positions {
    @Id   
    @GeneratedValue
	private int id;
	private String title;
	private String descriptionString;
	
	@OneToMany(targetEntity=Interview.class)
    private List<Interview> interviews=new ArrayList<>();
    
	public Positions(int id, String title, String descriptionString) {
		super();
		this.id = id;
		this.title = title;
		this.descriptionString = descriptionString;
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
	public String getDescriptionString() {
		return descriptionString;
	}
	public void setDescriptionString(String descriptionString) {
		this.descriptionString = descriptionString;
	}
	@Override
	public String toString() {
		return "Positions [id=" + id + ", title=" + title + ", descriptionString=" + descriptionString + "]";
	}
	
	
}

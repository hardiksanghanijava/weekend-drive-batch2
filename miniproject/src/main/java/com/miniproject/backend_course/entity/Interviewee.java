package com.miniproject.backend_course.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "Interviewee_Table")
public class Interviewee {

    @Id
    @GeneratedValue
    private int id;
    @NotNull(message="not empty")
    private String name;
    private String skills;
    private String experience;
    private String qualification;
    
    @OneToMany(targetEntity=Interview.class)
    private List<Interview> interviews=new ArrayList<>();
    
    
   
	protected Interviewee() {
    	
    }


	public Interviewee(int id, String name, String skills, String experience, String qualification) {
		super();
		this.id = id;
		this.name = name;
		this.skills = skills;
		this.experience = experience;
		this.qualification = qualification;
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


	public String getSkills() {
		return skills;
	}


	public void setSkills(String skills) {
		this.skills = skills;
	}


	public String getExperience() {
		return experience;
	}


	public void setExperience(String experience) {
		this.experience = experience;
	}


	public String getQualification() {
		return qualification;
	}


	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	
    
    
}

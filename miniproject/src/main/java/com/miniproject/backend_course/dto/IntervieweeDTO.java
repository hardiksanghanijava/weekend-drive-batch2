package com.miniproject.backend_course.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;

import com.miniproject.backend_course.entity.Interviewee;




@DTO
public class IntervieweeDTO {

	@Id
	@GeneratedValue
	private int id;
	@NotNull(message = "not empty")
	private String name;
	private String skills;
	private String experience;
	private String qualification;

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

	public static Interviewee convertToIntervieweeEntity(IntervieweeDTO intervieweeDto) {
		ModelMapper modelMapper = new ModelMapper();
		Interviewee interviewee = modelMapper.map(intervieweeDto, Interviewee.class);
		return interviewee;
	}
	
	public static IntervieweeDTO convertToIntervieweeDto(Interviewee interviewee) {
		ModelMapper modelMapper = new ModelMapper();
		IntervieweeDTO intervieweeDto1 = modelMapper.map(interviewee, IntervieweeDTO.class);
		return intervieweeDto1;
	}

}

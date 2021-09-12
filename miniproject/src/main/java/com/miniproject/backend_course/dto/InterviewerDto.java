package com.miniproject.backend_course.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.miniproject.backend_course.entity.Interviewer;

@Component
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

public InterviewerDto convertToInterviewerDto(Interviewer interviewer) {
		
		ModelMapper mapper =new ModelMapper();
		InterviewerDto map = mapper.map(interviewer, InterviewerDto.class);
		return map;
		
	}
	
	public Interviewer convertToInterviewerEntity(InterviewerDto interviewerDto)  {
		
		ModelMapper mapper = new ModelMapper();
		Interviewer map = mapper.map(interviewerDto, Interviewer.class);
		return map;
	}
	
}

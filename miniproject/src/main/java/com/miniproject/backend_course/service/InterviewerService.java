package com.miniproject.backend_course.service;

import com.miniproject.backend_course.dto.InterviewerDto;
import com.miniproject.backend_course.entity.Interviewer;

import com.miniproject.backend_course.repository.InterviewerRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewerService {
	@Autowired
	private InterviewerRepository interviewerRepository;

	public Interviewer saveInterviewer(Interviewer product) {
		return interviewerRepository.save(product);
	}

	public List<Interviewer> getInterviewers() {
		return interviewerRepository.findAll();
	}

	public Interviewer getInterviewerById(int id) {
		return interviewerRepository.findById(id).orElse(null);
	}

	public String deleteInterviewer(int id) {
		interviewerRepository.deleteById(id);
		return "Interviewer removed !! " + id;
	}

	public Interviewer updateInterviewer(Interviewer interviewer1, Interviewer interviewer) {
		Interviewer existingInterviewer = interviewerRepository.findById(interviewer1.getId()).orElse(null);
		existingInterviewer.setName(interviewer.getName());

		return interviewerRepository.save(existingInterviewer);
	}

	public Interviewer convertToInterviewerEntity(InterviewerDto interviewerDto) {
		ModelMapper modelMapper = new ModelMapper();
		Interviewer interviewer = modelMapper.map(interviewerDto, Interviewer.class);
		return interviewer;

	}
}
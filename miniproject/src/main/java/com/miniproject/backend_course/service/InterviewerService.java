package com.miniproject.backend_course.service;


import com.miniproject.backend_course.dto.InterviewerDto;
import com.miniproject.backend_course.entity.Interviewer;
import com.miniproject.backend_course.exception.InterviewerNotFoundException;
import com.miniproject.backend_course.repository.InterviewerRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewerService {
	@Autowired
	private InterviewerRepository interviewerRepository;
	
	private InterviewerDto interviewerDto;

	public InterviewerDto saveInterviewer(Interviewer product) {
		return interviewerDto.convertToInterviewerDto(interviewerRepository.save(product));
	}

	public List<Interviewer> getInterviewers() {
		return interviewerRepository.findAll();
	}

	public InterviewerDto getInterviewerById(int id) {
		Interviewer interviewer = interviewerRepository.findById(id).orElse(null);
		if (interviewer == null) {
			throw new InterviewerNotFoundException("invalid interviewer id " + id);
		}
		
		return interviewerDto.convertToInterviewerDto(interviewer);
	}

	public String deleteInterviewer(int id) {
		Interviewer interviewer = interviewerRepository.findById(id).orElse(null);
		if (interviewer == null) {
			throw new InterviewerNotFoundException("id-" + id);
		} 
		interviewerRepository.deleteById(id);
		return "Interviewer removed !! " + id;
	}

	public InterviewerDto updateInterviewer(Interviewer interviewer1, Interviewer interviewer) {
		Interviewer existingInterviewer = interviewerRepository.findById(interviewer1.getId()).orElse(null);
		if (existingInterviewer == null) {
			throw new InterviewerNotFoundException("id--" + existingInterviewer.getId());
		}
		existingInterviewer.setName(interviewer.getName());

		return interviewerDto.convertToInterviewerDto(interviewerRepository.save(existingInterviewer));
	}

	
}
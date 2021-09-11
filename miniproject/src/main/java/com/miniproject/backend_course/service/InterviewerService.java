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

	public InterviewerDto saveInterviewer(InterviewerDto product) {
		Interviewer interviewer = interviewerDto.convertToInterviewerEntity(product);
		return interviewerDto.convertToInterviewerDto(interviewerRepository.save(interviewer));
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

	public InterviewerDto updateInterviewer(InterviewerDto interviewerDto1) {
		Interviewer interviewer = interviewerDto.convertToInterviewerEntity(interviewerDto1);
		Interviewer interviewer1 = interviewerRepository.findById(interviewer.getId()).orElse(null);
		if (interviewer1 == null) {
			throw new InterviewerNotFoundException("id--" + interviewer1.getId());
		}
		interviewer1.setName(interviewer.getName());

		return interviewerDto.convertToInterviewerDto(interviewerRepository.save(interviewer1));
	}

	
}
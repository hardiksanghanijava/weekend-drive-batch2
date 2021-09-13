package com.miniproject.backend_course.service;


import com.miniproject.backend_course.dto.IntervieweeDTO;
import com.miniproject.backend_course.dto.InterviewerDto;
import com.miniproject.backend_course.entity.Interviewee;
import com.miniproject.backend_course.entity.Interviewer;
import com.miniproject.backend_course.exception.InterviewerNotFoundException;
import com.miniproject.backend_course.repository.InterviewerRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterviewerService {
	
	@Autowired
	private InterviewerRepository interviewerRepository;
	
	
	public InterviewerDto saveInterviewer(InterviewerDto product) {
		Interviewer interviewer = InterviewerDto.convertToInterviewerEntity(product);
		return InterviewerDto.convertToInterviewerDto(interviewerRepository.save(interviewer));
	}

	public List<InterviewerDto> getInterviewers() {
		List<Interviewer> interviewers=interviewerRepository.findAll();
		List<InterviewerDto> interviewerDtos=new ArrayList<>();
		for (Interviewer interviewer:interviewers) {
			interviewerDtos.add(InterviewerDto.convertToInterviewerDto(interviewer));
		}
		return interviewerDtos;
	}

	public InterviewerDto getInterviewerById(int id) {
		Interviewer interviewer = interviewerRepository.findById(id).orElse(null);
		if (interviewer == null) {
			throw new InterviewerNotFoundException("invalid interviewer id " + id);
		}
		
		return InterviewerDto.convertToInterviewerDto(interviewer);
	}

	public String deleteInterviewer(int id) {
		Interviewer interviewer = interviewerRepository.findById(id).orElse(null);
		if (interviewer == null) {
			throw new InterviewerNotFoundException("id-" + id);
		} 
		interviewerRepository.deleteById(id);
		return "Interviewer removed !! " + id;
	}

	public InterviewerDto updateInterviewer(InterviewerDto interviewerDto) {
		Interviewer interviewer = interviewerRepository.findById(interviewerDto.getId()).orElse(null);
		if (interviewer == null) {
			throw new InterviewerNotFoundException("id--" + interviewer.getId());
		}
		BeanUtils.copyProperties(interviewerDto,interviewer);
		return InterviewerDto.convertToInterviewerDto(interviewerRepository.save(interviewer));
	}
}
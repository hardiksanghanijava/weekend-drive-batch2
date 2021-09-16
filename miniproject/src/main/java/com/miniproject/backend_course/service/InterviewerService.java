package com.miniproject.backend_course.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.backend_course.dto.InterviewerDto;
import com.miniproject.backend_course.entity.Interviewer;
import com.miniproject.backend_course.entity.ReturnId;
import com.miniproject.backend_course.exception.InterviewerNotFoundException;
import com.miniproject.backend_course.repository.InterviewerRepository;

@Service
public class InterviewerService {
	
	@Autowired
	private InterviewerRepository interviewerRepository;
	
	
	public ReturnId saveInterviewer(InterviewerDto product) {
		Interviewer interviewer = InterviewerDto.convertToInterviewerEntity(product);
		return new ReturnId(InterviewerDto.convertToInterviewerDto(interviewerRepository.save(interviewer)).getId());
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

	public ReturnId deleteInterviewer(int id) {
		Interviewer interviewer = interviewerRepository.findById(id).orElse(null);
		if (interviewer == null) {
			throw new InterviewerNotFoundException("id-" + id);
		} 
		interviewerRepository.deleteById(id);
		return new ReturnId(id);
		
	}

	public ReturnId updateInterviewer(InterviewerDto interviewerDto) {
		Interviewer interviewer = interviewerRepository.findById(interviewerDto.getId()).orElse(null);
		if (interviewer == null) {
			throw new InterviewerNotFoundException("id--" + interviewer.getId());
		}
		BeanUtils.copyProperties(interviewerDto,interviewer);
		return new ReturnId(InterviewerDto.convertToInterviewerDto(interviewerRepository.save(interviewer)).getId());
	}
}
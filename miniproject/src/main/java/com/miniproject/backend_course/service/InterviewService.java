package com.miniproject.backend_course.service;

import com.miniproject.backend_course.dto.InterviewDTO;

import com.miniproject.backend_course.entity.Interview;


import com.miniproject.backend_course.exception.ScheduledInterviewNotFoundException;
import com.miniproject.backend_course.repository.InterviewRepository;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InterviewService {
	@Autowired
	private InterviewRepository interviewRepository;
	
	@Autowired
	private InterviewDTO interviewDto;

	
	
	public InterviewDTO saveInterview(InterviewDTO product){
		Interview interview=interviewDto.convertToInterviewEntity(product);
		Interview interview1=interviewRepository.save(interview);
		return interviewDto.convertToInterviewDto(interview1);
	}

	public List<InterviewDTO> getInterviews() {
		List<Interview> interviews=interviewRepository.findAll();
		List<InterviewDTO> interviewDtos=new ArrayList<>();
		for (Interview interview:interviews) {
			interviewDtos.add(interviewDto.convertToInterviewDto(interview));
		}
		return interviewDtos;
		
	}

	public InterviewDTO getInterviewById(int id) {
		Interview interview=interviewRepository.findById(id).orElse(null);
		if(interview==null) {
			throw new ScheduledInterviewNotFoundException("invalid interviewee id " + id);
		}
		InterviewDTO interviewDto1 = interviewDto.convertToInterviewDto(interview);
		return interviewDto1;
	}

	public String deleteInterview(int id) {
		Interview interview=interviewRepository.findById(id).orElse(null);
		if(interview==null) {
			throw new ScheduledInterviewNotFoundException("invalid interview id " + id);
		}
		interviewRepository.deleteById(id);
		return "interview removed !! " + id;
	}

	public String interviewStatusById(int id) {
		Interview interview=interviewRepository.findById(id).orElse(null);
		if(interview==null) {
			throw new ScheduledInterviewNotFoundException("invalid interview id " + id);
		}
		InterviewDTO interviewDto1 = interviewDto.convertToInterviewDto(interview);
		return interviewDto1.getStatus();
	}
	 

	public InterviewDTO updateInterview(int id, InterviewDTO interviewDto1) {

		Interview existingInterview = interviewRepository.findById(id).orElse(null);
		if(existingInterview==null) {
			throw new ScheduledInterviewNotFoundException("invalid interviewee id " + id);
		}
		BeanUtils.copyProperties(interviewDto1,existingInterview);
		interviewRepository.save(existingInterview);
		
		return interviewDto.convertToInterviewDto(existingInterview);

		
	}

	public InterviewDTO rescheduledInterview(int id, InterviewDTO interviewDto1) {
		Interview interview = interviewRepository.findById(id).orElse(null);
		if(interview==null) {
			throw new ScheduledInterviewNotFoundException("invalid interviewee id " + id);
		}
		String s="Rescheduled";
		InterviewDTO interviewDto2 = interviewDto.convertToInterviewDto(interview);
		if(interviewDto2.getStatus().equals(s)) {
			
			
			BeanUtils.copyProperties(interviewDto1,interview);
			
			interviewRepository.save(interview);
		}
		
		
		return interviewDto.convertToInterviewDto(interview);
	}

	
}

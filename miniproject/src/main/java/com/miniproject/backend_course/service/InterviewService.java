package com.miniproject.backend_course.service;

import com.miniproject.backend_course.dto.InterviewDTO;

import com.miniproject.backend_course.entity.Interview;
import com.miniproject.backend_course.entity.ReturnId;
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
	
	

	
	
	public ReturnId saveInterview(InterviewDTO interviewDto){
		Interview interview=InterviewDTO.convertToInterviewEntity(interviewDto);
		//interviewRepository.save(interview);
		
		return new ReturnId(InterviewDTO.convertToInterviewDto(interviewRepository.save(interview)).getInterview_id());
	}

	public List<InterviewDTO> getInterviews() {
		List<Interview> interviews=interviewRepository.findAll();
		List<InterviewDTO> interviewDtos=new ArrayList<>();
		for (Interview interview:interviews) {
			interviewDtos.add(InterviewDTO.convertToInterviewDto(interview));
		}
		return interviewDtos;
		
	}

	public InterviewDTO getInterviewById(int id) {
		Interview interview=interviewRepository.findById(id).orElse(null);
		if(interview==null) {
			throw new ScheduledInterviewNotFoundException("invalid interviewee id " + id);
		}
		return InterviewDTO.convertToInterviewDto(interview);
	}

	public ReturnId deleteInterview(int id) {
		Interview interview=interviewRepository.findById(id).orElse(null);
		if(interview==null) {
			throw new ScheduledInterviewNotFoundException("invalid interview id " + id);
		}
		return new ReturnId(id);
		
	}

	public String interviewStatusById(int id) {
		Interview interview=interviewRepository.findById(id).orElse(null);
		if(interview==null) {
			throw new ScheduledInterviewNotFoundException("invalid interview id " + id);
		}
		InterviewDTO interviewDto = InterviewDTO.convertToInterviewDto(interview);
		return interviewDto.getStatus();
	}
	 

	public ReturnId updateInterview(int id, InterviewDTO interviewDto) {

		Interview existingInterview = interviewRepository.findById(id).orElse(null);
		if(existingInterview==null) {
			throw new ScheduledInterviewNotFoundException("invalid interviewee id " + id);
		}
		BeanUtils.copyProperties(interviewDto,existingInterview);
		interviewRepository.save(existingInterview);
		
		return new ReturnId(id);

		
	}

	public ReturnId rescheduledInterview(int id, InterviewDTO interviewDto) {
		Interview interview = interviewRepository.findById(id).orElse(null);
		if(interview==null) {
			throw new ScheduledInterviewNotFoundException("invalid interviewee id " + id);
		}
		String s="Rescheduled";
		String status=InterviewDTO.convertToInterviewDto(interview).getStatus();
		if(status.equals(s)) {
			
			
			BeanUtils.copyProperties(interviewDto,interview);
			
			interviewRepository.save(interview);
		}
		
		
		return new ReturnId(id);
	}

	
}

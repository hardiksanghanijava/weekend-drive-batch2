package com.miniproject.backend_course.service;

import com.miniproject.backend_course.dto.IntervieweeDTO;

import com.miniproject.backend_course.entity.Interviewee;
import com.miniproject.backend_course.exception.IntervieweeNotFoundException;
import com.miniproject.backend_course.repository.IntervieweeRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class IntervieweeService {
	@Autowired
	private IntervieweeRepository intervieweeRepository;

	@Autowired
	private IntervieweeDTO intervieweeDto;
	
	public IntervieweeDTO saveInterviewee(IntervieweeDTO product) throws Exception {
		Interviewee interviewee=intervieweeDto.convertToIntervieweeEntity(product);
		Interviewee interviewee1=intervieweeRepository.save(interviewee);
		return intervieweeDto.convertToIntervieweeDto(interviewee1);
	}
	

	public List<IntervieweeDTO> getInterviewees() {
		List<Interviewee> interviewees=intervieweeRepository.findAll();
		List<IntervieweeDTO> intervieweeDtos=new ArrayList<>();
		for (Interviewee interviewee:interviewees) {
			intervieweeDtos.add(intervieweeDto.convertToIntervieweeDto(interviewee));
		}
		return intervieweeDtos;
	}

	

	public IntervieweeDTO getIntervieweeById(int id) {
		Interviewee interviewee=intervieweeRepository.findById(id).orElse(null);
		if(interviewee==null) {
			throw new IntervieweeNotFoundException("invalid interviewee id " + id);
		}
		IntervieweeDTO intervieweeDto1 = intervieweeDto.convertToIntervieweeDto(interviewee);
		return intervieweeDto1;
	}

	public String deleteInterviewee(int id) {
		Interviewee interviewee=intervieweeRepository.findById(id).orElse(null);
		if(interviewee==null) {
			throw new IntervieweeNotFoundException("invalid interviewee id " + id);
		}
		intervieweeRepository.deleteById(id);
		return "interviewee removed !! " + id;
	}

	

	public IntervieweeDTO updateInterviewee(int id, IntervieweeDTO intervieweeDto1) {

		
		Interviewee existingInterviewee = intervieweeRepository.findById(id).orElse(null);
		if(existingInterviewee==null) {
			throw new IntervieweeNotFoundException("invalid interviewee id " + id);
		}
		BeanUtils.copyProperties(intervieweeDto1,existingInterviewee);
		
		intervieweeRepository.save(existingInterviewee);
		return intervieweeDto.convertToIntervieweeDto(existingInterviewee);

	}

	

}

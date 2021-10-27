package com.miniproject.backend_course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.backend_course.dto.IntervieweeDTO;
import com.miniproject.backend_course.entity.Interviewee;
import com.miniproject.backend_course.entity.ReturnId;
import com.miniproject.backend_course.exception.IntervieweeNotFoundException;
import com.miniproject.backend_course.repository.IntervieweeRepository;




@Service
public class IntervieweeService {
	@Autowired
	private IntervieweeRepository intervieweeRepository;
	
	

	
	public ReturnId saveInterviewee(IntervieweeDTO intervieweeDto) throws Exception {
		Interviewee interviewee=IntervieweeDTO.convertToIntervieweeEntity(intervieweeDto);
		
		return new ReturnId(IntervieweeDTO.convertToIntervieweeDto(intervieweeRepository.save(interviewee)).getId());
	}
	

	public List<IntervieweeDTO> getInterviewees() {
		List<Interviewee> interviewees=intervieweeRepository.findAll();
		List<IntervieweeDTO> intervieweeDtos=new ArrayList<>();
		for (Interviewee interviewee:interviewees) {
			intervieweeDtos.add(IntervieweeDTO.convertToIntervieweeDto(interviewee));
		}
		return intervieweeDtos;
	}

	

	public IntervieweeDTO getIntervieweeById(int id) {
		Interviewee interviewee=intervieweeRepository.findById(id).orElse(null);
		if(interviewee==null) {
			throw new IntervieweeNotFoundException("invalid interviewee id " + id);
		}
		return IntervieweeDTO.convertToIntervieweeDto(interviewee);
	}

	public ReturnId deleteInterviewee(int id) {
		Interviewee interviewee=intervieweeRepository.findById(id).orElse(null);
		if(interviewee==null) {
			throw new IntervieweeNotFoundException("invalid interviewee id " + id);
		}
		intervieweeRepository.deleteById(id);
		return new ReturnId(id);
	}

	

	public ReturnId updateInterviewee(int id, IntervieweeDTO intervieweeDto) {

		
		Interviewee existingInterviewee = intervieweeRepository.findById(id).orElse(null);
		if(existingInterviewee==null) {
			throw new IntervieweeNotFoundException("invalid interviewee id " + id);
		}
		BeanUtils.copyProperties(intervieweeDto,existingInterviewee);
		
		intervieweeRepository.save(existingInterviewee);
		
		return new ReturnId(id);

	}

	

}

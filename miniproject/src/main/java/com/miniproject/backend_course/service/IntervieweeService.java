package com.miniproject.backend_course.service;

import com.miniproject.backend_course.dto.IntervieweeDTO;

import com.miniproject.backend_course.entity.Interviewee;
import com.miniproject.backend_course.repository.IntervieweeRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import javax.persistence.RollbackException;

@Service
public class IntervieweeService {
	@Autowired
	private IntervieweeRepository intervieweeRepository;

	public Interviewee saveInterviewee(Interviewee product) throws RollbackException {
		return intervieweeRepository.save(product);
	}

	public List<Interviewee> getInterviewees() {
		return intervieweeRepository.findAll();
	}

	public Interviewee getIntervieweeById(int id) {
		return intervieweeRepository.findById(id).orElse(null);
	}

	public String deleteInterviewee(int id) {
		intervieweeRepository.deleteById(id);
		return "interviewee removed !! " + id;
	}

	/*
	 * public Interviewee updateInterviewee(Interviewee product) { Interviewee
	 * existingInterviewee = repository.findById(product.getId()).orElse(null);
	 * existingInterviewee.setName(product.getName());
	 * existingInterviewee.setSkills(product.getSkills());
	 * existingInterviewee.setExperience(product.getExperience());
	 * existingInterviewee.setQualification(product.getQualification()); return
	 * repository.save(existingInterviewee); }
	 */

	public Interviewee updateInterviewee(Interviewee interviewee1, Interviewee interviewee) {

		Interviewee existingInterviewee = intervieweeRepository.findById(interviewee1.getId()).orElse(null);
		existingInterviewee.setName(interviewee.getName());
		existingInterviewee.setSkills(interviewee.getSkills());
		existingInterviewee.setExperience(interviewee.getExperience());
		existingInterviewee.setQualification(interviewee.getQualification());
		return intervieweeRepository.save(existingInterviewee);

	}

	public Interviewee convertToIntervieweeEntity(IntervieweeDTO intervieweeDto) {
		ModelMapper modelMapper = new ModelMapper();
		Interviewee interviewee = modelMapper.map(intervieweeDto, Interviewee.class);
		return interviewee;
	}

}

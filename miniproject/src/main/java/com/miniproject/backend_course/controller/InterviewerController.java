package com.miniproject.backend_course.controller;

import com.miniproject.backend_course.dto.InterviewerDto;
import com.miniproject.backend_course.entity.Interviewer;
import com.miniproject.backend_course.exception.IntervieweeNotFoundException;
import com.miniproject.backend_course.exception.InterviewerNotFoundException;

import com.miniproject.backend_course.service.InterviewerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/interviewer")
public class InterviewerController {

	@Autowired
	private InterviewerService interviewerService;
	
	
	private InterviewerDto interviewerDto;

	/**
	 * to add the interviewer details
	 * @param interviewerDto
	 * @return
	 */
	@PostMapping("/add")
	public InterviewerDto addInterviewer(@Valid @RequestBody InterviewerDto interviewerDto) {
		return interviewerService.saveInterviewer(interviewerDto);
		
	}

	/**
	 * to display all the interviewer
	 * @return
	 */
	@GetMapping("/list")
	public List<Interviewer> findAllInterviewers() {
		return interviewerService.getInterviewers();
	}

	/**
	 * to find specific interviewer
	 * @param id
	 * @return
	 */
	@GetMapping("/view/{id}")
	public InterviewerDto findInterviewerById(@PathVariable int id) {
		return interviewerService.getInterviewerById(id);
		
	}

	/**
	 * to update interviewer details
	 * @param id
	 * @param interviewerDto
	 * @return
	 */
	@PutMapping("/update/{id}")
	public InterviewerDto updateInterviewerById(@PathVariable int id, @RequestBody InterviewerDto interviewerDto1) {
		return interviewerService.updateInterviewer(interviewerDto1);
	}

	/**
	 * for delete interviewer
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public String deleteInterviewerById(@PathVariable int id) {
		return interviewerService.deleteInterviewer(id);

	}
}

package com.miniproject.backend_course.controller;

import com.miniproject.backend_course.dto.IntervieweeDTO;

import com.miniproject.backend_course.entity.Interviewee;
import com.miniproject.backend_course.exception.IntervieweeNotFoundException;

import com.miniproject.backend_course.service.IntervieweeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/interviewee")
public class IntervieweeController {

	// 1. manage proper prefix
	// 2. Populate form data into DTO -> copy properties from DTO to entity -> save
	// it.
	// 3. Specify Id in url while updating entity
	// 4. give proper names to object

	@Autowired
	private IntervieweeService intervieweeService;

	// adding interviewee

	/**
	 * @param intervieweeDto
	 * @return
	 */
	@PostMapping("/add")
	public Interviewee addInterviewee(@Valid @RequestBody IntervieweeDTO intervieweeDto) {
		Interviewee interviewee = intervieweeService.convertToIntervieweeEntity(intervieweeDto);
		return intervieweeService.saveInterviewee(interviewee);
	}

	// list of interviewees

	@GetMapping("/list")
	public List<Interviewee> findAllInterviewees() {
		return intervieweeService.getInterviewees();
	}

	// find interviewee by id

	@GetMapping("/view/{id}")
	public Interviewee findIntervieweeById(@PathVariable int id) {
		Interviewee interviewee = intervieweeService.getIntervieweeById(id);
		if (interviewee == null) {
			throw new IntervieweeNotFoundException("invalid interviewee id " + id);
		}

		return interviewee;
	}

	// updating interviewee

	/**
	 * @param id
	 * @param intervieweeDto
	 * @return
	 */
	@PutMapping("/update/{id}")
	public Interviewee updateIntervieweeById(@PathVariable int id, @RequestBody IntervieweeDTO intervieweeDto) {
		Interviewee interviewee = intervieweeService.convertToIntervieweeEntity(intervieweeDto);
		Interviewee interviewee1 = intervieweeService.getIntervieweeById(id);
		if (interviewee1 == null) {
			throw new IntervieweeNotFoundException("id-" + id);
		}
		return intervieweeService.updateInterview(interviewee1, interviewee);

	}

	// deleting interviewee

	@DeleteMapping("/delete/{id}")
	public String deleteIntervieweeById(@PathVariable int id) {
		Interviewee interviewee = intervieweeService.getIntervieweeById(id);
		if (interviewee == null) {
			throw new IntervieweeNotFoundException("id-" + id);
		} else
			return intervieweeService.deleteInterviewee(id);

	}
}

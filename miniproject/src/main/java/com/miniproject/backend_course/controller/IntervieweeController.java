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

	@Autowired
	private IntervieweeService intervieweeService;

	/**
	 * add interviewee
	 * 
	 * @param intervieweeDto
	 * @return
	 */
	@PostMapping("/add")
	public Interviewee addInterviewee(@Valid @RequestBody IntervieweeDTO intervieweeDto) {
		Interviewee interviewee = intervieweeService.convertToIntervieweeEntity(intervieweeDto);
		return intervieweeService.saveInterviewee(interviewee);
	}

	/**
	 * to find all the interviewee
	 * 
	 * @return
	 */
	@GetMapping("/list")
	public List<Interviewee> findAllInterviewees() {
		return intervieweeService.getInterviewees();
	}

	/**
	 * to find specific interviewee
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/view/{id}")
	public Interviewee findIntervieweeById(@PathVariable int id) {
		Interviewee interviewee = intervieweeService.getIntervieweeById(id);
		if (interviewee == null) {
			throw new IntervieweeNotFoundException("invalid interviewee id " + id);
		}

		return interviewee;
	}

	/**
	 * for updating interviewee details
	 * 
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
		return intervieweeService.updateInterviewee(interviewee1, interviewee);

	}

	/**
	 * to delete the interviewee details
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public String deleteIntervieweeById(@PathVariable int id) {
		Interviewee interviewee = intervieweeService.getIntervieweeById(id);
		if (interviewee == null) {
			throw new IntervieweeNotFoundException("id-" + id);
		} else
			return intervieweeService.deleteInterviewee(id);

	}
}

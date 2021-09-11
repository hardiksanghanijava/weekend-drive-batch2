package com.miniproject.backend_course.controller;

import com.miniproject.backend_course.dto.IntervieweeDTO;

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
	 * @throws Exception 
	 */
	@PostMapping("/add")
	public IntervieweeDTO addInterviewee(@Valid @RequestBody IntervieweeDTO intervieweeDto) throws Exception {
		return intervieweeService.saveInterviewee(intervieweeDto);
	}

	/**
	 * to find all the interviewee
	 * 
	 * @return
	 */
	@GetMapping("/list")
	public List<IntervieweeDTO> findAllInterviewees() {
		return intervieweeService.getInterviewees();
	}

	/**
	 * to find specific interviewee
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/view/{id}")
	public IntervieweeDTO findIntervieweeById(@PathVariable int id) {

		return intervieweeService.getIntervieweeById(id);
	}

	/**
	 * for updating interviewee details
	 * 
	 * @param id
	 * @param intervieweeDto
	 * @return
	 */
	@PutMapping("/update/{id}")
	public IntervieweeDTO updateIntervieweeById(@PathVariable int id, @RequestBody IntervieweeDTO intervieweeDto) {
		
		return intervieweeService.updateInterviewee(id,intervieweeDto);

	}

	/**
	 * to delete the interviewee details
	 * 
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public String deleteIntervieweeById(@PathVariable int id) {
		
			return intervieweeService.deleteInterviewee(id);

	}
}

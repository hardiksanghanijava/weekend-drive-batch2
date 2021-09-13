package com.miniproject.backend_course.controller;

import com.miniproject.backend_course.dto.ApiResponse;
import com.miniproject.backend_course.dto.InterviewerDto;
import com.miniproject.backend_course.entity.Interviewer;

import com.miniproject.backend_course.exception.InterviewerNotFoundException;

import com.miniproject.backend_course.service.InterviewerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/interviewer")
public class InterviewerController {

	@Autowired
	private InterviewerService interviewerService;
	
	/**
	 * to add the interviewer details
	 * @param interviewerDto
	 * @return
	 */
	@PostMapping("/add")
	public ApiResponse<InterviewerDto> addInterviewer(@Valid @RequestBody InterviewerDto interviewerDto) {
		return new ApiResponse<>(HttpStatus.OK.value(),"Interviewer added successfully.",interviewerService.saveInterviewer(interviewerDto));
		
	}

	/**
	 * to display all the interviewer
	 * @return
	 */
	@GetMapping("/list")
	public ApiResponse<List<InterviewerDto>> findAllInterviewers() {
		return new ApiResponse<>(HttpStatus.OK.value(),"Interviewers list fetched successfully.",interviewerService.getInterviewers());
	}

	/**
	 * to find specific interviewer
	 * @param id
	 * @return
	 */
	@GetMapping("/view/{id}")
	public ApiResponse<InterviewerDto> findInterviewerById(@PathVariable int id) {
		return new ApiResponse<>(HttpStatus.OK.value(),"Interviewer by Id fetched successfully.",interviewerService.getInterviewerById(id));
		
	}

	/**
	 * to update interviewer details
	 * @param id
	 * @param interviewerDto
	 * @return
	 */
	@PutMapping("/update/{id}")
	public ApiResponse<InterviewerDto> updateInterviewerById(@PathVariable int id, @RequestBody InterviewerDto interviewerDto1) {
		return new ApiResponse<>(HttpStatus.OK.value(),"Interviewer with Id is updated successfully.",interviewerService.updateInterviewer(interviewerDto1));
	}

	/**
	 * for delete interviewer
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public ApiResponse<String> deleteInterviewerById(@PathVariable int id) {
		return new ApiResponse<>(HttpStatus.OK.value(),"",interviewerService.deleteInterviewer(id));

	}
}

package com.miniproject.backend_course.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.backend_course.dto.ApiResponse;
import com.miniproject.backend_course.dto.InterviewerDto;
import com.miniproject.backend_course.entity.ReturnId;
import com.miniproject.backend_course.service.InterviewerService;

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
	public ApiResponse<ReturnId> addInterviewer(@Valid @RequestBody InterviewerDto interviewerDto) {
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
	public ApiResponse<ReturnId> updateInterviewerById(@PathVariable int id, @RequestBody InterviewerDto interviewerDto1) {
		return new ApiResponse<>(HttpStatus.OK.value(),"Interviewer with Id is updated successfully.",interviewerService.updateInterviewer(interviewerDto1));
	}

	/**
	 * for delete interviewer
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public ApiResponse<ReturnId> deleteInterviewerById(@PathVariable int id) {
		return new ApiResponse<>(HttpStatus.OK.value(),"Interviewer with given id is deleted",interviewerService.deleteInterviewer(id));

	}
}

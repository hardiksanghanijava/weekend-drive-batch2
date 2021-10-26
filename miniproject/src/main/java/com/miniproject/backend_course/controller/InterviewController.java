package com.miniproject.backend_course.controller;

import com.miniproject.backend_course.dto.ApiResponse;
import com.miniproject.backend_course.dto.InterviewDTO;
import com.miniproject.backend_course.entity.ReturnId;
import com.miniproject.backend_course.service.InterviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/interview")
public class InterviewController {

	@Autowired
	private InterviewService interviewService;


	/**
	 * to add interview 
	 * @param interviewDto
	 * @return
	 */
	
	@PostMapping("/add")
	public ApiResponse<ReturnId> addInterview(@Valid @RequestBody InterviewDTO interviewDto) {
		
		return new ApiResponse<>(HttpStatus.OK.value(),"Interview saved successfully.",interviewService.saveInterview(interviewDto));
	}


	/**
	 * to display all the interview schedule
	 * @return
	 */
	
	@GetMapping("/schedule")
	public ApiResponse<List<InterviewDTO>> findAllInterviews() {
		return new ApiResponse<>(HttpStatus.OK.value(),"Interview list fetched successfully.",interviewService.getInterviews());

	}


     
	/**
	 * to display specific interview detail
	 * @param id
	 * @return
	 */
	

	@GetMapping("/schedule/{id}")
	public ApiResponse<InterviewDTO> findInterviewsById(@PathVariable int id) {
		
		return new ApiResponse<>(HttpStatus.OK.value(),"Interview fetched successfully.",interviewService.getInterviewById(id));

	}
 
	/**
	 * to check the interview status
	 * @param id
	 * @return
	 */
	
	
	@GetMapping("/{id}/status")
	public ApiResponse<String> findInterviewStatusById(@PathVariable int id) {
		
		return new ApiResponse<>(HttpStatus.OK.value(),"Status of Interview fetched successfully.",interviewService.interviewStatusById(id));

	}


	/**
	 * for rescheduling  interview
	 * @param id
	 * @param interviewDto
	 * @return
	 */
	
	
	@PutMapping("/reschedule/{id}")
	public ApiResponse<ReturnId> rescheduledInterviewById(@PathVariable int id, @RequestBody InterviewDTO interviewDto) {
		
		return new ApiResponse<>(HttpStatus.OK.value(),"Interview rescheduled successfully.",interviewService.rescheduledInterview(id, interviewDto));

		

	}

	
	/**
	 * for updating interview detail
	 * @param id
	 * @param interviewDto
	 * @return
	 */
	@CrossOrigin(origins="http://localhost:4200")
	@PutMapping("/update/{id}")
	public ApiResponse<ReturnId> updateInterviewById(@PathVariable int id, @RequestBody InterviewDTO interviewDto) {
		
		return new ApiResponse<>(HttpStatus.OK.value(),"Interview updated successfully.",interviewService.updateInterview(id, interviewDto));

	}

	/**
	 * for delete interview
	 * @param id
	 * @return
	 */
	
	
	@DeleteMapping("/delete/{id}")
	public ApiResponse<ReturnId> deleteIntervieweeById(@PathVariable int id) {
		
			
			return new ApiResponse<>(HttpStatus.OK.value(),"Interview deleted successfully.",interviewService.deleteInterview(id));

	}
}

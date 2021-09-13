package com.miniproject.backend_course.controller;

import com.miniproject.backend_course.dto.ApiResponse;
import com.miniproject.backend_course.dto.InterviewDTO;




import com.miniproject.backend_course.service.InterviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/interview")
public class InterviewController {

	@Autowired
	private InterviewService interviewService;


	/**
	 * to add interview 
	 * @param interviewDto
	 * @return
	 */
	/*@PostMapping("/add")
	public InterviewDTO addInterview(@Valid @RequestBody InterviewDTO interviewDto) {
		
		return interviewService.saveInterview(interviewDto);
	}*/
	
	@PostMapping("/add")
	public ApiResponse<InterviewDTO> addInterview(@Valid @RequestBody InterviewDTO interviewDto) {
		
		return new ApiResponse<>(HttpStatus.OK.value(),"Interview saved successfully.",interviewService.saveInterview(interviewDto));
	}


	/**
	 * to display all the interview schedule
	 * @return
	 */
	/*@GetMapping("/schedule")
	public List<InterviewDTO> findAllInterviews() {
		return interviewService.getInterviews();
	}*/
	
	@GetMapping("/schedule")
	public ApiResponse<List<InterviewDTO>> findAllInterviews() {
		return new ApiResponse<>(HttpStatus.OK.value(),"Interview list fetched successfully.",interviewService.getInterviews());

	}


     
	/**
	 * to display specific interview detail
	 * @param id
	 * @return
	 */
	/*@GetMapping("/schedule/{id}")
	public InterviewDTO findInterviewsById(@PathVariable int id) {
		
		return interviewService.getInterviewById(id);
	}*/

	@GetMapping("/schedule/{id}")
	public ApiResponse<InterviewDTO> findInterviewsById(@PathVariable int id) {
		
		return new ApiResponse<>(HttpStatus.OK.value(),"Interview fetched successfully.",interviewService.getInterviewById(id));

	}
 
	/**
	 * to check the interview status
	 * @param id
	 * @return
	 */
	/*@GetMapping("/{id}/status")
	public String findInterviewStatusById(@PathVariable int id) {
		
		return interviewService.interviewStatusById(id);

	}*/
	
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
	/*@PutMapping("/reschedule/{id}")
	public InterviewDTO rescheduledInterviewById(@PathVariable int id, @RequestBody InterviewDTO interviewDto) {
		
		return interviewService.rescheduledInterview(id,interviewDto);
		

	}*/
	
	@PutMapping("/reschedule/{id}")
	public ApiResponse<InterviewDTO> rescheduledInterviewById(@PathVariable int id, @RequestBody InterviewDTO interviewDto) {
		
		return new ApiResponse<>(HttpStatus.OK.value(),"Interview rescheduled successfully.",interviewService.rescheduledInterview(id, interviewDto));

		

	}

	
	/**
	 * for updating interview detail
	 * @param id
	 * @param interviewDto
	 * @return
	 */
	/*@PutMapping("/update/{id}")
	public InterviewDTO updateInterviewById(@PathVariable int id, @RequestBody InterviewDTO interviewDto) {
		
		return interviewService.updateInterview(id,interviewDto);
	}*/


	@PutMapping("/update/{id}")
	public ApiResponse<InterviewDTO> updateInterviewById(@PathVariable int id, @RequestBody InterviewDTO interviewDto) {
		
		return new ApiResponse<>(HttpStatus.OK.value(),"Interview updated successfully.",interviewService.updateInterview(id, interviewDto));

	}

	/**
	 * for delete interview
	 * @param id
	 * @return
	 */
	/*@DeleteMapping("/delete/{id}")
	public String deleteIntervieweeById(@PathVariable int id) {
		
			return interviewService.deleteInterview(id);

	}*/
	
	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> deleteIntervieweeById(@PathVariable int id) {
		
			interviewService.deleteInterview(id);
			return new ApiResponse<>(HttpStatus.OK.value(),"Interview deleted successfully.",null);

	}
}

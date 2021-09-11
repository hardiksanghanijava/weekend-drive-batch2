package com.miniproject.backend_course.controller;

import com.miniproject.backend_course.dto.InterviewDTO;




import com.miniproject.backend_course.service.InterviewService;

import org.springframework.beans.factory.annotation.Autowired;
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
	@PostMapping("/add")
	public InterviewDTO addInterview(@Valid @RequestBody InterviewDTO interviewDto) {
		
		return interviewService.saveInterview(interviewDto);
	}


	/**
	 * to display all the interview schedule
	 * @return
	 */
	@GetMapping("/schedule")
	public List<InterviewDTO> findAllInterviews() {
		return interviewService.getInterviews();
	}


     
	/**
	 * to display specific interview detail
	 * @param id
	 * @return
	 */
	@GetMapping("/schedule/{id}")
	public InterviewDTO findInterviewsById(@PathVariable int id) {
		
		return interviewService.getInterviewById(id);
	}

	
 
	/**
	 * to check the interview status
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}/status")
	public String findInterviewStatusById(@PathVariable int id) {
		
		return interviewService.interviewStatusById(id);

	}


	/**
	 * for rescheduling  interview
	 * @param id
	 * @param interviewDto
	 * @return
	 */
	@PutMapping("/reschedule/{id}")
	public InterviewDTO rescheduledInterviewById(@PathVariable int id, @RequestBody InterviewDTO interviewDto) {
		
		return interviewService.rescheduledInterview(id,interviewDto);
		

	}

	
	/**
	 * for updating interview detail
	 * @param id
	 * @param interviewDto
	 * @return
	 */
	@PutMapping("/update/{id}")
	public InterviewDTO updateInterviewById(@PathVariable int id, @RequestBody InterviewDTO interviewDto) {
		
		return interviewService.updateInterview(id,interviewDto);
	}



	/**
	 * for delete interview
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public String deleteIntervieweeById(@PathVariable int id) {
		
			return interviewService.deleteInterview(id);

	}
}

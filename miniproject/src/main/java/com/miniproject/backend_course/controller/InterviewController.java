package com.miniproject.backend_course.controller;

import com.miniproject.backend_course.dto.InterviewDTO;

import com.miniproject.backend_course.entity.Interview;

import com.miniproject.backend_course.exception.ScheduledInterviewNotFoundException;
import com.miniproject.backend_course.service.InterviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

/**
 * @author Tarun
 *
 */
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
	public Interview addInterview(@Valid @RequestBody InterviewDTO interviewDto) {
		Interview interview = interviewService.convertToInterviewEntity(interviewDto);
		return interviewService.saveInterview(interview);
	}


	/**
	 * to display all the interview schedule
	 * @return
	 */
	@GetMapping("/schedule")
	public List<Interview> findAllInterviews() {
		return interviewService.getInterviews();
	}


     
	/**
	 * to display specific interview detail
	 * @param id
	 * @return
	 */
	@GetMapping("/schedule/{id}")
	public Interview findInterviewsById(@PathVariable int id) {
		Interview interview = interviewService.getInterviewById(id);

		if (interview == null) {
			throw new ScheduledInterviewNotFoundException("invalid interview id " + id);
		}
		return interviewService.getInterviewById(id);
	}

	
 
	/**
	 * to check the interview status
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}/status")
	public String findInterviewStatusById(@PathVariable int id) {
		Interview interview = interviewService.getInterviewById(id);

		if (interview == null) {
			throw new ScheduledInterviewNotFoundException("invalid interview id " + id);
		}

		return interview.getStatus();

	}


	/**
	 * for rescheduling  interview
	 * @param id
	 * @param interviewDto
	 * @return
	 */
	@PutMapping("/reschedule/{id}")
	public Interview RescheduledInterviewById(@PathVariable int id, @RequestBody InterviewDTO interviewDto) {
		Interview interview1 = interviewService.getInterviewById(id);

		Interview interview = interviewService.convertToInterviewEntity(interviewDto);
		String s = "Rescheduled";
		Interview inter = null;

		if (interview1.getStatus().equals(s))
			inter = interviewService.updateInterview(interview1, interview);
		else {
			throw new ScheduledInterviewNotFoundException("not a rescheduled interview id " + id);
		}
		return inter;

	}

	
	/**
	 * for updating interview detail
	 * @param id
	 * @param interviewDto
	 * @return
	 */
	@PutMapping("/update/{id}")
	public Interview updateInterviewById(@PathVariable int id, @RequestBody InterviewDTO interviewDto) {
		Interview interview1 = interviewService.getInterviewById(id);
		Interview interview = interviewService.convertToInterviewEntity(interviewDto);
		if (interview1 == null) {
			throw new ScheduledInterviewNotFoundException("id-" + id);
		}
		return interviewService.updateInterview(interview1, interview);
	}



	/**
	 * for delete interview
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public String deleteIntervieweeById(@PathVariable int id) {
		Interview interview = interviewService.getInterviewById(id);
		if (interview == null) {
			throw new ScheduledInterviewNotFoundException("id-" + id);
		} else
			return interviewService.deleteInterview(id);

	}
}

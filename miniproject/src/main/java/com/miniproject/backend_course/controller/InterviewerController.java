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

	/**
	 * to add the interviewer details
	 * @param interviewerDto
	 * @return
	 */
	@PostMapping("/add")
	public Interviewer addInterviewer(@Valid @RequestBody InterviewerDto interviewerDto) {
		Interviewer interviewer = interviewerService.convertToInterviewerEntity(interviewerDto);
		return interviewerService.saveInterviewer(interviewer);
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
	public Interviewer findInterviewerById(@PathVariable int id) {
		Interviewer interviewer = interviewerService.getInterviewerById(id);
		if (interviewer == null) {
			throw new InterviewerNotFoundException("invalid interviewer id " + id);
		}

		return interviewer;
	}

	/**
	 * to update interviewer details
	 * @param id
	 * @param interviewerDto
	 * @return
	 */
	@PutMapping("/update/{id}")
	public Interviewer updateInterviewerById(@PathVariable int id, @RequestBody InterviewerDto interviewerDto) {
		Interviewer interviewer = interviewerService.convertToInterviewerEntity(interviewerDto);
		Interviewer interviewer1 = interviewerService.getInterviewerById(id);
		if (interviewer1 == null) {
			throw new IntervieweeNotFoundException("id--" + id);
		}
		return interviewerService.updateInterviewer(interviewer1, interviewer);
	}

	/**
	 * for delete interviewer
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public String deleteInterviewerById(@PathVariable int id) {
		Interviewer interviewer = interviewerService.getInterviewerById(id);
		if (interviewer == null) {
			throw new InterviewerNotFoundException("id-" + id);
		} else
			return interviewerService.deleteInterviewer(id);

	}
}

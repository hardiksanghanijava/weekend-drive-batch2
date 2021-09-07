package com.miniproject.backend_course.controller;



import com.miniproject.backend_course.entity.Interviewer;

import com.miniproject.backend_course.exception.InterviewerNotFoundException;

import com.miniproject.backend_course.service.InterviewerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
public class InterviewerController {

    @Autowired
    private InterviewerService service;

    @PostMapping("/api/interviewer/add")
    public Interviewer addInterviewer(@Valid @RequestBody Interviewer interviewer) {
        return service.saveInterviewer(interviewer);
    }

    

    @GetMapping("/api/interviewer/list")
    public List<Interviewer> findAllInterviewers() {
        return service.getInterviewers();
    }

    @GetMapping("/api/interviewer/view/{id}")
    public Interviewer findInterviewerById(@PathVariable int id) {
        Interviewer interviewer = service.getInterviewerById(id);
        if(interviewer==null) {
			throw new InterviewerNotFoundException("invalid interviewer id "+id);
		}
		
        return interviewer;
    }

    

    @PutMapping("/api/interviewer/update")
    public Interviewer updateInterviewer(@RequestBody Interviewer interviewer) {
        return service.updateInterviewer(interviewer);
    }

    @DeleteMapping("/api/interviewer/delete/{id}")
    public String deleteInterviewerById(@PathVariable int id) {
    	Interviewer interviewer = service.getInterviewerById(id);
        if(interviewer==null) {
			throw new InterviewerNotFoundException("id-"+id);
		}
        else
        	return service.deleteInterviewer(id);
		
        
    }
}

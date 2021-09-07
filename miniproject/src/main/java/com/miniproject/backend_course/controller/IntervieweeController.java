package com.miniproject.backend_course.controller;


import com.miniproject.backend_course.entity.Interviewee;
import com.miniproject.backend_course.exception.IntervieweeNotFoundException;
import com.miniproject.backend_course.service.IntervieweeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
public class IntervieweeController {

    @Autowired
    private IntervieweeService service;

    @PostMapping("/api/interviewee/add")
    public Interviewee addInterviewee(@Valid @RequestBody Interviewee product) {
        return service.saveInterviewee(product);
    }

    

    @GetMapping("/api/interviewee/list")
    public List<Interviewee> findAllInterviewees() {
        return service.getInterviewees();
    }

    @GetMapping("/api/interviewee/view/{id}")
    public Interviewee findIntervieweeById(@PathVariable int id) {
        Interviewee interviewee = service.getIntervieweeById(id);
        if(interviewee==null) {
			throw new IntervieweeNotFoundException("invalid interviewee id "+id);
		}
		
        return interviewee;
    }

    

    @PutMapping("/api/interviewee/update")
    public Interviewee updateInterviewee(@RequestBody Interviewee product) {
        return service.updateInterviewee(product);
    }

    @DeleteMapping("/api/interviewee/delete/{id}")
    public String deleteIntervieweeById(@PathVariable int id) {
    	Interviewee interviewee = service.getIntervieweeById(id);
        if(interviewee==null) {
			throw new IntervieweeNotFoundException("id-"+id);
		}
        else
        	return service.deleteInterviewee(id);
		
        
    }
}

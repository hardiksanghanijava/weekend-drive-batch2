package com.miniproject.backend_course.controller;


import com.miniproject.backend_course.entity.Interviewee;
import com.miniproject.backend_course.exception.IntervieweeNotFoundException;
import com.miniproject.backend_course.service.IntervieweeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class IntervieweeController {

	// 1. manage proper prefix
	// 2. Populate form data into DTO -> copy properties from DTO to entity -> save it.
	// 3. Specify Id in url while updating entity
	// 4. give proper names to object
	
    @Autowired
    private IntervieweeService intervieweeService;

    @PostMapping("/api/interviewee/add")
    public Interviewee addInterviewee(@Valid @RequestBody Interviewee product) {
        return intervieweeService.saveInterviewee(product);
    }

    

    @GetMapping("/api/interviewee/list")
    public List<Interviewee> findAllInterviewees() {
        return intervieweeService.getInterviewees();
    }

    @GetMapping("/api/interviewee/view/{id}")
    public Interviewee findIntervieweeById(@PathVariable int id) {
        Interviewee interviewee = intervieweeService.getIntervieweeById(id);
        if(interviewee==null) {
			throw new IntervieweeNotFoundException("invalid interviewee id "+id);
		}
		
        return interviewee;
    }

    

    @PutMapping("/api/interviewee/update/{id}")
    public Interviewee updateInterviewee(@RequestBody Interviewee product) {
        return intervieweeService.updateInterviewee(product);
    }

    @DeleteMapping("/api/interviewee/delete/{id}")
    public String deleteIntervieweeById(@PathVariable int id) {
    	Interviewee interviewee = intervieweeService.getIntervieweeById(id);
        if(interviewee==null) {
			throw new IntervieweeNotFoundException("id-"+id);
		}
        else
        	return intervieweeService.deleteInterviewee(id);
		
        
    }
}

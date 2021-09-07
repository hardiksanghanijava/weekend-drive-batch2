package com.miniproject.backend_course.controller;




import com.miniproject.backend_course.entity.Interview;
import com.miniproject.backend_course.exception.IntervieweeNotFoundException;
import com.miniproject.backend_course.exception.ScheduledInterviewNotFoundException;
import com.miniproject.backend_course.service.InterviewService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

import javax.validation.Valid;

@RestController
public class InterviewController {

    @Autowired
    private InterviewService service;

    @PostMapping("/api/interview/add")
    public Interview addInterviewee(@Valid @RequestBody Interview interview) {
        return service.saveInterview(interview);
    }

    
    @GetMapping("/api/interview/schedule")
    public List<Interview> findAllInterviews() {
        return service.getInterviews();
    }
    
    @GetMapping("/api/interview/schedule/{id}")
    public Interview findInterviews(@PathVariable int id) {
        return service.getInterviewById(id);
    }

    @GetMapping("/api/interview/{id}/status")
    public String findInterviewStatusById(@PathVariable int id) {
        Interview interview = service.getInterviewById(id);
        
        if(interview==null) {
			throw new ScheduledInterviewNotFoundException("invalid interview id "+id);
		}
        
        return interview.getStatus();
		
        
    }
    
    @PutMapping("/api/interview/reschedule/{id}")
    public Interview RescheduledInterviewById(@PathVariable int id,@RequestBody Interview interview) {
    	Interview interview1 = service.getInterviewById(id);
    	
        String s="Rescheduled";
    	Interview inter = null;
		/*if(interview1==null || interview1.getStatus()!="Rescheduled") {
    		throw new ScheduledInterviewNotFoundException("not a rescheduled interview id "+id);
    	}*/
    	if(interview1.getStatus().equals(s))
    		inter=service.updateInterview(interview1,interview);
    	else {
    		throw new ScheduledInterviewNotFoundException("not a rescheduled interview id "+id);
    	}
    	return inter;
    	
        
    }

	@PutMapping("/api/interview/update/{id}")
    public Interview updateInterviewById(@PathVariable int id,@RequestBody Interview interview) {
		Interview interview1 = service.getInterviewById(id);
		if(interview1==null) {
			throw new ScheduledInterviewNotFoundException("id-"+id);
		}
        return service.updateInterview(interview1,interview);
    }

    
	@DeleteMapping("/api/interview/delete/{id}")
    public String deleteIntervieweeById(@PathVariable int id) {
    	Interview interview = service.getInterviewById(id);
        if(interview==null) {
			throw new ScheduledInterviewNotFoundException("id-"+id);
		}
        else
        	return service.deleteInterview(id);
		
        
    }
}

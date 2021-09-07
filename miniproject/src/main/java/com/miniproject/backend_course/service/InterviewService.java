package com.miniproject.backend_course.service;


import com.miniproject.backend_course.entity.Interview;
import com.miniproject.backend_course.exception.ScheduledInterviewNotFoundException;
import com.miniproject.backend_course.repository.InterviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {
    @Autowired
    private InterviewRepository repository;

    public Interview saveInterview(Interview interview) {
        return repository.save(interview);
    }

    

    public List<Interview> getInterviews() {
        return repository.findAll();
    }

    public Interview getInterviewById(int id) {
        return repository.findById(id).orElse(null);
    }

    

    public String deleteInterview(int id) {
        repository.deleteById(id);
        return "product removed !! " + id;
    }

    /*public Interview updateInterview(Interview interview) {
        Interview existingInterview = repository.findById(interview.getInterview_id()).orElse(null);
        existingInterview.setTime(interview.getTime());
        existingInterview.setStatus(interview.getStatus());
        existingInterview.setInterviewee(interview.getInterviewee());
        return repository.save(existingInterview);
    }*/

	/*public Interview updateInterviewById(int id, Interview interview) {
		Interview interview1 = getInterviewById(id);
		if(interview1==null) {
			throw new ScheduledInterviewNotFoundException("id-"+id);
		}
		
		
		return updateInterview(interview1,interview);
	}*/



	public Interview updateInterview(Interview interview1, Interview interview) {
		
		Interview existingInterview = repository.findById(interview1.getInterview_id()).orElse(null);
        existingInterview.setTime(interview.getTime());
        existingInterview.setStatus(interview.getStatus());
        existingInterview.setInterviewee(interview.getInterviewee());
        existingInterview.setPositions(interview.getPositions());
        existingInterview.setRounds(interview.getRounds());
        existingInterview.setInterviewer(interview.getInterviewer());
        return repository.save(existingInterview);
	}


	
}

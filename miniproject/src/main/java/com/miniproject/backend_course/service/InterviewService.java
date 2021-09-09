package com.miniproject.backend_course.service;


import com.miniproject.backend_course.dto.InterviewDTO;

import com.miniproject.backend_course.entity.Interview;

import com.miniproject.backend_course.repository.InterviewRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewService {
    @Autowired
    private InterviewRepository interviewRepository;

    public Interview saveInterview(Interview interview) {
        return interviewRepository.save(interview);
    }

    

    public List<Interview> getInterviews() {
        return interviewRepository.findAll();
    }

    public Interview getInterviewById(int id) {
        return interviewRepository.findById(id).orElse(null);
    }

    

    public String deleteInterview(int id) {
    	interviewRepository.deleteById(id);
        return "interivew removed !! " + id;
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
		
		Interview existingInterview = interviewRepository.findById(interview1.getInterview_id()).orElse(null);
        existingInterview.setTime(interview.getTime());
        existingInterview.setStatus(interview.getStatus());
        existingInterview.setInterviewee(interview.getInterviewee());
        existingInterview.setPositions(interview.getPositions());
        existingInterview.setRounds(interview.getRounds());
        existingInterview.setInterviewer(interview.getInterviewer());
        return interviewRepository.save(existingInterview);
	}


	public Interview convertToInterviewEntity(InterviewDTO interviewDto) {
		ModelMapper modelMapper=new ModelMapper();
		Interview interview=modelMapper.map(interviewDto,Interview.class);
		return interview;
	}
	
}

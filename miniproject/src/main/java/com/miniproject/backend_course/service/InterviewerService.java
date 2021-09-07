package com.miniproject.backend_course.service;


import com.miniproject.backend_course.entity.Interviewer;

import com.miniproject.backend_course.repository.InterviewerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewerService {
    @Autowired
    private InterviewerRepository repository;

    public Interviewer saveInterviewer(Interviewer product) {
        return repository.save(product);
    }

    

    public List<Interviewer> getInterviewers() {
        return repository.findAll();
    }

    public Interviewer getInterviewerById(int id) {
        return repository.findById(id).orElse(null);
    }

    

    public String deleteInterviewer(int id) {
        repository.deleteById(id);
        return "Interviewer removed !! " + id;
    }

    public Interviewer updateInterviewer(Interviewer product) {
        Interviewer existingInterviewer = repository.findById(product.getId()).orElse(null);
        existingInterviewer.setName(product.getName());
        
        return repository.save(existingInterviewer);
    }


}

package com.miniproject.backend_course.service;

import com.miniproject.backend_course.entity.Interviewee;
import com.miniproject.backend_course.repository.IntervieweeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntervieweeService {
    @Autowired
    private IntervieweeRepository repository;

    public Interviewee saveInterviewee(Interviewee product) {
        return repository.save(product);
    }

    

    public List<Interviewee> getInterviewees() {
        return repository.findAll();
    }

    public Interviewee getIntervieweeById(int id) {
        return repository.findById(id).orElse(null);
    }

    

    public String deleteInterviewee(int id) {
        repository.deleteById(id);
        return "interviewee removed !! " + id;
    }

    public Interviewee updateInterviewee(Interviewee product) {
        Interviewee existingInterviewee = repository.findById(product.getId()).orElse(null);
        existingInterviewee.setName(product.getName());
        existingInterviewee.setSkills(product.getSkills());
        existingInterviewee.setExperience(product.getExperience());
        existingInterviewee.setQualification(product.getQualification());
        return repository.save(existingInterviewee);
    }


}

package com.miniproject.backend_course.repository;

import com.miniproject.backend_course.entity.Interviewee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IntervieweeRepository extends JpaRepository<Interviewee,Integer> {
    
}


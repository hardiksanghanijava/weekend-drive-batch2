package com.miniproject.backend_course.repository;


import com.miniproject.backend_course.entity.Interview;


import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewRepository extends JpaRepository<Interview,Integer> {
    
}


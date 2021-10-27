package com.miniproject.backend_course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.backend_course.entity.Interviewee;

public interface IntervieweeRepository extends JpaRepository<Interviewee, Integer> {

}

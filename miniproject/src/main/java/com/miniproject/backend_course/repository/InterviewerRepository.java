package com.miniproject.backend_course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.backend_course.entity.Interviewer;

public interface InterviewerRepository extends JpaRepository<Interviewer, Integer> {

}

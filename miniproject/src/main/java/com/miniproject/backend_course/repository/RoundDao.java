package com.miniproject.backend_course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.backend_course.entity.Round;



public interface RoundDao extends JpaRepository<Round, Long> {
	  
	public Round findById(long id);
}

package com.miniproject.backend_course.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miniproject.backend_course.entity.Positions;

public interface PositionRepository extends JpaRepository<Positions, Integer> {

}

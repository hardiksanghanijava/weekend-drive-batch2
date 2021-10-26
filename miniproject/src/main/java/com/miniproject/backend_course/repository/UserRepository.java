package com.miniproject.backend_course.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



import com.miniproject.backend_course.jwt.JwtUserDetails;


public interface UserRepository extends JpaRepository<JwtUserDetails, Long>{

	Optional<JwtUserDetails> findByUsername(String username);
}

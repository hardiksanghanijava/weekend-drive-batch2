package com.miniproject.backend_course.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.backend_course.dto.ApiResponse;
import com.miniproject.backend_course.dto.UserDTO;
import com.miniproject.backend_course.entity.ReturnId;
import com.miniproject.backend_course.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/api/user")

	

public class UserController {

	@Autowired
	private UserService userService;


	/**
	 * to add interview 
	 * @param interviewDto
	 * @return
	 */
	
	@PostMapping("/add")
	public ApiResponse<ReturnId> addUser(@Valid @RequestBody UserDTO userDto) {
		
		return new ApiResponse<>(HttpStatus.OK.value(),"User saved successfully.",userService.saveUser(userDto));
	}
	@GetMapping("/list")
	public ApiResponse<List<UserDTO>> findAllUsers() {
		return new ApiResponse<>(HttpStatus.OK.value(),"User list fetched successfully.",userService.getUsers());
	}

}

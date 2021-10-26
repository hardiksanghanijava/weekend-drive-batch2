package com.miniproject.backend_course.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;

import com.miniproject.backend_course.entity.Interviewee;

import com.miniproject.backend_course.jwt.JwtUserDetails;
@DTO
public class UserDTO {

	@Id
	@GeneratedValue
	private Long user_id;
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	
	public static JwtUserDetails convertToUserEntity(UserDTO userDto) {
		ModelMapper modelMapper = new ModelMapper();
		JwtUserDetails user = modelMapper.map(userDto, JwtUserDetails.class);
		return user;
	}
	
	public static UserDTO convertToUserDto(JwtUserDetails user) {
		ModelMapper modelMapper = new ModelMapper();
		UserDTO userDto = modelMapper.map(user, UserDTO.class);
		return userDto;
	}

	
}

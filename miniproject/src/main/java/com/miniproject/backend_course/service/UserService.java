package com.miniproject.backend_course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.miniproject.backend_course.dto.UserDTO;
import com.miniproject.backend_course.entity.JwtUserDetails;
import com.miniproject.backend_course.entity.ReturnLongId;
import com.miniproject.backend_course.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	

	
	
	public List<UserDTO> getUsers() {
		List<JwtUserDetails> users=userRepository.findAll();
		List<UserDTO> userDtos=new ArrayList<>();
		for (JwtUserDetails user:users) {
			userDtos.add(UserDTO.convertToUserDto(user));
		}
		return userDtos;
		
	}
	public ReturnLongId saveUser(UserDTO userDto){
		JwtUserDetails user=UserDTO.convertToUserEntity(userDto);
		List<JwtUserDetails> users=userRepository.findAll();
		if(!users.contains(user)) {
		user.setPassword(encoder.encode(userDto.getPassword()).toString());
		return new ReturnLongId(UserDTO.convertToUserDto(userRepository.save(user)).getUser_id());
		}
		else {
			int i=-1;
			return new ReturnLongId((long) i);
		}
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	JwtUserDetails userDetails=userRepository.findByUsername(username)
			.orElseThrow(()-> new UsernameNotFoundException("user not found"));
	return (UserDetails) userDetails;
	}
	
}

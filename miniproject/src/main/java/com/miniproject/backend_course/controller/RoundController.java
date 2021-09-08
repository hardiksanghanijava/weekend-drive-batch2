package com.miniproject.backend_course.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.backend_course.entity.Interviewer;
import com.miniproject.backend_course.entity.Round;
import com.miniproject.backend_course.exception.InterviewerNotFoundException;
import com.miniproject.backend_course.exception.RoundNotFoundException;
import com.miniproject.backend_course.service.RoundService;




@RestController
public class RoundController {
   
	@Autowired   
	RoundService roundservice;
	
	
	
	@GetMapping("/api/round/list")
	public List<Round> getAllRound(){
		return this.roundservice.getroRounds();
	}
	
	@GetMapping("/api/round/view/{id}")
	public Round getRoundById(@PathVariable("id") int id ) {
		
		Round round= this.roundservice.getroRound(id);
		
		if (round==null) {
			throw new RoundNotFoundException("invalid interviewer id "+id);
			
		}
			
		return round;
		
	}



	 @PostMapping("/api/round/add")
   	 public Round addPositions( @Valid @RequestBody Round round) {
   		   return this.roundservice.addRound(round);
   	 }
	 

	 
	 @PutMapping("/api/round/update/")
	 public Round updateround(@RequestBody Round round) {
		
		    return this.roundservice.updateRound(round);
	 }
	 

	 
	 
	 @DeleteMapping("/api/round/delete/{roundid}")
	 public String deleteround(@PathVariable("roundid") int roundid){
		   Round round = this.roundservice.getroRound(roundid);
		   if(round == null) {
			   throw new RoundNotFoundException("id--"+roundid);
		   }else {
			   return this.roundservice.deleteRound(roundid);
		   }
	 }
	
	
		 

		 
	
}

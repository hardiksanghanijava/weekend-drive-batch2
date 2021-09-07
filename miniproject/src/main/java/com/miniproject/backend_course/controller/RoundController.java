package com.miniproject.backend_course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.backend_course.entity.Round;
import com.miniproject.backend_course.service.RoundService;




@RestController
public class RoundController {
   
	@Autowired   
	RoundService roundservice;
	
	/*@GetMapping("/Home")
	public String Home() {
		return "Welcome tarun";
	}*/
	
	// get all the Round
	
		@GetMapping("/api/round/list")
		public ResponseEntity<List<Round>> GetPositions(){
			
			List<Round> list = this.roundservice.getroRounds();
			if (list.size()<=0) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				
			}
				 return ResponseEntity.status(HttpStatus.CREATED).body(list);
			}
		
		@GetMapping("/api/round/view/{id}")
		public ResponseEntity<Round> getposition(@PathVariable("id") long id ) {
			
			Round round= this.roundservice.getroRound(id);
			
			
			if (round==null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
				
			}
			return ResponseEntity.of(Optional.of(round));
			
		}
		
		 @PostMapping("/api/round/add")
	   	 public ResponseEntity<Round> addPositions(@RequestBody Round round) {
	   		 Round p = null;
	   		try {
	   			
	   			 p = this.roundservice.addround(round);
	   			 System.out.println(round);
	   			 return ResponseEntity.of(Optional.of(p));
	   			
	   		} catch (Exception e) {
	   			e.printStackTrace();
	   			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	   		}
	   	 }
		
		 @PutMapping("/api/round/update/{roundid}")
		 public ResponseEntity<Round> updateround(@RequestBody Round round,
				 @PathVariable("roundid") int roundid) {
			 try {
				  this.roundservice.updateRound(round, roundid);
				  return ResponseEntity.ok().body(round);
				
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
			 
			 
		 }
		 
		 @DeleteMapping("/api/round/delete/{roundid}")
		 public ResponseEntity<HttpStatus> deleteposition(@PathVariable String roundid){
			 try {
				this.roundservice.deleteRound(Long.parseLong(roundid));
				return new ResponseEntity<>(HttpStatus.OK);
			 } catch (Exception e) {
	             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		 }
	
}

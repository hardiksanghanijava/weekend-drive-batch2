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

import com.miniproject.backend_course.entity.Positions;

import com.miniproject.backend_course.exception.PositionNotFoundException;

import com.miniproject.backend_course.service.PositionService;





@RestController
public class PositionController {
	
	@Autowired
	private PositionService positionService;
    
	
      // get list of all position
	 @GetMapping("/api/position/list")
	    public List<Positions> findAllInterviewers() {
	        return this.positionService.getPositions();
	    }
	 
	 // get list of only one position
	 @GetMapping("/api/position/view/{id}")
	    public Positions findPositionById(@PathVariable int id) {
	     
	     Positions  position = positionService.getPosition(id); 
		 if(position==null) {
				throw new PositionNotFoundException("invalid position id "+id);
			}
			
	        return position;
	    }
	 
	 
	   // add position
	      @PostMapping("/api/position/add")
	   	 public Positions addPositions(@Valid @RequestBody Positions positions) {
	   		
	   			return this.positionService.addPosition(positions);
	   		}
	      
	      // update position
	      
	      @PutMapping("/api/position/update/")
	 	 public Positions updatePositions(@RequestBody Positions positions) { 
	    	  return this.positionService.updatePosition(positions);  
	      }
	      
	      // delete position
	      @DeleteMapping("/api/position/delete/{positionid}")
	 	 public String deleteposition(@PathVariable int positionid){
	 		 Positions positions = this.positionService.getPosition(positionid);
	 		 if(positions == null) {
	 			 throw new PositionNotFoundException("id--"+positionid);
	 		 }else {
	 			 return positionService.deleteposition(positionid);
	 		 
	 	 } 
	 		 }
	      

	 		 
	 		 
	 	 }
	      
	      
	   


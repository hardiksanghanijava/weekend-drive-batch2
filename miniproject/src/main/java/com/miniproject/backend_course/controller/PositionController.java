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

import com.miniproject.backend_course.entity.Positions;
import com.miniproject.backend_course.service.PositionService;





@RestController
public class PositionController {
	
	@Autowired
	private PositionService positionService;
    
	/*@GetMapping("/Home")
	public String Home() {
		return "Welcome tarun";
	}*/
	

	// get all the position
	
	@GetMapping("/api/position/list")
	public ResponseEntity<List<Positions>> GetPositions(){
		
		List<Positions> list = this.positionService.getPositions();
		if (list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
			 return ResponseEntity.status(HttpStatus.CREATED).body(list);
		}
	
   // get only one position
	@GetMapping("/api/position/view/{id}")
	public ResponseEntity<Positions> getposition(@PathVariable("id") long id ) {
		
		Positions positions= positionService.getPosition(id);
		
		
		if (positions==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			
		}
		return ResponseEntity.of(Optional.of(positions));
		
	}
	
   
	//add position
    	
    @PostMapping("/api/position/add")
   	 public ResponseEntity<Positions> addPositions(@RequestBody Positions positions) {
   		 Positions p = null;
   		try {
   			
   			 p = this.positionService.addPosition(positions);
   			 System.out.println(positions);
   			 return ResponseEntity.of(Optional.of(p));
   			
   		} catch (Exception e) {
   			e.printStackTrace();
   			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
   		}
   	 }
    	

     
  //  Update position
    
    @PutMapping("/api/position/update/{positionid}")
	 public ResponseEntity<Positions> updatePositions(@RequestBody Positions positions,
			 @PathVariable("positionid") int positionid) {
		 try {
			  this.positionService.updatePosition(positions,positionid);
			  return ResponseEntity.ok().body(positions);
			
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		 
		 
	 }
	 
	 // for delete position
	 
	 @DeleteMapping("/api/position/delete/{positionid}")
	 public ResponseEntity<HttpStatus> deleteposition(@PathVariable String positionid){
		 try {
			this.positionService.deletePostion(Long.parseLong(positionid));
			return new ResponseEntity<>(HttpStatus.OK);
		 } catch (Exception e) {
             return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 }
	
}

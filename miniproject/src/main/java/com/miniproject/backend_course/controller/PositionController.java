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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.backend_course.dto.PositionDto;
import com.miniproject.backend_course.service.PositionService;

@RestController
@RequestMapping("/api/position")
public class PositionController {

	@Autowired
	private PositionService positionService;

	
	/**
	 * to display all the available position
	 * @return
	 */
	@GetMapping("/list")
	public List<PositionDto> findAllPositions() {
		return positionService.getPositions();

	}

	
	/**
	 * to find specific position
	 * @param id
	 * @return
	 */
	@GetMapping("/view/{id}")
	public PositionDto findPositionsById(@PathVariable int id) {

	   return positionService.getPositionsById(id);
	}

	
	/**
	 * to add position
	 * @param positionDto
	 * @return
	 */
	@PostMapping("/add")
	public PositionDto addPosition(@Valid @RequestBody PositionDto positionDto) throws Exception {
		return positionService.savePosition(positionDto);
	}
	
	
	

	
	/**
	 * for update or modify position
	 * @param id
	 * @param positionDto
	 * @return
	 */

	@PutMapping("/update/{id}")
	public PositionDto updatePositionById(@PathVariable int id, @RequestBody PositionDto positionDto) {
		
		return positionService.updatePosition(id,positionDto);

	}


	
	/**
	 * to delete position
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete/{id}")
	public String deletePositionsById(@PathVariable int id) {
			return positionService.deleteposition(id);
	}

}

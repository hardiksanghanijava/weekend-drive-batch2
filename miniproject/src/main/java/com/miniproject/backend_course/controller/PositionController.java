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

import com.miniproject.backend_course.converter.PositionConverter;
import com.miniproject.backend_course.dto.PositionDto;
import com.miniproject.backend_course.entity.Positions;

import com.miniproject.backend_course.exception.PositionNotFoundException;

import com.miniproject.backend_course.service.PositionService;

@RestController
@RequestMapping("/api")
public class PositionController {

	@Autowired
	private PositionService positionService;
	
	@Autowired
	private PositionConverter positionConverter;
	


	// get list of all position
	@GetMapping("/position/list")
	public List<PositionDto> findAllpositions() {
		List<Positions> findall = this.positionService.getPositions();
		return positionConverter.entityToDto(findall);
	}
	
	

	// get list of only one position
	@GetMapping("/position/view/{id}")
	public PositionDto findPositionById(@PathVariable int id) {

		Positions position = positionService.getPosition(id);
		if (position == null) {
			throw new PositionNotFoundException("invalid position id " + id);
		}

		return positionConverter.entityToDto(position);
	}
    
	// add position
	@PostMapping("/position/add")
	public PositionDto addPositions(@Valid @RequestBody PositionDto positionDto) {
        Positions positions = positionConverter.dtoToEntity(positionDto);
        positions = positionService.addPosition(positions);
		return positionConverter.entityToDto(positions);
	}

	// update position

	@PutMapping("/position/update/")
	public Positions updatePositions(@RequestBody Positions positions) {
		return this.positionService.updatePosition(positions);
	}

	// delete position
	@DeleteMapping("/position/delete/{positionid}")
	public String deleteposition(@PathVariable int positionid) {
		Positions positions = this.positionService.getPosition(positionid);
		if (positions == null) {
			throw new PositionNotFoundException("id--" + positionid);
		} else {
			return positionService.deleteposition(positionid);

		}
	}

}

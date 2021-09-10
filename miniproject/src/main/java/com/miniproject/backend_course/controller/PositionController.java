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
import com.miniproject.backend_course.entity.Positions;
import com.miniproject.backend_course.exception.PositionNotFoundException;
import com.miniproject.backend_course.service.PositionService;

@RestController
@RequestMapping("/api/position")
public class PositionController {

	@Autowired
	private PositionService positionService;

	// get list of all position
	@GetMapping("/list")
	public List<Positions> findAllPositions() {
		return this.positionService.getPositions();

	}

	// get list of only one position
	@GetMapping("/view/{id}")
	public Positions findPositionsById(@PathVariable int id) {

		Positions position = positionService.getPositionsById(id);
		if (position == null) {
			throw new PositionNotFoundException("invalid position id " + id);
		}

		return position;
	}

	// add position
	/**
	 * @param positionDto
	 * @return
	 */
	@PostMapping("/add")
	public Positions addPositions(@Valid @RequestBody PositionDto positionDto) {
		Positions positions = positionService.convertToPositionEntity(positionDto);

		return positionService.savePosition(positions);
	}

	// update position

	/**
	 * @param id
	 * @param positionDto
	 * @return
	 */
	@PutMapping("/update/{id}")
	public Positions updatePositionsById(@PathVariable int id, @RequestBody PositionDto positionDto) {
		Positions positions = positionService.convertToPositionEntity(positionDto);
		Positions positions1 = positionService.getPositionsById(id);
		if (positions1 == null) {
			throw new PositionNotFoundException("Id-" + id);
		}
		return this.positionService.updatePosition(positions1, positions);
	}

	// delete position
	@DeleteMapping("/delete/{id}")
	public String deletePositionsById(@PathVariable int id) {
		Positions positions = this.positionService.getPositionsById(id);
		if (positions == null) {
			throw new PositionNotFoundException("id--" + id);
		} else {
			return positionService.deleteposition(id);

		}
	}

}

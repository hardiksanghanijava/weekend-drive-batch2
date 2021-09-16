package com.miniproject.backend_course.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.miniproject.backend_course.dto.ApiResponse;
import com.miniproject.backend_course.dto.PositionDto;
import com.miniproject.backend_course.entity.ReturnId;
import com.miniproject.backend_course.service.PositionService;

@RestController
@RequestMapping("/api/position")
public class PositionController {

	@Autowired
	private PositionService positionService;

	/**
	 * to display all the available position
	 * 
	 * @return
	 */

	@GetMapping("/list")
	public ApiResponse<List<PositionDto>> findAllPositions() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Position list fetched successfully.",
				positionService.getPositions());
	}

	/**
	 * to find specific position
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("/view/{id}")
	public ApiResponse<PositionDto> findPositionsById(@PathVariable int id) {

		return new ApiResponse<>(HttpStatus.OK.value(), "Position fetched successfully.",
				positionService.getPositionsById(id));
	}

	/**
	 * to add position
	 * 
	 * @param positionDto
	 * @return
	 */

	@PostMapping("/add")
	public ApiResponse<ReturnId> addPosition(@Valid @RequestBody PositionDto positionDto) throws Exception {
		return new ApiResponse<>(HttpStatus.OK.value(), "Position saved successfully.",
				positionService.savePosition(positionDto));
	}

	/**
	 * for update or modify position
	 * 
	 * @param id
	 * @param positionDto
	 * @return
	 */

	@PutMapping("/update/{id}")
	public ApiResponse<ReturnId> updatePositionById(@PathVariable int id, @RequestBody PositionDto positionDto) {

		return new ApiResponse<>(HttpStatus.OK.value(), "Position updated successfully.",
				positionService.updatePosition(id, positionDto));

	}

	/**
	 * to delete position
	 * 
	 * @param id
	 * @return
	 */

	@DeleteMapping("/delete/{id}")
	public ApiResponse<ReturnId> deleteIntervieweeById(@PathVariable int id) {

		positionService.deleteposition(id);
		return new ApiResponse<>(HttpStatus.OK.value(), "Position deleted successfully.", null);

	}

	

}

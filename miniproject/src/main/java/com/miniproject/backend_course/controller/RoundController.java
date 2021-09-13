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
import com.miniproject.backend_course.dto.RoundDto;
import com.miniproject.backend_course.service.RoundService;

@RestController
@RequestMapping("/api/round")
public class RoundController {

	@Autowired
	RoundService roundservice;

	/**
	 * to display all the round
	 * 
	 * @return
	 */

	@GetMapping("/list")
	public ApiResponse<List<RoundDto>> findAllRound() {
		return new ApiResponse<>(HttpStatus.OK.value(), "Round list fetched successfully.", roundservice.getroRounds());
	}

	/**
	 * to display specific round detail
	 * 
	 * @param id
	 * @return
	 */

	@GetMapping("/view/{id}")
	public ApiResponse<RoundDto> findRoundById(@PathVariable int id) {

		return new ApiResponse<>(HttpStatus.OK.value(), "Round fetched successfully.", roundservice.getroRoundById(id));
	}

	/**
	 * to add the round details
	 * 
	 * @param roundDto
	 * @return
	 */

	@PostMapping("/add")
	public ApiResponse<RoundDto> addRound(@Valid @RequestBody RoundDto roundDto) throws Exception {
		return new ApiResponse<>(HttpStatus.OK.value(), "Round saved successfully.", roundservice.saveRound(roundDto));
	}

	/**
	 * to update the round details
	 * 
	 * @param id
	 * @param roundDto
	 * @return
	 */

	@PutMapping("/update/{id}")
	public ApiResponse<RoundDto> updateRoundById(@PathVariable int id, @RequestBody RoundDto roundDto) {

		return new ApiResponse<>(HttpStatus.OK.value(), "Round updated successfully.",
				roundservice.updateRound(id, roundDto));

	}

	/**
	 * to delete round detail
	 * 
	 * @param id
	 * @return
	 */

	@DeleteMapping("/delete/{id}")
	public ApiResponse<Void> deleteRoundById(@PathVariable int id) {

		roundservice.deleteRound(id);
		return new ApiResponse<>(HttpStatus.OK.value(), "Round deleted successfully.", null);

	}

	/*
	 * @GetMapping("/list") public List<RoundDto> getAllRound() { return
	 * roundservice.getroRounds(); }
	 * 
	 * @GetMapping("/view/{id}") public RoundDto findRoundById(@PathVariable("id")
	 * int id) { return roundservice.getroRoundById(id);
	 * }
	 * @PostMapping("/add") public RoundDto addRound(@Valid @RequestBody RoundDto
	 * roundDto)throws Exception { return roundservice.saveRound(roundDto); }
	 * 
	 * @PutMapping("/update/{id}") public RoundDto updateroundById(@PathVariable int
	 * id, @RequestBody RoundDto roundDto) { return roundservice.updateRound(id,
	 * roundDto); }
	 * 
	 * @DeleteMapping("/delete/{id}") public String
	 * deleteRoundById(@PathVariable("id") int id) { return
	 * roundservice.deleteRound(id); }
	 * 
	 */

}

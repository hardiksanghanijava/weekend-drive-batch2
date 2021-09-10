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

import com.miniproject.backend_course.dto.RoundDto;
import com.miniproject.backend_course.entity.Round;
import com.miniproject.backend_course.exception.RoundNotFoundException;
import com.miniproject.backend_course.service.RoundService;

@RestController
@RequestMapping("/api/round")
public class RoundController {

	@Autowired
	RoundService roundservice;

	@GetMapping("/list")
	public List<Round> getAllRound() {
		return roundservice.getroRounds();
	}

	@GetMapping("/view/{id}")
	public Round findRoundById(@PathVariable("id") int id) {

		Round round = this.roundservice.getroRoundById(id);

		if (round == null) {
			throw new RoundNotFoundException("invalid interviewer id " + id);

		}

		return round;

	}

	/**
	 * @param roundDto
	 * @return
	 */
	@PostMapping("/add")
	public Round addRound(@Valid @RequestBody RoundDto roundDto) {
		Round round = roundservice.convertToRoundEntity(roundDto);

		return roundservice.saveRound(round);
	}

	/**
	 * @param id
	 * @param roundDto
	 * @return
	 */
	@PutMapping("/update/{id}")
	public Round updateroundById(@PathVariable int id, @RequestBody RoundDto roundDto) {
		Round round = roundservice.convertToRoundEntity(roundDto);
		Round round1 = roundservice.getroRoundById(id);
		if (round1 == null) {
			throw new RoundNotFoundException("id--" + id);
		}
		return this.roundservice.updateRound(round1, round);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteRoundById(@PathVariable("id") int id) {
		Round round = this.roundservice.getroRoundById(id);
		if (round == null) {
			throw new RoundNotFoundException("id--" + id);
		} else {
			return this.roundservice.deleteRound(id);
		}
	}

}

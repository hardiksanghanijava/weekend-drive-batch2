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


import com.miniproject.backend_course.converter.RoundConverter;
import com.miniproject.backend_course.dto.RoundDto;
import com.miniproject.backend_course.entity.Round;
import com.miniproject.backend_course.exception.RoundNotFoundException;
import com.miniproject.backend_course.service.RoundService;

@RestController
@RequestMapping("/api")
public class RoundController {

	@Autowired
	RoundService roundservice;
	@Autowired
	RoundConverter roundConverter;
     
	
	
	@GetMapping("/round/list")
	public List<RoundDto> getAllRound() {
		List<Round> findall = this.roundservice.getroRounds();
		return roundConverter.entityToDto(findall);
	}
	
	@GetMapping("/api/round/view/{id}")
	public RoundDto getRoundById(@PathVariable("id") int id) {

		Round round = this.roundservice.getroRound(id);

		if (round == null) {
			throw new RoundNotFoundException("invalid interviewer id " + id);

		}

		return roundConverter.entityToDto(round);

	}
	
	

	@PostMapping("/api/round/add")
	public RoundDto addRoundById(@Valid @RequestBody RoundDto roundDto) {
		Round round  = roundConverter.dtoToEntity(roundDto);
		round = roundservice.addRound(round);
		return roundConverter.entityToDto(round);
	}
	
	
	

	@PutMapping("/api/round/update/")
	public Round updateround(@RequestBody Round round) {

		return this.roundservice.updateRound(round);
	}

	@DeleteMapping("/api/round/delete/{roundid}")
	public String deleteround(@PathVariable("roundid") int roundid) {
		Round round = this.roundservice.getroRound(roundid);
		if (round == null) {
			throw new RoundNotFoundException("id--" + roundid);
		} else {
			return this.roundservice.deleteRound(roundid);
		}
	}

}

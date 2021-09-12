package com.miniproject.backend_course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.backend_course.dto.RoundDto;
import com.miniproject.backend_course.entity.Round;
import com.miniproject.backend_course.exception.RoundNotFoundException;
import com.miniproject.backend_course.repository.RoundDao;

@Service
public class RoundServiceImpl implements RoundService {
	@Autowired
	private RoundDao roundrepository;

	@Autowired
	private RoundDto roundDto;

	@Override
	public List<RoundDto> getroRounds() {
		List<Round> round = roundrepository.findAll();
		List<RoundDto> roundDtos = new ArrayList<>();
		for (Round round2 : round) {
			roundDtos.add(roundDto.convertToRoundDto(round2));
		}
		return roundDtos;

	}

	@Override
	public RoundDto getroRoundById(int id) {
		Round round = roundrepository.findById(id).orElse(null);
		if (round == null) {
			throw new RoundNotFoundException("invalid round id" + id);

		}
		RoundDto roundDto1 = roundDto.convertToRoundDto(round);
		return roundDto1;

	}

	@Override
	public String deleteRound(int id) {

		Round round = roundrepository.findById(id).orElse(null);
		if (round == null) {
			throw new RoundNotFoundException("Invalid Round" + id);
		}
		roundrepository.deleteById(id);
		return "round removed" + id;
	}

	@Override
	public RoundDto saveRound(RoundDto roundDto) throws Exception {
		Round round = roundDto.convertToRoundEntity(roundDto);
		Round round2 = roundrepository.save(round);
		System.out.println(round2);
		System.out.println(roundDto.convertToRoundDto(round2));
		return roundDto.convertToRoundDto(round2);
	}

	@Override
	public RoundDto updateRound(int id, RoundDto roundDto) {
		Round r1 = roundrepository.findById(id).orElse(null);
		if (r1 == null) {
			throw new RoundNotFoundException("Invalid round id" + id);

		}
	   
		BeanUtils.copyProperties(roundDto, r1);
		roundrepository.save(r1);
		return roundDto.convertToRoundDto(r1);
	}

}

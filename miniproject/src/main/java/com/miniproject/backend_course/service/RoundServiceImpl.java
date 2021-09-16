package com.miniproject.backend_course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.backend_course.dto.RoundDto;
import com.miniproject.backend_course.entity.ReturnId;
import com.miniproject.backend_course.entity.Round;
import com.miniproject.backend_course.exception.RoundNotFoundException;
import com.miniproject.backend_course.repository.RoundRepository;

@Service
public class RoundServiceImpl implements RoundService {
	@Autowired
	private RoundRepository roundrepository;



	@Override
	public List<RoundDto> getroRounds() {
		List<Round> round = roundrepository.findAll();
		List<RoundDto> roundDtos = new ArrayList<>();
		for (Round round2 : round) {
			roundDtos.add(RoundDto.convertToRoundDto(round2));
		}
		return roundDtos;

	}

	@Override
	public RoundDto getroRoundById(int id) {
		Round round = roundrepository.findById(id).orElse(null);
		if (round == null) {
			throw new RoundNotFoundException("invalid round id" + id);

		}
		RoundDto roundDto = RoundDto.convertToRoundDto(round);
		return roundDto;

	}

	@Override
	public ReturnId deleteRound(int id) {

		Round round = roundrepository.findById(id).orElse(null);
		if (round == null) {
			throw new RoundNotFoundException("Invalid Round" + id);
		}
		roundrepository.deleteById(id);
	     return new  ReturnId(id);
	}

	@Override
	public ReturnId saveRound(RoundDto roundDto) throws Exception {
		Round round = RoundDto.convertToRoundEntity(roundDto);
		Round roundentity = roundrepository.save(round);
		System.out.println(roundentity);
		System.out.println(RoundDto.convertToRoundDto(roundentity));
		return new ReturnId(RoundDto.convertToRoundDto(roundentity).getId());
	}

	@Override
	public ReturnId updateRound(int id, RoundDto roundDto) {
		Round round = roundrepository.findById(id).orElse(null);
		if (round == null) {
			throw new RoundNotFoundException("Invalid round id" + id);

		}
	   
		BeanUtils.copyProperties(roundDto, round);
		roundrepository.save(round);
		return new ReturnId(RoundDto.convertToRoundDto(round).getId());
	}

}

package com.miniproject.backend_course.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.backend_course.dto.RoundDto;
import com.miniproject.backend_course.entity.Round;
import com.miniproject.backend_course.repository.RoundDao;

@Service
public class RoundServiceImpl implements RoundService {
	@Autowired
	private RoundDao roundDao;

	@Override
	public List<Round> getroRounds() {
		return roundDao.findAll();

	}

	@Override
	public Round getroRoundById(int id) {

		return roundDao.findById(id).orElse(null);
	}

	@Override
	public String deleteRound(int id) {
		roundDao.deleteById(id);
		return "Round deleted" + id;
	}

	@Override
	public Round saveRound(Round round) {
		roundDao.save(round);
		return round;
	}

	@Override
	public Round updateRound(Round round1, Round round) {
		Round r1 = roundDao.findById(round1.getId()).orElse(null);
		r1.setName(round.getName());
		r1.setSequence(round.getSequence());
		return roundDao.save(r1);
	}

	public Round convertToRoundEntity(RoundDto roundDto) {
		ModelMapper modelMapper = new ModelMapper();
		Round round = modelMapper.map(roundDto, Round.class);
		return round;
	}

}

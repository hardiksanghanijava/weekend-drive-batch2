package com.miniproject.backend_course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Round getroRound(int id) {
		
		return roundDao.findById(id).orElse(null);
	}

	

	@Override
	public String deleteRound(int id) {
		roundDao.deleteById(id);
		return "Round deleted"+id;
	}

	

	@Override
	public Round addRound(Round round) {
		roundDao.save(round);
		return round;
	}

	@Override
	public Round updateRound(Round round) {
	      Round r1 = roundDao.findById(round.getId()).orElse(null);
	      r1.setName(round.getName());
	      r1.setSeq(round.getSeq());
		return roundDao.save(r1);
	}

	

}

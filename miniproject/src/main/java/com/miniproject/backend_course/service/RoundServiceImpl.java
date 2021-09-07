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
	public Round getroRound(long id) {
		
		return roundDao.findById(id);
	}

	

	@Override
	public void deleteRound(long id) {
		roundDao.deleteById(id);
		
	}

	@Override
	public void updateRound(Round round, int roundid) {
		   round.setId(roundid);
		   roundDao.save(round);
		
	}

	@Override
	public Round addround(Round round) {
		roundDao.save(round);
		return round;
	}

}

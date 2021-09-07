package com.miniproject.backend_course.service;

import java.util.List;

import com.miniproject.backend_course.entity.Round;





public interface RoundService {
	
	public List<Round> getroRounds();

	public Round getroRound(long positionid);

    public void deleteRound(long parseLong);


	public void updateRound(Round positions, int positionid);

	public Round addround(Round round);

}

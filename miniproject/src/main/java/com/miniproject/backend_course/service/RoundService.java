package com.miniproject.backend_course.service;

import java.util.List;

import com.miniproject.backend_course.entity.Round;





public interface RoundService {
	
	public List<Round> getroRounds();

	public Round getroRound(int positionid);

    public String deleteRound(int id);


	

	

	public Round updateRound(Round round);

	

	public Round addRound(Round round);

}

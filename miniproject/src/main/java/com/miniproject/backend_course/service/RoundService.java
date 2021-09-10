package com.miniproject.backend_course.service;

import java.util.List;

import com.miniproject.backend_course.dto.RoundDto;
import com.miniproject.backend_course.entity.Round;

public interface RoundService {

	public List<Round> getroRounds();

	public Round getroRoundById(int positionid);

	public String deleteRound(int id);

	public Round updateRound(Round round1, Round round);

	public Round saveRound(Round round);

	public Round convertToRoundEntity(RoundDto roundDto);

}

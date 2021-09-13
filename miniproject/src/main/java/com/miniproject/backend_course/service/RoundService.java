package com.miniproject.backend_course.service;

import java.util.List;

import com.miniproject.backend_course.dto.RoundDto;

public interface RoundService {

	public List<RoundDto> getroRounds();

	public RoundDto getroRoundById(int positionid);

	public void deleteRound(int id);

	public RoundDto updateRound(int id, RoundDto roundDto);

	public RoundDto saveRound(RoundDto roundDto)throws Exception;

	
}

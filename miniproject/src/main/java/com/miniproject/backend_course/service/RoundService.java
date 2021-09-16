package com.miniproject.backend_course.service;

import java.util.List;

import com.miniproject.backend_course.dto.RoundDto;
import com.miniproject.backend_course.entity.ReturnId;

public interface RoundService {

	public List<RoundDto> getroRounds();

	public RoundDto getroRoundById(int positionid);

	public ReturnId deleteRound(int id);

	public ReturnId updateRound(int id, RoundDto roundDto);

	public ReturnId saveRound(RoundDto roundDto)throws Exception;

	
}

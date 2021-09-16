package com.miniproject.backend_course.service;

import java.util.List;

import com.miniproject.backend_course.dto.PositionDto;
import com.miniproject.backend_course.entity.ReturnId;

public interface PositionService {

	public List<PositionDto> getPositions();

	public ReturnId savePosition(PositionDto positionDto)throws Exception;
	public PositionDto getPositionsById(int positionid);

	

	public ReturnId deleteposition(int positionid);

	

	public ReturnId updatePosition(int id, PositionDto positionDto);

}

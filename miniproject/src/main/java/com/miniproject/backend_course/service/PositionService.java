package com.miniproject.backend_course.service;

import java.util.List;

import com.miniproject.backend_course.dto.PositionDto;

public interface PositionService {

	public List<PositionDto> getPositions();

	public PositionDto savePosition(PositionDto positionDto)throws Exception;
	public PositionDto getPositionsById(int positionid);

	

	public void deleteposition(int positionid);

	

	public PositionDto updatePosition(int id, PositionDto positionDto);

}

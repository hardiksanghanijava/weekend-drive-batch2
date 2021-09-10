package com.miniproject.backend_course.service;

import java.util.List;

import javax.validation.Valid;

import com.miniproject.backend_course.dto.PositionDto;
import com.miniproject.backend_course.entity.Positions;

public interface PositionService {

	public List<Positions> getPositions();

	public Positions getPositionsById(int positionid);

	public Positions savePosition(Positions positions);

	public String deleteposition(int positionid);

	public Positions convertToPositionEntity(@Valid PositionDto positionDto);

	public Positions updatePosition(Positions positions1, Positions positions);

}

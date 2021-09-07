package com.miniproject.backend_course.service;

import java.util.List;

import com.miniproject.backend_course.entity.Positions;



public interface PositionService {
      
	public List<Positions> getPositions();

	public Positions getPosition(long positionid);

	public Positions addPosition(Positions positions);

	public void deletePostion(long parseLong);

	//public Positions updatePosition(Positions positions);

	public void updatePosition(Positions positions, int positionid);
	
}

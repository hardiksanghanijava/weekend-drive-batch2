package com.miniproject.backend_course.service;

import java.util.List;

import com.miniproject.backend_course.entity.Positions;



public interface PositionService {
      
	public List<Positions> getPositions();

	public Positions getPosition(int positionid);

	public Positions addPosition(Positions positions);



	

	public Positions updatePosition(Positions positions);

	

	public String deleteposition(int positionid);

	
	
}

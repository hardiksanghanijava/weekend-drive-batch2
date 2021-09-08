package com.miniproject.backend_course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.miniproject.backend_course.entity.Positions;
import com.miniproject.backend_course.repository.PositionDao;



@Service
public class PositionServiceimpl implements PositionService {
	@Autowired
	private PositionDao positionrepositiory;

	@Override
	public List<Positions> getPositions() {
		
		return positionrepositiory.findAll();
	}

	@Override
	public Positions getPosition(int positionid) {
		 return positionrepositiory.findById(positionid).orElse(null);
		
	}

	@Override
	public Positions addPosition(Positions positions) {
		return positionrepositiory.save(positions);
	}

	

	@Override
	public Positions updatePosition(Positions positions) {
		 Positions position = positionrepositiory.findById(positions.getId()).orElse(null);
	
	     position.setDescriptionString(positions.getDescriptionString());
	     position.setTitle(positions.getTitle());
		return positionrepositiory.save(position);
	}

	@Override
	public String deleteposition(int positionid) {
		positionrepositiory.deleteById(positionid);
		
		return "Position deleted "+positionid;
	}
	
	
	

}

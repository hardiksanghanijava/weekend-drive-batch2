package com.miniproject.backend_course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.backend_course.entity.Positions;
import com.miniproject.backend_course.repository.PositionDao;



@Service
public class PositionServiceimpl implements PositionService {
	@Autowired
	private PositionDao positionDao;
	
	@Override
	public List<Positions> getPositions() {
		return positionDao.findAll();
	}

	//@SuppressWarnings("deprecation")
	@Override
	public Positions getPosition(long positionid) {
		return positionDao.findById(positionid);
	}

	@Override
	public Positions addPosition(Positions positions) {
		positionDao.save(positions);
		return positions;
	}

@Override
	public void deletePostion(long id) {
	
		positionDao.deleteById(id);
	}

//	@Override
//	public Positions updatePosition(Positions positions) {
//		positionDao.save(positions);
//		return positions;
//	}

	@Override
	public void updatePosition(Positions positions, int positionid) {
		positions.setId(positionid);
		positionDao.save(positions);
		
		
	}
	

}

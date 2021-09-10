package com.miniproject.backend_course.service;

import java.util.List;

import javax.persistence.RollbackException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.backend_course.dto.PositionDto;
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
	public Positions getPositionsById(int positionid) {
		return positionrepositiory.findById(positionid).orElse(null);

	}

	@Override
	public Positions savePosition(Positions positions) throws RollbackException {
		return positionrepositiory.save(positions);
	}

	@Override
	public Positions updatePosition(Positions positions1, Positions positions) {
		Positions p1 = positionrepositiory.findById(positions1.getId()).orElse(null);

		p1.setDescription(positions.getDescription());
		p1.setTitle(positions.getTitle());
		return positionrepositiory.save(p1);
	}

	@Override
	public String deleteposition(int positionid) {
		positionrepositiory.deleteById(positionid);

		return "Position deleted " + positionid;
	}

	@Override
	public Positions convertToPositionEntity(PositionDto positionDto) {
		ModelMapper modelMapper = new ModelMapper();
		Positions positions = modelMapper.map(positionDto, Positions.class);
		return positions;

	}

}

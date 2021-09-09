package com.miniproject.backend_course.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.miniproject.backend_course.dto.PositionDto;
import com.miniproject.backend_course.entity.Positions;

@Component
public class PositionConverter {

	public PositionDto entityToDto(Positions positions) {

		PositionDto dto = new PositionDto();
		dto.setId(positions.getId());
		dto.setTitle(positions.getTitle());
		dto.setDescriString(positions.getDescriptionString());

		return dto;

	}

	public List<PositionDto> entityToDto(List<Positions> positions) {

		return positions.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

	public Positions dtoToEntity(PositionDto positionDto) {

		Positions sto = new Positions();
		sto.setId(positionDto.getId());
		sto.setTitle(positionDto.getTitle());
		sto.setDescriptionString(positionDto.getDescriString());

		return sto;

	}
	
	

	public List<Positions> dtoToEntity(List<PositionDto> positionDtos) {

		return positionDtos.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

}
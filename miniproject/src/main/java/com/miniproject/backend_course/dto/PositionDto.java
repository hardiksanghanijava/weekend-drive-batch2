package com.miniproject.backend_course.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.miniproject.backend_course.entity.Positions;

@Component
@DTO
public class PositionDto {

	@Id
	@GeneratedValue
	private int id;

	private String title;
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	public Positions convertToPositionEntity(PositionDto positionDto) {
		ModelMapper modelMapper = new ModelMapper();
		Positions positions = modelMapper.map(positionDto, Positions.class);
		return positions;
	}
	
	public PositionDto convertToPositionDto(Positions positions) {
		ModelMapper modelMapper = new ModelMapper();
		PositionDto positionDto = modelMapper.map(positions, PositionDto.class);
		return positionDto;
	}

}

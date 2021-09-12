package com.miniproject.backend_course.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.miniproject.backend_course.entity.Round;
@Component
@DTO
public class RoundDto {

	@Id
	@GeneratedValue
	private int id;
	private String name;
	private int sequence;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public Round convertToRoundEntity(RoundDto roundDto) {
		ModelMapper modelMapper = new ModelMapper();
		Round round = modelMapper.map(roundDto, Round.class);
		return round;
	}

	public RoundDto convertToRoundDto(Round round) {
		ModelMapper modelMapper = new ModelMapper();
		RoundDto roundDto = modelMapper.map(round, RoundDto.class);
		return roundDto;
	}

}

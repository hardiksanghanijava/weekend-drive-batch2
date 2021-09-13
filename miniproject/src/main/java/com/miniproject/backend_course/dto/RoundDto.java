package com.miniproject.backend_course.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.modelmapper.ModelMapper;
import com.miniproject.backend_course.entity.Round;

@DTO
public class RoundDto {

	@Id
	@GeneratedValue
	private int id;
	@NotNull(message = "Not empty")
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

	public static Round convertToRoundEntity(RoundDto roundDto) {
		ModelMapper modelMapper = new ModelMapper();
		Round round = modelMapper.map(roundDto, Round.class);
		return round;
	}

	public static RoundDto convertToRoundDto(Round round) {
		ModelMapper modelMapper = new ModelMapper();
		RoundDto roundDto = modelMapper.map(round, RoundDto.class);
		return roundDto;
	}

}

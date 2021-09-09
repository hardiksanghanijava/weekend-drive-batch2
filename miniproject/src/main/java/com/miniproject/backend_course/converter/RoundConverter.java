package com.miniproject.backend_course.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.miniproject.backend_course.dto.RoundDto;
import com.miniproject.backend_course.entity.Round;

@Component
public class RoundConverter {

	public RoundDto entityToDto(Round round) {

		RoundDto dto = new RoundDto();
		
		
        dto.setId(round.getId());
        dto.setName(round.getName());
        dto.setSeq(round.getSeq());
		return dto;

	}

	public List<RoundDto> entityToDto(List<Round> round) {

		return round.stream().map(x -> entityToDto(x)).collect(Collectors.toList());

	}

	public Round dtoToEntity(RoundDto roundDto) {

		Round sto = new Round();
		
		 sto.setId(roundDto.getId());
	        sto.setName(roundDto.getName());
	        sto.setSeq(roundDto.getSeq());

		return sto;

	}
	
	

	public List<Round> dtoToEntity(List<RoundDto> roundDtos) {

		return roundDtos.stream().map(x -> dtoToEntity(x)).collect(Collectors.toList());
	}

}
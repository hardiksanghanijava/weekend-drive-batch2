package com.miniproject.backend_course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.backend_course.dto.PositionDto;
import com.miniproject.backend_course.entity.Positions;
import com.miniproject.backend_course.entity.ReturnId;
import com.miniproject.backend_course.exception.IntervieweeNotFoundException;
import com.miniproject.backend_course.exception.PositionNotFoundException;
import com.miniproject.backend_course.repository.PositionRepository;

@Service
public class PositionServiceimpl implements PositionService {
	@Autowired
	private PositionRepository positionrepositiory;


	@Override
	public List<PositionDto> getPositions() {
          List<Positions> positions = positionrepositiory.findAll();
          List<PositionDto> positionDtos = new ArrayList<>();
          for (Positions position:positions) {
        	  positionDtos.add(PositionDto.convertToPositionDto(position));
  		}
          return positionDtos;
       
		
	}

	

	@Override
	public PositionDto getPositionsById(int id) {
		Positions positions = positionrepositiory.findById(id).orElse(null);
		if (positions==null) {
			throw new PositionNotFoundException("invalid position id"+id);
			
		}
	   PositionDto positionDto = PositionDto.convertToPositionDto(positions);
	   return positionDto;

	}
	
	
	public ReturnId savePosition(PositionDto positionDto)throws Exception {
		
		Positions positions= PositionDto.convertToPositionEntity(positionDto);
		Positions position= positionrepositiory.save(positions);
		System.out.println(position);
		System.out.println(PositionDto.convertToPositionDto(position));
		return new ReturnId(PositionDto.convertToPositionDto(position).getId());
	}



	@Override
	public ReturnId deleteposition(int id) {
	     Positions positions = positionrepositiory.findById(id).orElse(null);
	     if (positions==null) {
	    	 throw new IntervieweeNotFoundException("Invalid Position"+id);
			
		}
	     positionrepositiory.deleteById(id);
	     return new ReturnId(id);
	}
	
	
	public ReturnId updatePosition(int id, PositionDto positionDto) {
		  Positions positions = positionrepositiory.findById(id).orElse(null);
		  if (positions==null) {
               throw new PositionNotFoundException("invalid position--"+id);			
		}
		  BeanUtils.copyProperties(positionDto, positions);
		  positionrepositiory.save(positions);
		  return new ReturnId(PositionDto.convertToPositionDto(positions).getId());
		
	}
    
}

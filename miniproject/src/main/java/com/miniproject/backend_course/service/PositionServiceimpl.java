package com.miniproject.backend_course.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.miniproject.backend_course.dto.PositionDto;
import com.miniproject.backend_course.entity.Positions;
import com.miniproject.backend_course.exception.IntervieweeNotFoundException;
import com.miniproject.backend_course.exception.PositionNotFoundException;
import com.miniproject.backend_course.repository.PositionDao;

@Service
public class PositionServiceimpl implements PositionService {
	@Autowired
	private PositionDao positionrepositiory;


	@Override
	public List<PositionDto> getPositions() {
          List<Positions> positions = positionrepositiory.findAll();
          List<PositionDto> positionDtos = new ArrayList<>();
          for (Positions positions1:positions) {
        	  positionDtos.add(PositionDto.convertToPositionDto(positions1));
  		}
          return positionDtos;
       
		
	}

	

	@Override
	public PositionDto getPositionsById(int id) {
		Positions positions = positionrepositiory.findById(id).orElse(null);
		if (positions==null) {
			throw new PositionNotFoundException("invalid position id"+id);
			
		}
	   PositionDto positionDto1 = PositionDto.convertToPositionDto(positions);
	   return positionDto1;

	}
	
	
	public PositionDto savePosition(PositionDto positionDto)throws Exception {
		
		Positions positions= PositionDto.convertToPositionEntity(positionDto);
		Positions positions2= positionrepositiory.save(positions);
		System.out.println(positions2);
		System.out.println(PositionDto.convertToPositionDto(positions2));
		return PositionDto.convertToPositionDto(positions2);
	}



	@Override
	public String deleteposition(int id) {
	     Positions positions = positionrepositiory.findById(id).orElse(null);
	     if (positions==null) {
	    	 throw new IntervieweeNotFoundException("Invalid Position"+id);
			
		}
	     positionrepositiory.deleteById(id);
	     return "position removed "+id;
	}
	
	
	public PositionDto updatePosition(int id, PositionDto positionDto) {
		  Positions positions = positionrepositiory.findById(id).orElse(null);
		  if (positions==null) {
               throw new PositionNotFoundException("invalid position--"+id);			
		}
		  BeanUtils.copyProperties(positionDto, positions);
		  positionrepositiory.save(positions);
		  return PositionDto.convertToPositionDto(positions);
		
	}
    
}

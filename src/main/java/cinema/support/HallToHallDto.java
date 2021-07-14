package cinema.support;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Hall;
import cinema.model.ProjectionType;
import cinema.model.Seat;
import cinema.web.dto.HallDto;

@Component
public class HallToHallDto implements Converter<Hall, HallDto> {
	
	@Autowired
	private ProjectionTypeToProjectionTypeDto toPTDto;
	@Autowired 
	SeatToSeatDto toSeatDto;
	
	
	@Override
	public HallDto convert(Hall source) {
		HallDto dto = new HallDto();
		
		dto.setId(source.getId());
		dto.setHallName(source.getHallName());
		List<ProjectionType> projectionTypes = new ArrayList<>(source.getProjectionTypes());
		dto.setProjectionTypes(new HashSet<>(toPTDto.convert(projectionTypes)));
		List<Seat> seats = new ArrayList<>(source.getSeats());
		dto.setSeats(new HashSet<>(toSeatDto.convert(seats)));
		
		return dto;
	}
	
	public List<HallDto> convert(List<Hall> source){
        List<HallDto> dtoS = new ArrayList<>();

        for(Hall s : source) {
        	dtoS.add(convert(s));
        }

        return dtoS;
    }

}

package cinema.support;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Projection;
import cinema.web.dto.ProjectionDto;

@Component
public class ProjectionToProjectionDto implements Converter<Projection, ProjectionDto> {
	
	
	@Override
	public ProjectionDto convert(Projection source) {
		ProjectionDto dto = new ProjectionDto();
		
		dto.setId(source.getId());
		
		dto.setMovieId(source.getMovie().getId());
		dto.setMovieName(source.getMovie().getMovieName());
		
		dto.setProjectionTypeId(source.getProjectionType().getId());
		dto.setProjectionTypeName(source.getProjectionType().getProjectionTypeName());
		
		dto.setHallId(source.getHall().getId());
		dto.setHallName(source.getHall().getHallName());
		
		dto.setDateAndTime(source.getDateAndTime().toString());
		LocalDateTime end = source.getDateAndTime().plusMinutes(Long.valueOf(source.getMovie().getDuration()));
		dto.setDateAndTimeEnd(end.toString());
		dto.setAdmin(source.getAdmin());
		dto.setTicketPrice(source.getTicketPrice());
		
		
		return dto;
	}
	
	 public List<ProjectionDto> convert(List<Projection> projections){
	        List<ProjectionDto> projectionsDto = new ArrayList<>();

	        for(Projection projection : projections) {
	        	projectionsDto.add(convert(projection));
	        }

	        return projectionsDto;
	    }

}

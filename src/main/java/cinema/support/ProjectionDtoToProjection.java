package cinema.support;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Projection;
import cinema.service.HallService;
import cinema.service.MovieService;
import cinema.service.ProjectionService;
import cinema.service.ProjectionTypeService;
import cinema.web.dto.ProjectionDto;

@Component
public class ProjectionDtoToProjection implements Converter<ProjectionDto, Projection> {
	@Autowired
	private ProjectionService pService;
	@Autowired
	private MovieService mService;
	@Autowired
	private HallService hService;
	@Autowired
	private ProjectionTypeService ptService;

	@Override
	public Projection convert(ProjectionDto dto) {
		
		Projection projection;

        if(dto.getId() == null){
        	projection = new Projection();
        }else{
        	projection = pService.findOne(dto.getId());
        }

        if(projection != null){
        	
        	projection.setMovie(mService.findOne(dto.getMovieId()));
        	projection.setProjectionType(ptService.findOne(dto.getProjectionTypeId()));
        	projection.setHall(hService.findOne(dto.getHallId()));
        	projection.setProjectionStart(getLocalDateTime(dto.getProjectionStart()));
        	projection.setProjectionEnd(projection.getProjectionStart().plusMinutes(Long.valueOf(projection.getMovie().getDuration())));
        	projection.setAdmin(dto.getAdmin());
        	 
        	projection.setTicketPrice(dto.getTicketPrice());
        }
        return projection;
		
		
	}
	
	 private LocalDateTime getLocalDateTime(String datumIVreme) throws DateTimeParseException {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
	        return LocalDateTime.parse(datumIVreme, formatter);
	    }

}

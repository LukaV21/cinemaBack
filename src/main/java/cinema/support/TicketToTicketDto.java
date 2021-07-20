package cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Ticket;
import cinema.web.dto.TicketDto;

@Component
public class TicketToTicketDto implements Converter<Ticket, TicketDto> {
	
	@Autowired
	private SeatToSeatDto toSeatDto;

	@Override
	public TicketDto convert(Ticket source) {
		TicketDto dto = new TicketDto();
		
		dto.setId(source.getId());
		dto.setReserved(source.getReserved().toString());
		dto.setUser(source.getUser());
		
		dto.setProjectionId(source.getProjection().getId());
		dto.setSeatId(source.getSeat().getId());
		dto.setSeatNumber(source.getSeat().getSeatNumber());
		
		
		return dto;
	}
		
	public List<TicketDto> convert(List<Ticket> source){
        List<TicketDto> dtoS = new ArrayList<>();

        for(Ticket s : source) {
        	dtoS.add(convert(s));
        }

        return dtoS;
    }

}

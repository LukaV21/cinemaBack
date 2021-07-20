package cinema.support;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Ticket;
import cinema.service.ProjectionService;
import cinema.service.SeatService;
import cinema.service.TicketService;
import cinema.web.dto.TicketDto;

@Component
public class TicketDtoToTicket implements Converter<TicketDto, Ticket> {
	
	
	@Autowired
	private TicketService tService;
	@Autowired
	private ProjectionService pService;
	@Autowired
	private SeatService sService;

	@Override
	public Ticket convert(TicketDto source) {
		Ticket ticket;

        if(source.getId() == null){
        	ticket = new Ticket();
        }else{
        	ticket = tService.findOne(source.getId());
        }

        if(ticket != null){
        	ticket.setSeat(sService.findOne(source.getSeatId()));
        	ticket.setProjection(pService.findOne(source.getProjectionId()));
        	ticket.setReserved(LocalDateTime.now());
        	ticket.setUser(source.getUser());
        	
        	
        }
        return ticket;
		
		
	}

}

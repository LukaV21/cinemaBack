package cinema.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.Ticket;
import cinema.service.TicketService;
import cinema.support.TicketDtoToTicket;
import cinema.support.TicketToTicketDto;
import cinema.web.dto.TicketDto;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping(value = "/api/tickets", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiTicketsController {
	
	@Autowired
	private TicketService tService;
	@Autowired
	private TicketToTicketDto toDto;
	@Autowired
	private TicketDtoToTicket toTicket;
	
	
	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping
    public ResponseEntity<List<TicketDto>> getAll(){

        List<Ticket> tickets = tService.findAll();

        return new ResponseEntity<>(toDto.convert(tickets), HttpStatus.OK);
    }
	
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TicketDto> create(@Valid @RequestBody TicketDto dto, Authentication authentication){
		dto.setId(null);
		dto.setUser(authentication.getName());
		Ticket ticket = toTicket.convert(dto);
		
		if (ticket.getSeat() == null || ticket.getProjection() == null) {
			 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Ticket saved = tService.save(ticket);

        return new ResponseEntity<>(toDto.convert(saved), HttpStatus.CREATED);
    }

}

package cinema.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.service.TicketService;
import cinema.support.TicketDtoToTicket;
import cinema.support.TicketToTicketDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/api/tickets", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiTicketsController {
	
	@Autowired
	private TicketService tService;
	@Autowired
	private TicketToTicketDto toDto;
	@Autowired
	private TicketDtoToTicket toTicket;

}

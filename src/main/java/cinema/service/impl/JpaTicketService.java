package cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.repository.TicketRepository;
import cinema.service.TicketService;

@Service
public class JpaTicketService implements TicketService{
	
	@Autowired
	private TicketRepository tRepository;

}

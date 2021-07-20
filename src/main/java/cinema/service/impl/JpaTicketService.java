package cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.Ticket;
import cinema.repository.TicketRepository;
import cinema.service.TicketService;

@Service
public class JpaTicketService implements TicketService{
	
	@Autowired
	private TicketRepository tRepository;

	@Override
	public List<Ticket> findAll() {
		return tRepository.findAll();
	}

	@Override
	public Ticket save(Ticket ticket) {
		return tRepository.save(ticket);
	}

	@Override
	public Ticket findOne(Long id) {
		return tRepository.findOneById(id);
	}

}

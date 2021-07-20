package cinema.service;

import java.util.List;

import cinema.model.Ticket;

public interface TicketService {

	List<Ticket> findAll();

	Ticket save(Ticket ticket);

	Ticket findOne(Long id);

}

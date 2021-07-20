package cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.Seat;
import cinema.repository.SeatRepository;
import cinema.service.SeatService;

@Service
public class JpaSeatService implements SeatService {
	
	@Autowired
	private SeatRepository sRepository;

	@Override
	public List<Seat> findAll() {
		return sRepository.findAll();
	}

	@Override
	public Seat findOne(Long seatId) {
		return sRepository.findOneById(seatId);
	}

}

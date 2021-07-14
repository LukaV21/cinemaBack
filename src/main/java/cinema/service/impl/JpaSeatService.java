package cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.repository.SeatRepository;
import cinema.service.SeatService;

@Service
public class JpaSeatService implements SeatService {
	
	@Autowired
	private SeatRepository sRepository;

}

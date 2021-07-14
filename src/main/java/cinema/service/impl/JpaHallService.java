package cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.repository.HallRepository;
import cinema.service.HallService;

@Service
public class JpaHallService implements HallService {
	
	@Autowired
	private HallRepository hRepository;

}

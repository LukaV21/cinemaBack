package cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.Hall;
import cinema.repository.HallRepository;
import cinema.service.HallService;

@Service
public class JpaHallService implements HallService {
	
	@Autowired
	private HallRepository hRepository;

	@Override
	public List<Hall> findAll() {
		return hRepository.findAll();
	}

	@Override
	public Hall findOne(Long hallId) {
		return hRepository.findOneById(hallId);
	}

}

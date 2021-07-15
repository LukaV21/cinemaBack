package cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.repository.ProjectionRepository;
import cinema.service.ProjectionService;

@Service
public class JpaProjectionService implements ProjectionService{
	
	@Autowired
	private ProjectionRepository pRepository;

}

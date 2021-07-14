package cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.repository.ProjectionTypeRepository;
import cinema.service.ProjectionTypeService;

@Service
public class JpaProjectionTypeService implements ProjectionTypeService {
	
	@Autowired
	private ProjectionTypeRepository ptRepository;

}

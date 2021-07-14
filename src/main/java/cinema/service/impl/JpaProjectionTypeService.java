package cinema.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.model.ProjectionType;
import cinema.repository.ProjectionTypeRepository;
import cinema.service.ProjectionTypeService;

@Service
public class JpaProjectionTypeService implements ProjectionTypeService {
	
	@Autowired
	private ProjectionTypeRepository ptRepository;

	@Override
	public List<ProjectionType> findAll() {
		return ptRepository.findAll();
	}

}

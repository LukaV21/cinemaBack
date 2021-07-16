package cinema.service.impl;

import javax.persistence.EntityManager;


import org.hibernate.Filter;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import cinema.model.Projection;
import cinema.repository.ProjectionRepository;
import cinema.service.ProjectionService;

@Service
public class JpaProjectionService implements ProjectionService{
	
	@Autowired
	private ProjectionRepository pRepository;
	@Autowired
	private EntityManager entityManager;

	@Override
	public Page<Projection> find(Boolean isDeleted, Double ticketPriceFrom, Double ticketPriceTo, Long projectionTypeId,
			Long movieId, Long hallId, int pageNo) {
		Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedProjectionFilter");
        filter.setParameter("isDeleted", isDeleted);
		
		
		if (ticketPriceFrom == null) {
			ticketPriceFrom = 0.0;
        }

        if (ticketPriceTo == null) {
        	ticketPriceTo = Double.MAX_VALUE;
        }		
        Page<Projection> projections = pRepository.search( ticketPriceFrom, ticketPriceTo, projectionTypeId, movieId, hallId, PageRequest.of(pageNo, 4)); 
        session.disableFilter("deletedProjectionFilter");
         return projections;
	}
	

	@Override
	public Page<Projection> findAll(int pageNo) {
		return pRepository.findAll(PageRequest.of(pageNo, 2));
	}


	@Override
	public Projection delete(Long id) {
		Projection projection = pRepository.findOneById(id);
		projection.setDeleted(true);
		pRepository.deleteById(id);
		return projection;
	}

}

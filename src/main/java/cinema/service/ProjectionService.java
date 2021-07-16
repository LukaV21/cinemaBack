package cinema.service;

import org.springframework.data.domain.Page;

import cinema.model.Projection;

public interface ProjectionService {

	Page<Projection> find(Boolean isDeleted, Double ticketPriceFrom, Double ticketPriceTo, Long projectionTypeId,
			Long movieId, Long hallId, int pageNo);

	Page<Projection> findAll(int pageNo);

	Projection delete(Long id);

	Projection findOne(Long id);

	Projection save(Projection projection);

	Projection update(Projection projection);

}

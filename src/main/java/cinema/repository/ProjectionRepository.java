package cinema.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cinema.model.Projection;

@Repository
public interface ProjectionRepository extends JpaRepository<Projection, Long> {

	
	
	
	@Query("SELECT p FROM Projection p WHERE" +
            "(p.ticketPrice BETWEEN :ticketPriceFrom AND :ticketPriceTo) AND "+
            "(:projectionTypeId = NULL OR p.projectionType.id = :projectionTypeId) AND " +
            "(:movieId = NULL OR p.movie.id = :movieId) AND " +
            "(:hallId = NULL OR p.hall.id = :hallId)")
    Page<Projection> search(
                            @Param("ticketPriceFrom") Double ticketPriceFrom, @Param("ticketPriceTo") Double ticketPriceTo,
                            @Param("projectionTypeId") Long projectionTypeId, @Param("movieId") Long movieId, @Param("hallId") Long hallId, Pageable pageable);

	Projection findOneById(Long id);

}

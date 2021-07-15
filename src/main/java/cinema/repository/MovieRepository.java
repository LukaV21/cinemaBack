package cinema.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cinema.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{

	

	Page<Movie> findByMovieNameIgnoreCaseContainsAndGenresIgnoreCaseContainsAndDistributorIgnoreCaseContainsAndDurationBetweenAndOriginCountryIgnoreCaseContainsAndReleaseYearBetween(
			String movieName, String genres, String distributor, Integer durationFrom, Integer durationTo,
			String originCountry, Integer releaseYearFrom, Integer releaseYearTo, Pageable pageable);

	Movie findOneById(Long id);

	Movie findOneByIdAndDeletedFalse(Long id);
}

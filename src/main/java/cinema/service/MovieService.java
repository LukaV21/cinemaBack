package cinema.service;

import org.springframework.data.domain.Page;

import cinema.model.Movie;

public interface MovieService {

	Page<Movie> find(Boolean isDeleted, String movieName, String genres, String distributor, Integer durationFrom,
			Integer durationTo, String originCountry, Integer releaseYearFrom, Integer releaseYearTo, int pageNo,
			Boolean paginiraj);

	Movie delete(Long id);

	Movie findOne(Long id);

}

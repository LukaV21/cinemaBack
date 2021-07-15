package cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

import org.hibernate.Filter;
import org.hibernate.Session;

import cinema.model.Movie;
import cinema.repository.MovieRepository;
import cinema.service.MovieService;

@Service
public class JpaMovieService implements MovieService {
	
	@Autowired
	private MovieRepository mRepository;
	
	@Autowired
    private EntityManager entityManager;

	@Override
	public Page<Movie> find(Boolean isDeleted, String movieName, String genres, String distributor,
			Integer durationFrom, Integer durationTo, String originCountry, Integer releaseYearFrom,
			Integer releaseYearTo, int pageNo, Boolean paginiraj) {
		Session session = entityManager.unwrap(Session.class);
        Filter filter = session.enableFilter("deletedMovieFilter");
        filter.setParameter("isDeleted", isDeleted);
		
		if(movieName== null) {
			movieName="";
		}
		if(genres== null) {
			genres="";
		}
		if(distributor==null) {
			distributor="";
		}	
		if (durationFrom == null) {
			durationFrom = 0;
        }
        if (durationTo == null) {
        	durationTo = Integer.MAX_VALUE;
        }
        if(originCountry==null) {
        	originCountry="";
        } 
        if (releaseYearFrom == null) {
        	releaseYearFrom = 0;
        }
        if (releaseYearTo == null) {
        	releaseYearTo = Integer.MAX_VALUE;
        }
        Integer pNo = (paginiraj != null || paginiraj == Boolean.FALSE)? Integer.MAX_VALUE : 2;	
		
        Page<Movie> movies = mRepository.findByMovieNameIgnoreCaseContainsAndGenresIgnoreCaseContainsAndDistributorIgnoreCaseContainsAndDurationBetweenAndOriginCountryIgnoreCaseContainsAndReleaseYearBetween(movieName, genres, distributor, durationFrom, durationTo, originCountry, releaseYearFrom, releaseYearTo, PageRequest.of(pageNo,pNo));
        
        session.disableFilter("deletedMovieFilter");
		return movies;
	}

	@Override
	public Movie delete(Long id) {
		Movie movie = mRepository.findOneById(id);
		mRepository.deleteById(id);
		return movie;
	}

	@Override
	public Movie findOne(Long id) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null && auth.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"))) {
		    return mRepository.findOneById(id);
		}
		else return mRepository.findOneByIdAndDeletedFalse(id);
	}

	@Override
	public Movie save(Movie movie) {
		return mRepository.save(movie);
	}

}

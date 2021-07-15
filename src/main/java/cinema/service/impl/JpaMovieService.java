package cinema.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cinema.repository.MovieRepository;
import cinema.service.MovieService;

@Service
public class JpaMovieService implements MovieService {
	
	@Autowired
	private MovieRepository mRepository;

}

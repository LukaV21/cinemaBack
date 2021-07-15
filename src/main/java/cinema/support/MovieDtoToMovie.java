package cinema.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Movie;
import cinema.service.MovieService;
import cinema.web.dto.MovieDto;

@Component
public class MovieDtoToMovie implements Converter<MovieDto, Movie> {
	
	@Autowired
	private MovieService mService;

	@Override
	public Movie convert(MovieDto dto) {
		Movie entity;

        if(dto.getId() == null) {
            entity = new Movie();
        }else {
            entity = mService.findOne(dto.getId());
        }

        if(entity != null) {
        	
        	entity.setMovieName(dto.getMovieName());
        	entity.setDistributor(dto.getDistributor());
        	entity.setActors(dto.getActors());
        	entity.setReleaseYear(dto.getReleaseYear());
        	entity.setDescription(dto.getDescription());
        	entity.setDirector(dto.getDirector());
        	entity.setDuration(dto.getDuration());
        	entity.setOriginCountry(dto.getOriginCountry());
        	entity.setGenres(dto.getGenres());

            
        }

        return entity;
    }

}

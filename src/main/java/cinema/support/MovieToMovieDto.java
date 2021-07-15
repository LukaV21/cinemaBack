package cinema.support;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import cinema.model.Movie;
import cinema.web.dto.MovieDto;

@Component
public class MovieToMovieDto implements Converter<Movie, MovieDto> {

	@Override
	public MovieDto convert(Movie source) {
		MovieDto dto = new MovieDto();
		
		dto.setId(source.getId());
		dto.setMovieName(source.getMovieName());
		dto.setDirector(source.getDirector());
		dto.setActors(source.getActors());
		dto.setGenres(source.getGenres());
		dto.setDuration(source.getDuration());
		dto.setDistributor(source.getDistributor());
		dto.setOriginCountry(source.getOriginCountry());
		dto.setReleaseYear(source.getReleaseYear());
		dto.setDescription(source.getDescription());

		return dto;
	}
	
	public List<MovieDto> convert(List<Movie> movies){
        List<MovieDto> moviesDto = new ArrayList<>();

        for(Movie movie : movies) {
        	moviesDto.add(convert(movie));
        }

        return moviesDto;
    }
	
	

}

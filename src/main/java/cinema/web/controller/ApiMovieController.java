package cinema.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.Movie;
import cinema.service.MovieService;
import cinema.support.MovieDtoToMovie;
import cinema.support.MovieToMovieDto;
import cinema.web.dto.MovieDto;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping(value = "/api/movies", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiMovieController {
	
	@Autowired
	private MovieService mService;
	@Autowired
	private MovieToMovieDto toDto;
	@Autowired
	private MovieDtoToMovie toMovie;
	
	
	
	
	
	@GetMapping
    public ResponseEntity<List<MovieDto>> getAll(
    		@RequestParam(required=false, defaultValue = "false") Boolean isDeleted,
            @RequestParam(required=false) String movieName, 
            @RequestParam(required=false) String genres,
            @RequestParam(required=false) String distributor,
            @RequestParam(required=false) Integer durationFrom,
            @RequestParam(required=false) Integer durationTo,
            @RequestParam(required=false) String originCountry,
            @RequestParam(required=false) Integer releaseYearFrom,
            @RequestParam(required=false) Integer releaseYearTo,
            @RequestParam(required=false) Boolean paginiraj,
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo){

    	Page<Movie> page = mService.find(isDeleted, movieName, genres, distributor, durationFrom, durationTo, originCountry, releaseYearFrom, 
    			releaseYearTo, pageNo, paginiraj);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

        return new ResponseEntity<>(toDto.convert(page.getContent()),headers, HttpStatus.OK);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
		Movie deleted = mService.delete(id);

        if(deleted != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<MovieDto> getOne(@PathVariable Long id){
       Movie movie = mService.findOne(id);

        if(movie != null) {
            return new ResponseEntity<>(toDto.convert(movie), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDto> create(@Valid @RequestBody MovieDto dto){
        Movie movie = toMovie.convert(dto);
        Movie savedMovie = mService.save(movie);

        return new ResponseEntity<>(toDto.convert(savedMovie), HttpStatus.CREATED);
    }
	
	@PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value = "/{id}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieDto> update(@PathVariable Long id, @Valid @RequestBody MovieDto dto){

        if(!id.equals(dto.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Movie movie = toMovie.convert(dto);
        Movie savedMovie = mService.update(movie);

        return new ResponseEntity<>(toDto.convert(savedMovie),HttpStatus.OK);
    }

}

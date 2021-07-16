package cinema.web.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.Projection;
import cinema.service.ProjectionService;
import cinema.support.ProjectionDtoToProjection;
import cinema.support.ProjectionToProjectionDto;
import cinema.web.dto.ProjectionDto;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;

@RestController
@RequestMapping(value = "/api/projections", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiProjectionsController {
	
	@Autowired
	private ProjectionService pService;
	@Autowired 
	private ProjectionToProjectionDto toDto;
	@Autowired
	private ProjectionDtoToProjection toProjection;
	
	
	@GetMapping
    public ResponseEntity<List<ProjectionDto>> getAll(
    		@RequestParam(required=false, defaultValue = "false") Boolean isDeleted,
            @RequestParam(required=false) Long movieId,
            @RequestParam(required=false) Long projectionTypeId,
            @RequestParam(required=false) Long hallId,
            @RequestParam(required=false) Double ticketPriceFrom,
            @RequestParam(required=false) Double ticketPriceTo,
            @RequestParam(value = "pageNo", defaultValue = "0") int pageNo){

    	Page<Projection> page;
        try{
           

            page = pService.find(isDeleted, ticketPriceFrom, ticketPriceTo, projectionTypeId, movieId, hallId,
            		pageNo);
        }catch (Exception e){
            page = pService.findAll(pageNo);
        }

        HttpHeaders headers = new HttpHeaders();
        headers.add("Total-Pages", Integer.toString(page.getTotalPages()));

        return new ResponseEntity<>(toDto.convert(page.getContent()),headers, HttpStatus.OK);
    }
	
	

	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
		Projection deleted = pService.delete(id);

        if(deleted != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ProjectionDto> create(@Valid @RequestBody ProjectionDto dto, Authentication authentication){
		dto.setId(null);
		dto.setAdmin(authentication.getName());
        Projection projection = toProjection.convert(dto);
        
        

        if(projection.getMovie() == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }        
        Projection savedProjection = pService.save(projection);

        return new ResponseEntity<>(toDto.convert(savedProjection), HttpStatus.CREATED);
    }

}

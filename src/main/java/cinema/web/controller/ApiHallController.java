package cinema.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.Hall;
import cinema.service.HallService;
import cinema.support.HallToHallDto;
import cinema.web.dto.HallDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping(value = "/api/halls", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiHallController {
	
	
	@Autowired
	private HallService hService;
	@Autowired
	private HallToHallDto toDto;
	
	
	@PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<HallDto>> getAll(){

        List<Hall> halls = hService.findAll();

        return new ResponseEntity<>(toDto.convert(halls), HttpStatus.OK);
    }	

}

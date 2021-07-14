package cinema.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.Seat;
import cinema.service.SeatService;
import cinema.support.SeatToSeatDto;
import cinema.web.dto.SeatDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping(value = "/api/seats", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiSeatController {
	
	
	@Autowired
	private SeatService sService;
	@Autowired
	private SeatToSeatDto toDto;
	
	@PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<SeatDto>> getAll(){

        List<Seat> seats = sService.findAll();

        return new ResponseEntity<>(toDto.convert(seats), HttpStatus.OK);
    }

}

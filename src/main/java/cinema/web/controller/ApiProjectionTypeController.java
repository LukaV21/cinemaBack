package cinema.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.model.ProjectionType;
import cinema.service.ProjectionTypeService;
import cinema.support.ProjectionTypeToProjectionTypeDto;
import cinema.web.dto.ProjectionTypeDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping(value = "/api/projection_types", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiProjectionTypeController {
	
	@Autowired
	private ProjectionTypeService ptService;
	@Autowired
	private ProjectionTypeToProjectionTypeDto toDto;
	
	
	@PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<ProjectionTypeDto>> getAll(){

        List<ProjectionType> pType = ptService.findAll();

        return new ResponseEntity<>(toDto.convert(pType), HttpStatus.OK);
    }

}

package cinema.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cinema.service.ProjectionTypeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/api/projection_type", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiProjectionTypeController {
	
	@Autowired
	private ProjectionTypeService ptService;

}

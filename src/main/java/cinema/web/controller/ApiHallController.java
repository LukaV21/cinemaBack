package cinema.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

@RestController
@RequestMapping(value = "/api/halls", produces = MediaType.APPLICATION_JSON_VALUE)
public class ApiHallController {

}

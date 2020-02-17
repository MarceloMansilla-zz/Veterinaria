package ar.com.veterinaria.app.controller;

import org.springframework.stereotype.Controller;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ar.com.veterinaria.app.entities.AnimalBreed;
import ar.com.veterinaria.app.service.AnimalBreedService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping(value = "/animalbreed", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Api(tags = "AnimalBreed", description = "Endpoint for AnimalBreed management")
public class AnimalBreedController {

	private static final Logger logger = LoggerFactory.getLogger(AnimalBreedController.class);

	@Autowired
	AnimalBreedService animalBreedService;

	@Autowired
	public AnimalBreedController(AnimalBreedService animalBreedService) {
		this.animalBreedService = animalBreedService;
	}

	@GetMapping
	@RequestMapping(value = "/new-animalBreed", method = RequestMethod.POST)
	@ApiOperation(value = "Create a new AnimalBreed", notes = "Create a new AnimalBreed.", response = AnimalBreed.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful retrieval of AnimalBreed List", response = AnimalBreed.class),
			@ApiResponse(code = 500, message = "Internal server error") })
	public ResponseEntity<AnimalBreed> create(@RequestBody AnimalBreed animalBreed) {

		// longitud
		// tipo de dato - letras May y Min, WhiteSpace
		// null
		// empty -> white space

		try {
			animalBreedService.isValidInputData(animalBreed);
			animalBreedService.exist(animalBreed);
			animalBreedService.add(animalBreed);
			return new ResponseEntity<AnimalBreed>(animalBreed, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@GetMapping
	@RequestMapping(value = "/get-list-animalbreed", method = RequestMethod.GET)
	@ApiOperation(value = "Returns List of AnimalBreed", notes = "Returns a complete list of AnimalBreed details.", response = AnimalBreed.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successful retrieval of Animal List", response = AnimalBreed.class),
			@ApiResponse(code = 500, message = "Internal server error") })
	public ResponseEntity<List<Map<String, Object>>> getAll() {
		try {
			List<Map<String, Object>> result = animalBreedService.findAll();
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
/*
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Search a Animal by ID", response = AnimalBreed.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 403, message = "Operation is forbidden"),
			@ApiResponse(code = 500, message = "Server error") })
	public ResponseEntity<AnimalBreed> getById(@PathVariable("id") int id) {
		try {
			AnimalBreed animalBreed = animalBreedService.findById(id);
			if (animalBreed != null) {
				return ResponseEntity.status(HttpStatus.OK).body(animalBreed);
			} else {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = "Update a Animal by ID", response = AnimalBreed.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 403, message = "Operation is forbidden"),
			@ApiResponse(code = 500, message = "Server error") })
	public ResponseEntity<AnimalBreed> update(@PathVariable("id") int id, @RequestBody AnimalBreed animalBreed) {
		try {
			animalBreedService.isValidInputData(animalBreed);
			animalBreedService.update(id, animalBreed);
			return ResponseEntity.status(HttpStatus.OK).body(animalBreed);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete a AnimalBreed by ID", response = AnimalBreed.class)
	@ApiResponses({ @ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 403, message = "Operation is forbidden"),
			@ApiResponse(code = 500, message = "Server error") })
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		try {
			animalBreedService.remove(id);
			return ResponseEntity.status(HttpStatus.OK).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}*/

}

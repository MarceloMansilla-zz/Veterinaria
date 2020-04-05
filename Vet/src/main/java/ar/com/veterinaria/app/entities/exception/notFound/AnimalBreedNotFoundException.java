package ar.com.veterinaria.app.entities.exception.notFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AnimalBreedNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 481336177564229661L;

	public AnimalBreedNotFoundException(Integer id) {
		super("Could not find AnimalBreed with id " + id);
	}
}

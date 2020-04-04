package ar.com.veterinaria.app.entities.exception.notFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AnimalBreedNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1093306691287711077L;

	public AnimalBreedNotFoundException(Integer id) {
		super("Could not find AnimalBreed with id " + id);
	}
}

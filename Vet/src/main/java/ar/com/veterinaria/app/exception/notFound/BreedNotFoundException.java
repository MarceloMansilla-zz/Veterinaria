package ar.com.veterinaria.app.exception.notFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BreedNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1093306691287711077L;

	public BreedNotFoundException(Integer id) {
		super("Could not find Breed with id " + id);
	}

	public BreedNotFoundException(String breed) {
		super("Could not find Breed: " + breed);
	}

}

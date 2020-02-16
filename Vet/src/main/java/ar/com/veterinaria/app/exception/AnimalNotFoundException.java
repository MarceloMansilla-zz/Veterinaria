package ar.com.veterinaria.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AnimalNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1093306691287711077L;

	public AnimalNotFoundException(long id) {
		super("Could not find Animal with id " + id);
	}

	public AnimalNotFoundException(String breed) {
		super("Could not find Animal: " + breed);
	}

}

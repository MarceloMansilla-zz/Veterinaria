package ar.com.veterinaria.app.entities.exception.duplicate;

import ar.com.veterinaria.app.entities.Animal;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AnimalDuplicatedException extends RuntimeException {

	private static final long serialVersionUID = -213155368609992996L;

	public AnimalDuplicatedException(String animal) {
		super("The Animal'" + animal + "' already exists.");
	}

	public AnimalDuplicatedException(int id) {
		super("The Animal with id '" + id + "' already exists.");
	}

	public AnimalDuplicatedException(Animal animal) {
		super("The Animal '" + animal + "' already exists.");
	}
}

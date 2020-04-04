package ar.com.veterinaria.app.entities.exception.notFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ar.com.veterinaria.app.entities.Animal;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AnimalNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1093306691287711077L;

	public AnimalNotFoundException(Integer id) {
		super("Could not find Animal with id " + id);
	}

	public AnimalNotFoundException(String breed) {
		super("Could not find Animal: " + breed);
	}

	public AnimalNotFoundException(Animal name) {
		super("Could not find Animal: " + name.toString());
	}

}

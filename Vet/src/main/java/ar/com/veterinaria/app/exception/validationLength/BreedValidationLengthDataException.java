package ar.com.veterinaria.app.exception.validationLength;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ar.com.veterinaria.app.entities.Breed;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BreedValidationLengthDataException extends RuntimeException {

	private static final long serialVersionUID = -6430489116264901564L;

	public BreedValidationLengthDataException(Breed breed) {
		super("Length name is over 70 character: " + breed.getBreed().length() + " for name: " + breed.getBreed());
	}

}

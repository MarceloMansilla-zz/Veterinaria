package ar.com.veterinaria.app.exception;

import ar.com.veterinaria.app.entities.Breed;

public class BreedValidationLengthDataException extends RuntimeException {

	private static final long serialVersionUID = -6430489116264901564L;

	public BreedValidationLengthDataException(Breed breed) {
		super("Length name is over 70 character: " + breed.getBreed().length() + " for name: " + breed.getBreed());
	}

}

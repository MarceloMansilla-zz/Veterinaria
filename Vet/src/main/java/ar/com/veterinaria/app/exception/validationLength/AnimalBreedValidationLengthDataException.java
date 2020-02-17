package ar.com.veterinaria.app.exception.validationLength;

import ar.com.veterinaria.app.entities.AnimalBreed;

public class AnimalBreedValidationLengthDataException extends RuntimeException {

	private static final long serialVersionUID = 1324824257559118085L;

	public AnimalBreedValidationLengthDataException(AnimalBreed animalBreed) {
		super("Length name is over 70 character: " + animalBreed.getAnimal().getName().length() + " for name: "
				+ animalBreed.getAnimal().getName()+"\n ");
	}

}

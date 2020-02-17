package ar.com.veterinaria.app.exception;

import ar.com.veterinaria.app.entities.AnimalBreed;

public class AnimalBreedException extends RuntimeException {

	private static final long serialVersionUID = 1093306691287711077L;

	public AnimalBreedException(AnimalBreed animalBreed) {
		super("\nIt is neccesary an association: \nAnimal " + animalBreed.getAnimal().getName()+" & Breed "+animalBreed.getBreed().getBreed());
	}

}

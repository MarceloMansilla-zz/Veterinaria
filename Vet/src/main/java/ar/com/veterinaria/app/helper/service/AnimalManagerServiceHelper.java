package ar.com.veterinaria.app.helper.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.veterinaria.app.entities.Animal;
import ar.com.veterinaria.app.exception.AnimalInvalidDataException;
import ar.com.veterinaria.app.exception.AnimalValidationLengthDataException;

@Service
@Transactional
public class AnimalManagerServiceHelper {

	@Autowired
	private static AnimalServiceHelper animalServiceHelper;

	@Autowired
	public AnimalManagerServiceHelper(AnimalServiceHelper animalServiceHelper) {
		this.animalServiceHelper = animalServiceHelper;
	}
	

	public static boolean validate(Animal animal) {
		System.out.println(" ¨¨¨¨¨¨¨ " + animal);
		if (!animalServiceHelper.isValidName(animal)) {
			throw new AnimalInvalidDataException(animal);

		} else if (!animalServiceHelper.isValidLengthname(animal)) {
			throw new AnimalValidationLengthDataException(animal);
		}
		return true;
	}
}

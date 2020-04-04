package ar.com.veterinaria.app.entities.helper.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.Animal;
import ar.com.veterinaria.app.entities.exception.invalidData.AnimalInvalidDataException;
import ar.com.veterinaria.app.entities.exception.validationLength.AnimalValidationLengthDataException;

@Service
@Transactional
public class AnimalManagerServiceHelper {

	@Autowired
	private static AnimalServiceHelper animalServiceHelper;

	@SuppressWarnings("static-access")
	@Autowired
	public AnimalManagerServiceHelper(AnimalServiceHelper animalServiceHelper) {
		this.animalServiceHelper = animalServiceHelper;
	}

	public static boolean validate(Animal animal) {
		if (!animalServiceHelper.isValidName(animal)) {
			throw new AnimalInvalidDataException(animal);

		} else if (!animalServiceHelper.isValidLengthname(animal)) {
			throw new AnimalValidationLengthDataException(animal);
		}
		return true;
	}
}

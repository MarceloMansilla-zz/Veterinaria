package ar.com.veterinaria.app.helper.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.Breed;
import ar.com.veterinaria.app.exception.BreedInvalidDataException;
import ar.com.veterinaria.app.exception.BreedValidationLengthDataException;

@Service
@Transactional
public class BreedManagerServiceHelper {

	@Autowired
	private static BreedServiceHelper breedServiceHelper;

	@Autowired
	public BreedManagerServiceHelper(BreedServiceHelper breedServiceHelper) {
		this.breedServiceHelper = breedServiceHelper;
	}

	public static boolean validate(Breed breed) {
		if (!breedServiceHelper.isValidName(breed)) {
			throw new BreedInvalidDataException(breed);

		} else if (!breedServiceHelper.isValidLengthname(breed)) {
			throw new BreedValidationLengthDataException(breed);
		}
		return true;
	}
}

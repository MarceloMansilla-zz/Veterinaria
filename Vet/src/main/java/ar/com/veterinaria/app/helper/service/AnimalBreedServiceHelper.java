package ar.com.veterinaria.app.helper.service;

import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.AnimalBreed;
import ar.com.veterinaria.app.helper.service.contract.AnimalBreedContractServiceHelper;
import ar.com.veterinaria.app.validatorPattern.ValidatorPatternServiceHelper;

@Service
public class AnimalBreedServiceHelper implements AnimalBreedContractServiceHelper {

	public AnimalBreedServiceHelper() {
		super();
	}

	@Override
	public boolean isValidName(AnimalBreed animalBreed) {
		if (ValidatorPatternServiceHelper.getNamePattern().matcher(animalBreed.getAnimal().getName()).matches()
				&& ValidatorPatternServiceHelper.getNamePattern().matcher(animalBreed.getBreed().getBreed()).matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isValidLengthname(AnimalBreed animalBreed) {
		if (animalBreed.getAnimal().getName().length() <= 70 && animalBreed.getBreed().getBreed().length() <= 50) {
			return true;
		}
		return false;
	}

}

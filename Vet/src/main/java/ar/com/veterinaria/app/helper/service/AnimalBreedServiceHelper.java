package ar.com.veterinaria.app.helper.service;

import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.AnimalBreed;
import ar.com.veterinaria.app.helper.service.contract.AnimalBreedContractServiceHelper;

@Service
public class AnimalBreedServiceHelper extends BaseServiceHelper implements AnimalBreedContractServiceHelper {

	public AnimalBreedServiceHelper() {
		super();
	}

	@Override
	public boolean isValidName(AnimalBreed animalBreed) {
		if (getNamePattern().matcher(animalBreed.getAnimal().getName()).matches()
				&& getNamePattern().matcher(animalBreed.getBreed().getBreed()).matches()) {
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

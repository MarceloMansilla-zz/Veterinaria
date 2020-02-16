package ar.com.veterinaria.app.helper.service;

import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.Breed;
import ar.com.veterinaria.app.helper.service.contract.BreedContractServiceHelper;

@Service
public class BreedServiceHelper extends BaseServiceHelper implements BreedContractServiceHelper {

	@Override
	public boolean isValidName(Breed breed) {
		if (getNamePattern().matcher(breed.getBreed()).matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isValidLengthname(Breed breed) {
		if (breed.getBreed().length() < 50) {
			return true;
		}
		return false;
	}
}

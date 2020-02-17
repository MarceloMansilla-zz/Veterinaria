package ar.com.veterinaria.app.helper.service;

import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.Animal;
import ar.com.veterinaria.app.helper.service.contract.AnimalContractServiceHelper;

@Service
public class AnimalServiceHelper extends BaseServiceHelper implements AnimalContractServiceHelper {

	public AnimalServiceHelper() {
		super();
	}

	@Override
	public boolean isValidName(Animal animal) {
		if (getNamePattern().matcher(animal.getName()).matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isValidLengthname(Animal animal) {
		if (animal.getName().length() < 70) {
			return true;
		}
		return false;
	}

}
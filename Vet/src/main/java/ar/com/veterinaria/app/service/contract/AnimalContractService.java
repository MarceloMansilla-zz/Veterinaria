package ar.com.veterinaria.app.service.contract;

import ar.com.veterinaria.app.entities.Animal;

public interface AnimalContractService extends BaseContractService<Animal> {

	Animal findAnimalByName(String animal);
}

package ar.com.veterinaria.app.helper.daoImpl.contract;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.veterinaria.app.entities.Animal;
import ar.com.veterinaria.app.entities.AnimalBreed;
import ar.com.veterinaria.app.entities.Breed;

public interface AnimalBreedContractDaoImplHelper extends BaseContractDaoImplHelper<AnimalBreed> {

	Breed findBreedByName(JpaRepository<AnimalBreed, Integer> repository, AnimalBreed name);

	Animal findAnimalByName(JpaRepository<AnimalBreed, Integer> repository,AnimalBreed name);
}

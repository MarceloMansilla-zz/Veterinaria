package ar.com.veterinaria.app.helper.daoImpl;

import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.veterinaria.app.entities.Animal;
import ar.com.veterinaria.app.entities.AnimalBreed;
import ar.com.veterinaria.app.entities.Breed;
import ar.com.veterinaria.app.exception.AnimalBreedException;
import ar.com.veterinaria.app.exception.duplicate.AnimalBreedDuplicatedException;
import ar.com.veterinaria.app.exception.notFound.AnimalBreedNotFoundException;
import ar.com.veterinaria.app.repository.AnimalBreedRepository;
import ar.com.veterinaria.app.repository.AnimalRepository;
import ar.com.veterinaria.app.repository.BreedRepository;

@Service
@Transactional
public class AnimalBreedManagerDaoImplHelper {

	@Autowired
	private static AnimalBreedRepository animalBreedRepository;
	@Autowired
	private static BreedRepository breedRepository;
	@Autowired
	private static AnimalRepository animalRepository;
	@Autowired
	private static AnimalBreedDaoImplHelper animalBreedDaoImplHelper;
	@Autowired
	private static BreedDaoImplHelper breedDaoImplHelper;
	@Autowired
	private static AnimalDaoImplHelper animalDaoImplHelper;

	@Autowired
	public AnimalBreedManagerDaoImplHelper(AnimalBreedDaoImplHelper animalBreedDaoImplHelper,
			AnimalBreedRepository animalBreedRepository, BreedDaoImplHelper breedDaoImplHelper,
			BreedRepository breedRepository, AnimalDaoImplHelper animalDaoImplHelper,
			AnimalRepository animalRepository) {
		this.animalBreedRepository = animalBreedRepository;
		this.animalBreedDaoImplHelper = animalBreedDaoImplHelper;
		this.breedRepository = breedRepository;
		this.breedDaoImplHelper = breedDaoImplHelper;
		this.animalRepository = animalRepository;
		this.animalDaoImplHelper = animalDaoImplHelper;
	}

	public static List<Map<String, Object>> findAll() {
		return animalBreedDaoImplHelper.findAll(animalBreedRepository);
	}

	public static boolean validate(AnimalBreed animalBreed) {
		if ((animalBreedDaoImplHelper.findAnimalByName(animalBreedRepository, animalBreed) != null)
				&& (animalBreedDaoImplHelper.findBreedByName(animalBreedRepository, animalBreed) != null)) {
			throw new AnimalBreedDuplicatedException(animalBreed);
		}
		return false;
	}

	public static boolean existId(int id) {
		if (animalBreedDaoImplHelper.existId(animalBreedRepository, id)) {
			return true;
		}
		throw new AnimalBreedNotFoundException(id);
	}

	public static boolean isAssociation(AnimalBreed animalBreed) {
		if ((!animalDaoImplHelper.isDuplicated(animalRepository, animalBreed.getAnimal()))
				&& (breedDaoImplHelper.isDuplicated(breedRepository, animalBreed.getBreed()))) {
			return true;

		} else if ((animalDaoImplHelper.isDuplicated(animalRepository, animalBreed.getAnimal()))
				&& (!breedDaoImplHelper.isDuplicated(breedRepository, animalBreed.getBreed()))) {
			return true;
		}
		return false;
	}

	public static AnimalBreed associate(AnimalBreed animalBreed) {
		AnimalBreed aAnimalBreed = new AnimalBreed();
		if (((!animalDaoImplHelper.isDuplicated(animalRepository, animalBreed.getAnimal()))
				&& (breedDaoImplHelper.isDuplicated(breedRepository, animalBreed.getBreed())))) {
			Animal animal = animalBreedDaoImplHelper.getAnimalByName(animalBreedRepository, animalBreed);
			Breed breed = animalBreedDaoImplHelper.getBreedByName(animalBreedRepository, animalBreed);
			aAnimalBreed.setAnimal(animal);
			aAnimalBreed.setBreed(breed);
		} else if (((animalDaoImplHelper.isDuplicated(animalRepository, animalBreed.getAnimal()))
				&& (!breedDaoImplHelper.isDuplicated(breedRepository, animalBreed.getBreed())))) {
			Animal animal = animalBreedDaoImplHelper.getAnimalByName(animalBreedRepository, animalBreed);
			Breed breed = animalBreedDaoImplHelper.getBreedByName(animalBreedRepository, animalBreed);
			aAnimalBreed.setAnimal(animal);
			aAnimalBreed.setBreed(breed);
		}
		return aAnimalBreed;
	}

	public static AnimalBreed update(AnimalBreed animalBreed) {
		Animal animal = animalBreedDaoImplHelper.getAnimalByName(animalBreedRepository, animalBreed);
		Breed breed = animalBreedDaoImplHelper.getBreedByName(animalBreedRepository, animalBreed);
		animal.setName(animalBreed.getAnimal().getName());
		breed.setBreed(animalBreed.getBreed().getBreed());
		animalBreed.setAnimal(animal);
		animalBreed.setBreed(breed);
		return animalBreed;
	}
}

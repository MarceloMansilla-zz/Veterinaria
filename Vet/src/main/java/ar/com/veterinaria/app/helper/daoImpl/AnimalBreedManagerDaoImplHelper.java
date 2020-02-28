package ar.com.veterinaria.app.helper.daoImpl;

import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.Animal;
import ar.com.veterinaria.app.entities.AnimalBreed;
import ar.com.veterinaria.app.entities.Breed;
import ar.com.veterinaria.app.exception.duplicate.AnimalBreedDuplicatedException;
import ar.com.veterinaria.app.exception.notFound.AnimalBreedNotFoundException;
import ar.com.veterinaria.app.exception.notFound.AnimalNotFoundException;
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
		if (!animalBreedDaoImplHelper.existId(animalBreedRepository, id)) {
			throw new AnimalBreedNotFoundException(id);
		}
		return true;

	}

	public static boolean isAssociated(AnimalBreed animalBreed) {
		if (!animalBreedDaoImplHelper.isDuplicated(animalBreedRepository, animalBreed)) {
			System.out.println("Is-Association");
			return false;
		}
		return true;
	}

	public static AnimalBreed associate(AnimalBreed animalBreed) {

		// CHECK ASSOCIATION DUPLICATED ANIMAL AND BREED IN DB BEFORE DOING THE
		// ASSOCIATION
		Animal animal = animalBreedDaoImplHelper.findAnimalByName(animalBreedRepository, animalBreed);
		Breed breed = animalBreedDaoImplHelper.findBreedByName(animalBreedRepository, animalBreed);

		if (animal == null && breed == null) {
			if ((!animalDaoImplHelper.isDuplicated(animalRepository, animalBreed.getAnimal())
					&& (!breedDaoImplHelper.isDuplicated(breedRepository, animalBreed.getBreed())))) {
				System.out.println("Association 0");
				animal = new Animal();
				breed = new Breed();
				breed.setBreed(animalBreed.getBreed().getBreed());
				animal.setName(animalBreed.getAnimal().getName());
				animalBreed.setBreed(breed);
				animalBreed.setAnimal(animal);
			}

		} else if (animal != null && breed == null) {
			System.out.println("Association 1");
			breed = new Breed();
			breed.setBreed(animalBreed.getBreed().getBreed());
			if ((animalDaoImplHelper.isDuplicated(animalRepository, animalBreed.getAnimal()))) {
				Animal aAnimal = animalDaoImplHelper.update(animalRepository, animal.getId(), animalBreed.getAnimal());
				animalBreed.setBreed(breed);
				animalBreed.setAnimal(aAnimal);
			}

		} else if (animal == null && breed != null) {
			System.out.println("Association 2");
			animal = new Animal();
			animal.setName(animalBreed.getAnimal().getName());
			if (breedDaoImplHelper.isDuplicated(breedRepository, animalBreed.getBreed())) {
				Breed bBreed = breedDaoImplHelper.update(breedRepository, breed.getId(), animalBreed.getBreed());
				breedDaoImplHelper.update(breedRepository, breed.getId(), animalBreed.getBreed());
				animalBreed.setAnimal(animal);
				animalBreed.setBreed(bBreed);
			}
		}
		return animalBreed;
	}

	public static AnimalBreed update(Integer id, AnimalBreed animalBreed) {
		Animal aAnimal = animalDaoImplHelper.update(animalRepository, id, animalBreed.getAnimal());
		aAnimal.setId(id);
		aAnimal.setName(animalBreed.getAnimal().getName());
		Breed bBreed = breedDaoImplHelper.update(breedRepository, id, animalBreed.getBreed());
		bBreed.setId(id);
		bBreed.setBreed(animalBreed.getBreed().getBreed());
		// AnimalBreed aAnimalBreed =
		// animalBreedDaoImplHelper.update(animalBreedRepository, id, animalBreed);
		animalBreed.setId(id);
		animalBreed.setAnimal(aAnimal);
		animalBreed.setBreed(bBreed);
		return animalBreed;
	}

	public static boolean isDeleted(int id) {
		if (animalBreedDaoImplHelper.deleted(animalBreedRepository, id)) {
			throw new AnimalBreedNotFoundException(id);
		}
		return false;
	}
}

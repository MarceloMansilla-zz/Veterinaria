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
		boolean existsAnimal = animalDaoImplHelper.isDuplicated(animalRepository, animalBreed.getAnimal());
		boolean existsBreed = breedDaoImplHelper.isDuplicated(breedRepository, animalBreed.getBreed());
		if (existsAnimal && !existsBreed) {
			System.out.println("Is-Association 1");
			return false;
		} else if (!existsAnimal && existsBreed) {
			System.out.println("Is-Association 2");
			return false;
		}
		return true;
	}

	public static AnimalBreed associate(AnimalBreed animalBreed) {

		// CHECK ASSOCIATION DUPLICATED ANIMAL AND BREED IN DB BEFORE DOING THE
		// ASSOCIATION
		Animal animal = animalDaoImplHelper.findByName(animalRepository, animalBreed.getAnimal().getName());
		Breed breed = breedDaoImplHelper.findByName(breedRepository, animalBreed.getBreed().getBreed());

		if (animal != null && breed == null) {
			System.out.println("Association 1");
			Breed aBreed = new Breed();
			aBreed.setBreed(animalBreed.getBreed().getBreed());
			animalBreed.setBreed(aBreed);
			animalBreed.setAnimal(animal);
		} else if (animal == null && breed != null) {
			System.out.println("Association 2");
			Animal aAnimal = new Animal();
			aAnimal.setName(animalBreed.getAnimal().getName());
			animalBreed.setAnimal(aAnimal);
			animalBreed.setBreed(breed);
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

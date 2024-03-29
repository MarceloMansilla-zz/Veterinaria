package ar.com.veterinaria.app.entities.helper.daoImpl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.Breed;
import ar.com.veterinaria.app.entities.exception.duplicate.AnimalDuplicatedException;
import ar.com.veterinaria.app.entities.exception.notFound.BreedNotFoundException;
import ar.com.veterinaria.app.entities.repository.BreedRepository;

@Service
@Transactional
public class BreedManagerDaoImplHelper {

	@Autowired
	private static BreedRepository breedRepository;

	@Autowired
	private static BreedDaoImplHelper breedDaoImplHelper;

	@SuppressWarnings("static-access")
	@Autowired
	public BreedManagerDaoImplHelper(BreedDaoImplHelper breedDaoImplHelper, BreedRepository breedRepository) {
		this.breedDaoImplHelper = breedDaoImplHelper;
		this.breedRepository = breedRepository;
	}

	public static boolean validate(Breed breed) {
		if (breedDaoImplHelper.isDuplicated(breedRepository, breed)) {
			throw new AnimalDuplicatedException(breed.getBreed());
		}
		return false;
	}

	public static boolean existId(Integer id) {
		if (breedDaoImplHelper.existId(breedRepository, id)) {
			return true;
		}
		throw new BreedNotFoundException(id);

	}

	public static boolean isDeleted(Integer id) {
		if (breedDaoImplHelper.deleted(breedRepository, id)) {
			throw new BreedNotFoundException(id);
		}
		return false;
	}

	public static List<Map<String, Object>> findAll() {
		return breedDaoImplHelper.findAll(breedRepository);
	}

	public static Breed findBreedByName(String t) {
		Breed breed = breedDaoImplHelper.findByName(breedRepository, t);
		if (breed != null) {
			return breed;
		}
		throw new BreedNotFoundException(t);
	}

	public static Breed updateBreed(Integer id, Breed breed) {
		Breed bBreed = breedDaoImplHelper.update(breedRepository, id, breed);
		bBreed.setId(id);
		bBreed.setBreed(breed.getBreed());
		return bBreed;
	}

}

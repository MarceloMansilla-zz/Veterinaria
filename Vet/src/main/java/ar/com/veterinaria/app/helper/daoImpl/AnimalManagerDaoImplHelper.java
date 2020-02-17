package ar.com.veterinaria.app.helper.daoImpl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.veterinaria.app.entities.Animal;
import ar.com.veterinaria.app.exception.AnimalDuplicatedException;
import ar.com.veterinaria.app.exception.AnimalNotFoundException;
import ar.com.veterinaria.app.repository.AnimalRepository;

@Service
@Transactional
public class AnimalManagerDaoImplHelper {

	@Autowired
	private static AnimalRepository animalRepository;

	@Autowired
	private static AnimalDaoImplHelper animalDaoImplHelper;

	@Autowired
	public AnimalManagerDaoImplHelper(AnimalDaoImplHelper animalDaoImplHelper, AnimalRepository animalRepository) {
		this.animalDaoImplHelper = animalDaoImplHelper;
		this.animalRepository = animalRepository;
	}

	public static boolean validate(Animal animal) {
		if (animalDaoImplHelper.isDuplicated(animalRepository, animal)) {
			throw new AnimalDuplicatedException(animal.getName());
		}
		return false;
	}

	public static boolean existId(Integer id) {
		if (!animalDaoImplHelper.existId(animalRepository, id)) {
			throw new AnimalNotFoundException(id);
		}
		return false;
	}

	public static boolean isDeleted(Integer id) {
		if (animalDaoImplHelper.deleted(animalRepository, id)) {
			throw new AnimalNotFoundException(id);
		}
		return false;
	}

	public static List<Map<String, Object>> findAll() {
		return animalDaoImplHelper.findAll(animalRepository);
	}
}

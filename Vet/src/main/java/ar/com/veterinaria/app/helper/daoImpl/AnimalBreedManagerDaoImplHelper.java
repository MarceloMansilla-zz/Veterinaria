package ar.com.veterinaria.app.helper.daoImpl;

import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.AnimalBreed;
import ar.com.veterinaria.app.exception.AnimalBreedException;
import ar.com.veterinaria.app.exception.duplicate.AnimalBreedDuplicatedException;
import ar.com.veterinaria.app.repository.AnimalBreedRepository;
import ar.com.veterinaria.app.repository.AnimalRepository;
import ar.com.veterinaria.app.repository.BreedRepository;

@Service
@Transactional
public class AnimalBreedManagerDaoImplHelper {

	@Autowired
	private static AnimalBreedRepository animalBreedRepository;
	@Autowired
	private static AnimalBreedDaoImplHelper animalBreedDaoImplHelper;
	@Autowired
	private static BreedRepository breedRepository;
	@Autowired
	private static BreedDaoImplHelper breedDaoImplHelper;
	@Autowired
	private static AnimalRepository animalRepository;
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

		} else if (((!animalDaoImplHelper.isDuplicated(animalRepository, animalBreed.getAnimal()))
				&& (breedDaoImplHelper.isDuplicated(breedRepository, animalBreed.getBreed())))
				|| ((animalDaoImplHelper.isDuplicated(animalRepository, animalBreed.getAnimal()))
						&& (!breedDaoImplHelper.isDuplicated(breedRepository, animalBreed.getBreed())))) {
			throw new AnimalBreedException(animalBreed);
		}
		return false;
	}

}

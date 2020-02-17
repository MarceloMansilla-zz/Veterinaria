package ar.com.veterinaria.app.helper.daoImpl;

import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.AnimalBreed;
import ar.com.veterinaria.app.repository.AnimalBreedRepository;

@Service
@Transactional
public class AnimalBreedManagerDaoImplHelper {

	@Autowired
	private static AnimalBreedRepository animalBreedRepository;

	@Autowired
	private static AnimalBreedDaoImplHelper animalBreedDaoImplHelper;

	@Autowired
	public AnimalBreedManagerDaoImplHelper(AnimalBreedDaoImplHelper animalDaoImplHelper,
			AnimalBreedRepository animalRepository) {
		this.animalBreedDaoImplHelper = animalDaoImplHelper;
		this.animalBreedRepository = animalRepository;
	}

	public static List<Map<String, Object>> findAll() {
		return animalBreedDaoImplHelper.findAll(animalBreedRepository);
	}

	public static boolean validate(AnimalBreed animalBreed) {
		// TODO Auto-generated method stub
		return false;
	}

}

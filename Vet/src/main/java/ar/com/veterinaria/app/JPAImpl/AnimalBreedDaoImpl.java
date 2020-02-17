package ar.com.veterinaria.app.JPAImpl;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.com.veterinaria.app.dao.AnimalBreedDao;
import ar.com.veterinaria.app.entities.AnimalBreed;
import ar.com.veterinaria.app.helper.daoImpl.AnimalBreedManagerDaoImplHelper;
import ar.com.veterinaria.app.helper.daoImpl.AnimalManagerDaoImplHelper;
import ar.com.veterinaria.app.repository.AnimalBreedRepository;

@Repository
public class AnimalBreedDaoImpl implements AnimalBreedDao {

	private static final Logger logger = LoggerFactory.getLogger(AnimalBreedDaoImpl.class);

	@Autowired
	private AnimalBreedRepository animalBreedRepository;

	public AnimalBreedDaoImpl() {
		super();
	}

	@Override
	public AnimalBreed findById(int id) {
		try {
			return animalBreedRepository.findAnimalById(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public void remove(int id) {
		if (!AnimalManagerDaoImplHelper.isDeleted(id)) {
			AnimalBreed animalBreed = animalBreedRepository.findAnimalById(id);
			animalBreed.setId(id);
			animalBreed.setDeleted(true);
			animalBreedRepository.save(animalBreed);
		} // animalRepository.delete(animal);
	}

	@Override
	public AnimalBreed add(AnimalBreed animalBreed) {
		try {
			animalBreedRepository.save(animalBreed);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return animalBreed;
	}

	@Override
	public AnimalBreed update(int id, AnimalBreed animalBreed) {
		if (AnimalManagerDaoImplHelper.existId(id)) {
			animalBreed.setId(id);
			animalBreedRepository.save(animalBreed);
			return animalBreed;
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> findAll() {
		return AnimalBreedManagerDaoImplHelper.findAll();
	}

	@Override
	public boolean exist(AnimalBreed animalBreed) {
		if (!AnimalBreedManagerDaoImplHelper.validate(animalBreed)) {
			return false;
		}
		return true;
	}

}

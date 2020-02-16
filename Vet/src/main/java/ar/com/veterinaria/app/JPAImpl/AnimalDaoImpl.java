package ar.com.veterinaria.app.JPAImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.com.veterinaria.app.dao.AnimalDao;
import ar.com.veterinaria.app.entities.Animal;
import ar.com.veterinaria.app.helper.daoImpl.AnimalManagerDaoImplHelper;
import ar.com.veterinaria.app.repository.AnimalRepository;

@Repository
public class AnimalDaoImpl implements AnimalDao {

	private static final Logger logger = LoggerFactory.getLogger(AnimalDaoImpl.class);

	@Autowired
	private AnimalRepository animalRepository;

	public AnimalDaoImpl() {
		super();
	}

	@Override
	public Animal findById(int id) {
		try {
			return animalRepository.findBreedById(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public void remove(int id) {
		try {
			Animal animal = new Animal();
			animal.setId(id);
			animalRepository.delete(animal);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public Animal add(Animal breed) {
		try {
			animalRepository.save(breed);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return breed;
	}

	@Override
	public Animal update(int id, Animal animal) {
		if (AnimalManagerDaoImplHelper.existId(id)) {
			animal.setId(id);
			animalRepository.save(animal);
			return animal;
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> findAll() {
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map = new HashMap<>();
			List<Animal> result = animalRepository.findAll();
			for (Animal animal : result) {
				map = new HashMap<>();
				map.put(animal.getId().toString(), animal);
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public boolean exist(Animal animal) {
		if (!AnimalManagerDaoImplHelper.validate(animal)) {
			return false;
		}
		return true;
	}

}

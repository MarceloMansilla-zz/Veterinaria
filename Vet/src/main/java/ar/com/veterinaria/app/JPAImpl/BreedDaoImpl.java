package ar.com.veterinaria.app.JPAImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ar.com.veterinaria.app.dao.BreedDao;
import ar.com.veterinaria.app.entities.Breed;
import ar.com.veterinaria.app.helper.BreedDaoImplHelper;
import ar.com.veterinaria.app.repository.BreedRepository;

@Repository
public class BreedDaoImpl implements BreedDao {

	private static final Logger logger = LoggerFactory.getLogger(BreedDaoImpl.class);

	@Autowired
	private BreedRepository breedRepository;

	public BreedDaoImpl() {
		super();
	}

	@Override
	public Breed findById(int id) {
		try {
			return breedRepository.findBreedById(id);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public void remove(int id) {
		try {
			Breed breed = new Breed();
			breed.setId(id);
			breedRepository.delete(breed);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	@Override
	public Breed add(Breed breed) {
		try {
			breedRepository.save(breed);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return breed;
	}

	@Override
	public Breed update(int id, Breed breed) {
		try {
			breed.setId(id);
			breedRepository.save(breed);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return breed;
	}

	@Override
	public List<Map<String, Object>> findAll() {
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map = new HashMap<>();
			List<Breed> result = breedRepository.findAll();
			for (Breed breed : result) {
				map = new HashMap<>();
				map.put(breed.getId().toString(), breed);
				list.add(map);
			}
			return list;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public boolean exist(Breed breed) {
		if (BreedDaoImplHelper.isDuplicated(breedRepository, breed)) {
			return true;
		}
		return false;
	}

}

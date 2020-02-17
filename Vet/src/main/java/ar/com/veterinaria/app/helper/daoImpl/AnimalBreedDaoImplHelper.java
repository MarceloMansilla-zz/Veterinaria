package ar.com.veterinaria.app.helper.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.AnimalBreed;
import ar.com.veterinaria.app.helper.daoImpl.contract.AnimalBreedContractDaoImplHelper;

@Service
public class AnimalBreedDaoImplHelper implements AnimalBreedContractDaoImplHelper {

	private static final Logger logger = LoggerFactory.getLogger(AnimalBreedDaoImplHelper.class);

	@Override
	public boolean isDuplicated(JpaRepository<AnimalBreed, Integer> repository, AnimalBreed animal) {
		List<AnimalBreed> result = repository.findAll();
		int ini = 0;
		while (ini < result.size()) {
			AnimalBreed animalBreed = result.get(ini);
			if (animalBreed.getAnimal().getName().equals(animal.getAnimal().getName())) {
				return true;
			}
			ini++;
		}
		return false;
	}

	@Override
	public boolean existId(JpaRepository<AnimalBreed, Integer> repository, Integer id) {
		List<AnimalBreed> result = repository.findAll();
		int ini = 0;
		while (ini < result.size()) {
			AnimalBreed aAnimal = result.get(ini);
			if (aAnimal.getAnimal().getId().equals(id)) {
				return true;
			}
			ini++;
		}
		return false;
	}

	@Override
	public boolean deleted(JpaRepository<AnimalBreed, Integer> repository, Integer id) {
		List<AnimalBreed> result = repository.findAll();
		int ini = 0;
		while (ini < result.size()) {
			AnimalBreed animalBreed = result.get(ini);
			if (animalBreed.getId().equals(id) && animalBreed.isDeleted()) {
				return true;
			}
			ini++;
		}

		return false;
	}

	@Override
	public List<Map<String, Object>> findAll(JpaRepository<AnimalBreed, Integer> repository) {
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map = new HashMap<>();
			List<AnimalBreed> result = repository.findAll();
			for (AnimalBreed animalBreed : result) {
				map = new HashMap<>();
				if (!animalBreed.isDeleted()) {
					map.put(animalBreed.getId().toString(), animalBreed);
					list.add(map);
				}
			}
			return list;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}
}

package ar.com.veterinaria.app.service;

import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.dao.BreedDao;
import ar.com.veterinaria.app.entities.Breed;
import ar.com.veterinaria.app.helper.service.BreedServiceHelper;
import ar.com.veterinaria.app.service.contract.BreedContractService;

@Service
@Transactional
public class BreedService implements BreedContractService {

	@Autowired
	private BreedDao breedDao;

	@Autowired
	private BreedServiceHelper breedServiceHelper;

	public BreedService() {
	}

	@Override
	public Breed findById(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID cannot be 0 or < 0");
		}
		return breedDao.findById(id);
	}

	@Override
	public void remove(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID cannot be 0 or < 0 or this id do not exist");
		}
		breedDao.remove(id);
	}

	@Override
	public List<Map<String, Object>> findAll() {
		List<Map<String, Object>> result = breedDao.findAll();
		if (result.size() > 0) {
			return result;
		}
		return null;
	}

	@Override
	public Breed add(Breed t) {
		if (t == null) {
			throw new IllegalArgumentException("The passed object cannot be null.");
		}
		return breedDao.add(t);
	}

	@Override
	public Breed update(int id, Breed breed) {
		if (breed == null) {
			throw new IllegalArgumentException("The passed object cannot be null.");
		}
		if (id <= 0) {
			throw new IllegalArgumentException("ID cannot be 0 or < 0 or this id do not exist");
		}
		return breedDao.update(id, breed);
	}

	@Override
	public boolean exist(Breed breed) {
		if (breed == null) {
			throw new IllegalArgumentException("The passed object cannot be null.");
		}
		return breedDao.exist(breed);
	}

	@Override
	public boolean isValidInputData(Breed t) {
		if (breedServiceHelper.isValidName(t)) {
			return true;
		}
		return false;
	}

}

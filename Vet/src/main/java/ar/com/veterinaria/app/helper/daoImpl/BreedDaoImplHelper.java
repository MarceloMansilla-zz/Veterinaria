package ar.com.veterinaria.app.helper.daoImpl;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import ar.com.veterinaria.app.entities.Breed;
import ar.com.veterinaria.app.helper.daoImpl.contract.BreedContractDaoImplHelper;

@Service
public class BreedDaoImplHelper implements BreedContractDaoImplHelper {

	@Override
	public boolean isDuplicated(JpaRepository<Breed, Integer> repository, Breed breed) {
		List<Breed> result = repository.findAll();
		int ini = 0;
		while (ini < result.size()) {
			Breed aBreed = result.get(ini);
			if (aBreed.getBreed().equals(breed.getBreed())) {
				return true;
			}
			ini++;
		}
		return false;
	}
}

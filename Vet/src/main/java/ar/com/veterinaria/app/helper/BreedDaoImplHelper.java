package ar.com.veterinaria.app.helper;

import java.util.List;

import ar.com.veterinaria.app.entities.Breed;
import ar.com.veterinaria.app.repository.BreedRepository;

public class BreedDaoImplHelper {
	public static boolean isDuplicated(BreedRepository breedRepository, Breed breed) {
		List<Breed> result = breedRepository.findAll();
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

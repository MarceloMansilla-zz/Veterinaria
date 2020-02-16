package ar.com.veterinaria.app.helper.daoImpl;

import java.util.List;
import ar.com.veterinaria.app.entities.Animal;
import ar.com.veterinaria.app.repository.AnimalRepository;

public class AnimalDaoImplHelper {
	public static boolean isDuplicated(AnimalRepository animalRepository, Animal animal) {
		List<Animal> result = animalRepository.findAll();
		int ini = 0;
		while (ini < result.size()) {
			Animal aAnimal = result.get(ini);
			if (aAnimal.getName().equals(animal.getName())) {
				return true;
			}
			ini++;
		}
		return false;
	}
}

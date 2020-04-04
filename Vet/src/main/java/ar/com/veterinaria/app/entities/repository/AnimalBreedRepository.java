package ar.com.veterinaria.app.entities.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.veterinaria.app.entities.AnimalBreed;

public interface AnimalBreedRepository extends JpaRepository<AnimalBreed, Integer> {

	AnimalBreed findAnimalBreedById(Integer id);

	List<AnimalBreed> findAll();

	@SuppressWarnings("unchecked")
	AnimalBreed save(AnimalBreed animalBreed);

	void delete(AnimalBreed snimalBreed);
}

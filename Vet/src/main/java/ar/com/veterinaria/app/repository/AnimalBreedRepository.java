package ar.com.veterinaria.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.veterinaria.app.entities.AnimalBreed;

public interface AnimalBreedRepository extends JpaRepository<AnimalBreed, Integer> {

	AnimalBreed findAnimalById(Integer id);

	List<AnimalBreed> findAll();

	@SuppressWarnings("unchecked")
	AnimalBreed save(AnimalBreed animalBreed);

	void delete(AnimalBreed snimalBreed);
}

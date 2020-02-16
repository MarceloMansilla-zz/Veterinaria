package ar.com.veterinaria.app.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.veterinaria.app.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {

	Animal findBreedById(Integer id);

	List<Animal> findAll();

	@SuppressWarnings("unchecked")
	Animal save(Animal animal);

	void delete(Animal animal);
}

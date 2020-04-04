package ar.com.veterinaria.app.entities.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.veterinaria.app.entities.Breed;

public interface BreedRepository extends JpaRepository<Breed, Integer> {

	Breed findBreedById(Integer id);

	List<Breed> findAll();

	@SuppressWarnings("unchecked")
	Breed save(Breed breed);

	void delete(Breed breed);
}

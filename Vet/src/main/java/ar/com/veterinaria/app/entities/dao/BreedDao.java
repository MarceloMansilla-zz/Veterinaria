package ar.com.veterinaria.app.entities.dao;

import ar.com.veterinaria.app.entities.Breed;

public interface BreedDao extends BaseDao<Breed> {

	Breed findBreedByName(String breed);
}

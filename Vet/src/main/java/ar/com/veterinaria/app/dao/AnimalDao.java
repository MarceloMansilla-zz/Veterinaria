package ar.com.veterinaria.app.dao;

import ar.com.veterinaria.app.entities.Animal;

public interface AnimalDao extends BaseDao<Animal> {
	
	Animal findAnimalByName(String name);

}

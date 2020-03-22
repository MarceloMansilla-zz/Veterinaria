package ar.com.veterinaria.app.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.veterinaria.app.entities.Animal;
import ar.com.veterinaria.app.entities.AnimalBreed;
import ar.com.veterinaria.app.entities.Breed;

@RunWith(SpringRunner.class)
@DataJpaTest
@DisplayName("Test Animal Entity")
class AnimalBreedTest {

	@Rule
	private Animal animal;
	private Breed breed;
	private AnimalBreed animalBreedTwo;
	private AnimalBreed animalBreed;

	@BeforeEach
	public void setup() {
		animal = new Animal("cat", false);
		breed = new Breed("cat", false);
		animalBreedTwo = new AnimalBreed();
		animalBreed = new AnimalBreed(new Breed(), new Animal());
	}

	@Test
	@DisplayName("When AnimalBreed ID is not set, checking no match is ok")
	void test_Id() {
		assertNotEquals(3, animalBreed.getId());
	}

	@Test
	@DisplayName("When AnimalBreed ID is set, checking the match, so the case is ok")
	void test_set_id() {
		animalBreed.setId(1);
		assertThat(animalBreed.getId()).isEqualTo(1);

	}

	@Test
	@DisplayName("When AnimalBreed has a Breed associated, checking Not Null Breed, so the case is ok")
	void test_get_breed() {
		assertThat(animalBreed.getBreed()).isNotNull();
	}

	@Test
	@DisplayName("When AnimalBreed is set the Breed and it is NULL, checking Null, so the case is ok")
	void test_set_breed() {
		animalBreed.setBreed(null);
		assertThat(animalBreed.getBreed()).isNull();
	}

	@Test
	@DisplayName("When AnimalBreed Animal, checking it is Not Null, so the case is ok")
	void test_get_animal() {
		assertThat(animalBreed.getAnimal()).isNotNull();
	}

	@Test
	@DisplayName("When AnimalBreed set Animal to NULL, checking NULL, so the case is ok")
	void test_set_animal() {
		animalBreed.setAnimal(null);
		assertThat(animalBreed.getAnimal()).isNull();
	}

	@Test
	@DisplayName("When AnimalBreed is not DELETED,checking DELETED FALSE, so the case is ok")
	void test_is_deleted() {
		assertFalse(animalBreed.isDeleted());
	}

	@Test
	@DisplayName("When AnimalBreed is DELETED,checking DELETED TRUE, so the case is ok")
	void test_set_deleted() {
		animalBreed.setDeleted(true);
		assertTrue(animalBreed.isDeleted());
	}

	@Test
	@DisplayName("When AnimalBreed is created from SuperClass,checking Animal and Breed are not null, so the case is ok")
	void test_AnimalBreed_super_class() {
		animalBreedTwo.setAnimal(animal);
		animalBreedTwo.setBreed(breed);
		assertNotNull(animalBreedTwo.getAnimal());
		assertNotNull(animalBreedTwo.getBreed());
	}

}

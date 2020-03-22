package ar.com.veterinaria.app.entity;

import static org.assertj.core.api.Assertions.assertThat;
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

@RunWith(SpringRunner.class)
@DataJpaTest
@DisplayName("Test Animal Entity")
class AnimalTest {

	@Rule
	private Animal animal;
	private Animal animalTwo;

	@BeforeEach
	public void setup() {
		animal = new Animal();
		animalTwo = new Animal("cat", false);
	}

	@Test
	@DisplayName("When I insert a valid ID, so the case is ok")
	void test_Id() {
		assertNotEquals(2, animal.getId());
	}

	@Test
	@DisplayName("When I insert a valid NAME, so the case is ok")
	void test_Name() {
		assertNotEquals("perro", animal.getName());
	}

	@Test
	@DisplayName("When I create a Animal with paramether at the moment of creation, so the case is ok")
	void test_Animal_Two_Set_Name() {
		assertThat(animalTwo.getName()).isEqualTo("cat");
	}

	@Test
	@DisplayName("When I insert a true value in Deleted, checking is deleted TRUE, the case is ok")
	void test_Is_Deleted() {
		animal.setDeleted(true);
		assertThat(animal.isDeleted());
	}

	@Test
	@DisplayName("When I insert a valid ID, so the case is ok")
	void test_Set_Id() {
		animal.setId(3);
		assertThat(animal.getId()).isEqualTo(3);
	}

	@Test
	@DisplayName("When I insert empty name, checking is empty, the case is ok")
	void test_Empty_Name() {
		animal.setName("");
		assertThat(animal.getName()).isEqualTo("");
	}

	@Test
	@DisplayName("When I insert a true value in Deleted, checking is deleted FALSE, the case is ok")
	void test_Is_Not_Deleted() {
		animal.setDeleted(false);
		assertFalse(animal.isDeleted());
	}

}

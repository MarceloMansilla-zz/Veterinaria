package ar.com.veterinaria.app.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import org.junit.Rule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ar.com.veterinaria.app.entities.Breed;

@RunWith(SpringRunner.class)
@DataJpaTest
@DisplayName("Test Breed Entity")
class BreedTest {

	@Rule
	private Breed breed = new Breed();
	private Breed breedTwo = new Breed("dogo", false);

	@Test
	@DisplayName("When I insert a valid ID, so the case is ok")
	void test_Id() {
		assertNotEquals(2, breed.getId());
	}

	@Test
	@DisplayName("When I insert a valid NAME, so the case is ok")
	void test_Name() {
		assertNotEquals("perro", breed.getBreed());
	}

	@Test
	@DisplayName("When I create a Breed with paramether at the moment of creation, so the case is ok")
	void test_Animal_Two_Set_Name() {
		assertThat(breedTwo.getBreed()).isEqualTo("dogo");
	}

	@Test
	@DisplayName("When I insert a true value in Deleted, checking is deleted TRUE, the case is ok")
	void test_Is_Deleted() {
		breed.setDeleted(true);
		assertThat(breed.isDeleted());
	}

	@Test
	@DisplayName("When I insert a valid ID, so the case is ok")
	void test_Set_Id() {
		breed.setId(3);
		assertThat(breed.getId()).isEqualTo(3);
	}

	@Test
	@DisplayName("When I insert empty name, checking is empty, the case is ok")
	void test_Empty_Name() {
		breed.setBreed("");
		assertThat(breed.getBreed()).isEqualTo("");
	}

	@Test
	@DisplayName("When I insert a true value in Deleted, checking is deleted FALSE, the case is ok")
	void test_Is_Not_Deleted() {
		breed.setDeleted(false);
		assertFalse(breed.isDeleted());
	}

}

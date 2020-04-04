package ar.com.veterinaria.app.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
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
import ar.com.veterinaria.app.entities.ClinicalHistory;
import ar.com.veterinaria.app.entities.Pet;

@RunWith(SpringRunner.class)
@DataJpaTest
@DisplayName("Test Animal Entity")
class PetTest {

	private Animal animal;
	private Breed breed;
	private AnimalBreed animalBreed;
	private ClinicalHistory clinicalHistory;
	private Pet pet;
	private Pet petTwo;

	@Rule
	@BeforeEach
	public void setup() {
		animal = new Animal("perro", false);
		breed = new Breed("dogo", false);
		animalBreed = new AnimalBreed(breed, animal);
		clinicalHistory = new ClinicalHistory("M726");
		pet = new Pet();
		petTwo = new Pet("nano", null, "pequeño", animalBreed, clinicalHistory);
	}

	@Test
	@DisplayName("When Pet ID is not 0, checking is ok, so the case is ok")
	void test_Set_Id() {
		petTwo.setId(2);
		assertEquals(2, petTwo.getId());
	}

	@Test
	@DisplayName("When Pet ID is not set, checking is not set, so the case is ok")
	void test_Get_Id() {
		assertNotEquals(2, petTwo.getId());
	}

	@Test
	@DisplayName("When Pet NAME is correct, checking it is equals, so the case is ok")
	void test_Get_Name() {
		assertEquals("nano", petTwo.getName());
	}

	@Test
	@DisplayName("When Pet NAME is not correct, checking wrong name, so the case is ok")
	void test_Set_Name() {
		petTwo.setName("A");
		assertNotEquals("nano", petTwo.getName());
	}

	@Test
	@DisplayName("When Pet BIRTHDAY, checking Year is not correct, so the case is ok")
	void test_Set_Birthday() {
		petTwo.setBirthday(null);
		assertNotEquals(2020, petTwo.getBirthday().getYear());
	}

	@Test
	@DisplayName("When Pet BIRTHDAY, checking Year is correct, so the case is ok")
	void test_Get_Birthday() {
		assertEquals(2009, petTwo.getBirthday().getYear());
	}

	@Test
	@DisplayName("When Pet SIZE, checking Size is correct, so the case is ok")
	void test_Get_Size() {
		assertEquals("pequeño", petTwo.getSize());
	}

	@Test
	@DisplayName("When Pet SIZE, checking Size is not correct, so the case is ok")
	void test_Set_Size() {
		petTwo.setSize("mediano");
		assertThat(petTwo.getSize()).isNotEqualTo("pequeño");
	}

	@Test
	@DisplayName("When Pet DELETED, checking Deleted is True, so the case is ok")
	void test_Set_Deleted() {
		petTwo.setDeleted(true);
		assertThat(petTwo.isDeleted()).isTrue();
	}

	@Test
	@DisplayName("When Pet DELETED, checking Size is False, so the case is ok")
	void test_Get_Deleted() {
		assertThat(petTwo.isDeleted()).isFalse();
	}

	@Test
	@DisplayName("When Pet ANIMALBREED, checking AnimalBreed is not nutll, so the case is ok")
	void test_Get_AnimalBreed() {
		assertThat(petTwo.getAnimalBreed()).isNotNull();
	}

	@Test
	@DisplayName("When Pet ANIMALBREED, checking AnimalBreed is Null, so the case is ok")
	void test_Set_AnimalBreed() {
		petTwo.setAnimalBreed(null);
		assertThat(petTwo.getAnimalBreed()).isNull();
	}

	@Test
	@DisplayName("When Pet CLINCLAHISTORY, checking ClinicalHistory is Null, so the case is ok")
	void test_Set_ClinicalHistory() {
		petTwo.setClinicalHistory(null);
		assertThat(petTwo.getClinicalHistory()).isNull();
	}

	@Test
	@DisplayName("When Pet CLINICALHISTORY, checking ClinicalHistory is not Null, so the case is ok")
	void test_Get_ClinicalHistory() {
		assertThat(petTwo.getClinicalHistory()).isNotNull();
	}

	@Test
	@DisplayName("When Pet empty, checking Pet Name is Null, so the case is ok")
	void test_Constructor_Super_Class() {
		assertThat(pet.getName()).isNull();
	}
}
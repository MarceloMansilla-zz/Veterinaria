package ar.com.veterinaria.app.entity;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import ar.com.veterinaria.app.entities.Animal;

class AnimalTest {

	private Animal animal = mock(Animal.class);

	@Before(value = "")
	void setup() {
		animal.setId(1);
		animal.setName("perro");
		animal.setDeleted(false);
	}

	@Test
	void testId() {
		assertNotEquals(2,animal.getId());
	}

	@Test
	void testName() {
		assertNotEquals("perro",animal.getName());
	}

	@Test
	void testIsDeleted() {
		assertFalse(animal.isDeleted());
	}

}

package ar.com.veterinaria.app.entity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import ar.com.veterinaria.app.entities.Address;

@RunWith(SpringRunner.class)
@DataJpaTest
@DisplayName("Test Address Entity")
class AddressTest {

	@Rule
	private Address address;
	private Address addressTwo;

	@BeforeEach
	public void setup() {
		address = new Address();
		addressTwo = new Address(54652, "AA", "Buenos Aires", "Quilmes", 1887);
	}

	// number, name, city, department, zip code
	@Test
	@DisplayName("When I insert a valid ID Address, so the case is ok")
	void test_Id_Address_Is_Not_Cero() {
		address.setId(1);
		assertEquals(1, address.getId());
	}

	@Test
	@DisplayName("When I insert a valid Number Address, so the case is ok")
	void test_Number_Address_Is_Not_Cero() {
		assertEquals(54652, addressTwo.getNumber());
	}

	@Test
	@DisplayName("When I insert an invalid Number Address, checking is 0, so the case is ok")
	void test_Number_Address_Is_Cero() {
		address.setNumber(0);
		assertEquals(0, address.getNumber());
	}

	@Test
	@DisplayName("When I insert a valid NAME, so the case is ok")
	void test_Name_Address_Not_Empty() {
		assertThat(addressTwo.getName()).isEqualTo("AA");
	}

	@Test
	@DisplayName("When I insert an empty NAME, so the case is ok if it is matched with '' ")
	void test_Name_Address_Is_Empty() {
		address.setName("");
		assertThat(address.getName()).isEqualTo("");
	}

	@Test
	@DisplayName("When City Address is not empty and is a valid one, the case is ok")
	void test_City_Address_Is_Not_Empty() {
		assertThat(addressTwo.getCity()).isEqualTo("Buenos Aires");
	}

	@Test
	@DisplayName("When City Address is empty, so the case is ok")
	void test_City_Address_Is_Empty() {
		address.setCity("");
		assertThat(address.getCity()).isEqualTo("");
	}

	@Test
	@DisplayName("When Departemen Address is not empty, checking is empty, the case is ok")
	void test_Department_Address_Is_Not_Empty() {
		assertThat(addressTwo.getDepartment()).isEqualTo("Quilmes");
	}

	@Test
	@DisplayName("When Department Address is empty, checking is empty, the case is ok")
	void test_Department_Address_Is_Empty() {
		address.setDepartment("");
		assertThat(address.getDepartment()).isEqualTo("");
	}

	@Test
	@DisplayName("When Departemen Address is not empty, checking is empty, the case is ok")
	void test_Zip_Code_Address_Is_Not_Empty() {
		assertThat(addressTwo.getZip()).isEqualTo(1887);
	}

	@Test
	@DisplayName("When Department Address is empty, checking is empty, the case is ok")
	void test_Zip_Code_Address_Is_Not_Cero() {
		address.setZip(10);
		assertThat(address.getZip()).isNotEqualTo(0);
	}

	@Test
	@DisplayName("When Department Address is empty, checking is empty, the case is ok")
	void test_Deleted_Address_Is_False() {
		assertThat(addressTwo.isDeleted()).isFalse();
	}

	@Test
	@DisplayName("When Deleted Address is TRUE, checking is TRUE, the case is ok")
	void test_Deleted_Address_Is_True() {
		address.setDeleted(true);
		assertThat(address.isDeleted()).isTrue();
	}

}
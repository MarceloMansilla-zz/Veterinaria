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
import ar.com.veterinaria.app.entities.ClinicalHistory;

@RunWith(SpringRunner.class)
@DataJpaTest
@DisplayName("Test ClinicalHistory Entity")
class ClinicalHistoryTest {

	@Rule
	private ClinicalHistory clinicalHistory = new ClinicalHistory();
	private ClinicalHistory clinicalHistoryTwo = new ClinicalHistory("J5687", false);

	@Test
	@DisplayName("When I insert a valid ID, so the case is ok")
	void test_Id() {
		assertNotEquals(2, clinicalHistory.getId());
	}

	@Test
	@DisplayName("When I insert a valid NAME, so the case is ok")
	void test_Name() {
		clinicalHistory.setClinicalHistory("M1234");
		assertThat(clinicalHistory.getClinicalHistory()).isEqualTo("M1234");
	}

	@Test
	@DisplayName("When I create a ClinicalHistory with paramether at the moment of creation, so the case is ok")
	void test_Clinical_History_Two_Set_Name() {
		clinicalHistoryTwo.setClinicalHistory("J5678");
		assertThat(clinicalHistoryTwo.getClinicalHistory()).isEqualTo("J5678");
	}

	@Test
	@DisplayName("When I insert a true value in Deleted, checking is deleted TRUE, the case is ok")
	void test_Is_Deleted() {
		clinicalHistory.setDeleted(true);
		assertThat(clinicalHistory.isDeleted());
	}

	@Test
	@DisplayName("When I insert a valid ID, so the case is ok")
	void test_Set_Id() {
		clinicalHistory.setId(3);
		assertThat(clinicalHistory.getId()).isEqualTo(3);
	}

	@Test
	@DisplayName("When I insert empty name, checking is empty, the case is ok")
	void test_Empty_Name() {
		clinicalHistory.setClinicalHistory("");
		assertThat(clinicalHistory.getClinicalHistory()).isEqualTo("");
	}

	@Test
	@DisplayName("When I insert a true value in Deleted, checking is deleted FALSE, the case is ok")
	void test_Is_Not_Deleted() {
		clinicalHistory.setDeleted(false);
		assertFalse(clinicalHistory.isDeleted());
	}

}

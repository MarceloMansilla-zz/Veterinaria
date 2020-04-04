package ar.com.veterinaria.app.entities.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.veterinaria.app.entities.ClinicalHistory;

public interface ClinicalHistoryRepository extends JpaRepository<ClinicalHistory, Integer> {

	ClinicalHistory findClinicalHistoryById(Integer id);

	List<ClinicalHistory> findAll();

	@SuppressWarnings("unchecked")
	ClinicalHistory save(ClinicalHistory clinicalHistory);

	void delete(ClinicalHistory clinicalHistory);
}

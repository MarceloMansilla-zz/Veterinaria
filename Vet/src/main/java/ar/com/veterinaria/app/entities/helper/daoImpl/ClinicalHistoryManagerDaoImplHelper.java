package ar.com.veterinaria.app.entities.helper.daoImpl;

import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.ClinicalHistory;
import ar.com.veterinaria.app.entities.exception.ClinicalHistoryException;
import ar.com.veterinaria.app.entities.exception.notFound.BreedNotFoundException;
import ar.com.veterinaria.app.entities.exception.notFound.ClinicalHistoryNotFoundException;
import ar.com.veterinaria.app.entities.repository.ClinicalHistoryRepository;

@Service
@Transactional
public class ClinicalHistoryManagerDaoImplHelper {

	@Autowired
	private static ClinicalHistoryRepository clinicalHistoryRepository;

	@Autowired
	private static ClinicalHistoryDaoImplHelper clinicalHistoryDaoImplHelper;

	@SuppressWarnings("static-access")
	@Autowired
	public ClinicalHistoryManagerDaoImplHelper(ClinicalHistoryDaoImplHelper clinicalHistoryDaoImplHelper,
			ClinicalHistoryRepository clinicalHistoryRepository) {
		this.clinicalHistoryDaoImplHelper = clinicalHistoryDaoImplHelper;
		this.clinicalHistoryRepository = clinicalHistoryRepository;
	}

	public static boolean validate(ClinicalHistory clinicalHistory) {
		if (clinicalHistoryDaoImplHelper.isDuplicated(clinicalHistoryRepository, clinicalHistory)) {
			throw new ClinicalHistoryException(clinicalHistory.getClinicalHistory());
		}
		return false;
	}

	public static boolean existId(Integer id) {
		if (clinicalHistoryDaoImplHelper.existId(clinicalHistoryRepository, id)) {
			return true;
		}
		throw new ClinicalHistoryNotFoundException(id);

	}

	public static boolean isDeleted(Integer id) {
		if (!clinicalHistoryDaoImplHelper.deleted(clinicalHistoryRepository, id)) {
			return false;
		}
		throw new ClinicalHistoryNotFoundException(id);

	}

	public static List<Map<String, Object>> findAll() {
		return clinicalHistoryDaoImplHelper.findAll(clinicalHistoryRepository);
	}

	public static ClinicalHistory findClinicalHistoryByName(String t) {
		ClinicalHistory clinicalHistory = clinicalHistoryDaoImplHelper.findByName(clinicalHistoryRepository, t);
		if (clinicalHistory != null) {
			return clinicalHistory;
		}
		throw new BreedNotFoundException(t);
	}

	public static ClinicalHistory updateClinicalHistory(Integer id, ClinicalHistory clinicalHistory) {
		ClinicalHistory cClinicalHistory = clinicalHistoryDaoImplHelper.update(clinicalHistoryRepository, id,
				clinicalHistory);
		cClinicalHistory.setId(id);
		cClinicalHistory.setClinicalHistory(clinicalHistory.getClinicalHistory());
		return cClinicalHistory;
	}

}

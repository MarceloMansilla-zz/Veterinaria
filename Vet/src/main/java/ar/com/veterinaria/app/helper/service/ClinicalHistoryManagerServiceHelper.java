package ar.com.veterinaria.app.helper.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.ClinicalHistory;
import ar.com.veterinaria.app.exception.invalidData.ClinicalHistoryInvalidDataException;
import ar.com.veterinaria.app.exception.validationLength.ClinicalHistoryValidationLengthDataException;

@Service
@Transactional
public class ClinicalHistoryManagerServiceHelper {

	@Autowired
	private static ClinicalHistoryServiceHelper clinicalHistoryServiceHelper;

	@Autowired
	public ClinicalHistoryManagerServiceHelper(ClinicalHistoryServiceHelper clinicalServiceHelper) {
		this.clinicalHistoryServiceHelper = clinicalServiceHelper;
	}

	public static boolean validate(ClinicalHistory clinicalHistory) {
		if (!clinicalHistoryServiceHelper.isValidName(clinicalHistory)) {
			throw new ClinicalHistoryInvalidDataException(clinicalHistory);

		} else if (!clinicalHistoryServiceHelper.isValidLengthname(clinicalHistory)) {
			throw new ClinicalHistoryValidationLengthDataException(clinicalHistory);
		}
		return true;
	}
}

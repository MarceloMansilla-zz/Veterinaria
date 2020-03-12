package ar.com.veterinaria.app.helper.service;

import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.ClinicalHistory;
import ar.com.veterinaria.app.helper.service.contract.ClinicalHistoryContractServiceHelper;

@Service
public class ClinicalHistoryServiceHelper extends BaseServiceHelper implements ClinicalHistoryContractServiceHelper {

	@Override
	public boolean isValidName(ClinicalHistory clinicalHistory) {
		if (getNamePattern().matcher(clinicalHistory.getClinicalHistory()).matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isValidLengthname(ClinicalHistory clinicalHistory) {
		if (clinicalHistory.getClinicalHistory().length() < 50) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isValidClinicalHistory(ClinicalHistory clinicalHistory) {
		if (getNumberLetterPattern().matcher(clinicalHistory.getClinicalHistory()).matches()) {
			return true;
		}
		return false;
	}
}

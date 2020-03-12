package ar.com.veterinaria.app.helper.service.contract;

import ar.com.veterinaria.app.entities.ClinicalHistory;

public interface ClinicalHistoryContractServiceHelper extends BaseContractServiceHelper<ClinicalHistory> {
	boolean isValidClinicalHistory(ClinicalHistory clinicalHistory);
}

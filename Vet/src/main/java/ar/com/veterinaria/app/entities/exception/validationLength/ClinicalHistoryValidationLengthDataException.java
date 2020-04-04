package ar.com.veterinaria.app.entities.exception.validationLength;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ar.com.veterinaria.app.entities.ClinicalHistory;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ClinicalHistoryValidationLengthDataException extends RuntimeException {

	private static final long serialVersionUID = -6430489116264901564L;

	public ClinicalHistoryValidationLengthDataException(ClinicalHistory clinicalHistory) {
		super("Length name is over 10 character: " + clinicalHistory.getClinicalHistory().length() + " for name: "
				+ clinicalHistory.getClinicalHistory());
	}

}

package ar.com.veterinaria.app.entities.exception;

public class ClinicalHistoryException extends RuntimeException {

	private static final long serialVersionUID = 6069524392661034666L;

	public ClinicalHistoryException(String clinicalHistory) {
		super(clinicalHistory);
	}

}

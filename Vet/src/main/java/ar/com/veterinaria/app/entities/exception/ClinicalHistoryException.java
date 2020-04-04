package ar.com.veterinaria.app.entities.exception;

public class ClinicalHistoryException extends RuntimeException {
	private static final long serialVersionUID = 3236300135252592189L;

	public ClinicalHistoryException(String clinicalHistory) {
		super(clinicalHistory);
	}

}

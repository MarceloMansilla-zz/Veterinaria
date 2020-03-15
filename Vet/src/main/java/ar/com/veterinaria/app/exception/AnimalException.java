package ar.com.veterinaria.app.exception;

public class AnimalException extends RuntimeException {

	private static final long serialVersionUID = 1093306691287711077L;

	public AnimalException(String message) {
		super(message);
	}
}

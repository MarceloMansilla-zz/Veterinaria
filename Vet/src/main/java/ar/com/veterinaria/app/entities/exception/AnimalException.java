package ar.com.veterinaria.app.entities.exception;

public class AnimalException extends RuntimeException {

	private static final long serialVersionUID = 3532393262006946524L;

	public AnimalException(String message) {
		super(message);
	}
}

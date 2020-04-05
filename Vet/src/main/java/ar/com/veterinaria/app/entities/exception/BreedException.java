package ar.com.veterinaria.app.entities.exception;

public class BreedException extends RuntimeException {

	private static final long serialVersionUID = -6474627953400325054L;

	public BreedException(String breed) {
		super(breed);
	}

}

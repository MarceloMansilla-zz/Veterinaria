package ar.com.veterinaria.app.entities.exception;

public class BreedException extends RuntimeException {

	private static final long serialVersionUID = 1093306691287711077L;

	public BreedException(String breed) {
		super(breed);
	}
	

}

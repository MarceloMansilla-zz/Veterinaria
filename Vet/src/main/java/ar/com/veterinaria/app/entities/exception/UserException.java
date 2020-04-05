package ar.com.veterinaria.app.entities.exception;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = -7904319064815187365L;

	public UserException(String user) {
		super(user);
	}

}

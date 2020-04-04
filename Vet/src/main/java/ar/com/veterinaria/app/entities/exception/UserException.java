package ar.com.veterinaria.app.entities.exception;

public class UserException extends RuntimeException {

	private static final long serialVersionUID = 6530173534290624765L;

	public UserException(String user) {
		super(user);
	}

}

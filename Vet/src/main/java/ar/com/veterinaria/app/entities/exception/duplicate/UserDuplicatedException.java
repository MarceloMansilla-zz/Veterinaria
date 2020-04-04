package ar.com.veterinaria.app.entities.exception.duplicate;

import ar.com.veterinaria.app.entities.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserDuplicatedException extends RuntimeException {

	private static final long serialVersionUID = 8523850246335839709L;

	public UserDuplicatedException(String user) {
		super("The User " + user + "' already exists.");
	}

	public UserDuplicatedException(int id) {
		super("The User with id '" + id + "' already exists.");
	}

	public UserDuplicatedException(User userEmail) {
		super("The User Email" + userEmail.getEmail() + "' already exists.");
	}
}

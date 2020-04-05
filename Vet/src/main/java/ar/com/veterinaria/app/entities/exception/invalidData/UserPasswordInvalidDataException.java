package ar.com.veterinaria.app.entities.exception.invalidData;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ar.com.veterinaria.app.entities.user.User;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class UserPasswordInvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 1650735434131623651L;

	public UserPasswordInvalidDataException(User user) {
		super("Invalid Password: " + user.getPassword()+"\n it must Capital and Lower letter, Number, Alphanumeric");
	}

}

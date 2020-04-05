package ar.com.veterinaria.app.exception.duplicate.authentication;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class PasswordNotMatchException extends RuntimeException {

	private static final long serialVersionUID = -3010732737962097641L;

	public PasswordNotMatchException() {
		super("The Password and Confirm Password does not match.");
	}
}

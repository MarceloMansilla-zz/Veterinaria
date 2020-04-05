package ar.com.veterinaria.app.entities.exception.duplicate;

import ar.com.veterinaria.app.entities.Address;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AddressDuplicatedException extends RuntimeException {

	private static final long serialVersionUID = -4490981572236025999L;

	public AddressDuplicatedException(String address) {
		super("The Address '" + address + "' already exists.");
	}

	public AddressDuplicatedException(int id) {
		super("The Address with id '" + id + "' already exists.");
	}

	public AddressDuplicatedException(Address address) {
		super("The Address '" + address + "' already exists.");
	}
}

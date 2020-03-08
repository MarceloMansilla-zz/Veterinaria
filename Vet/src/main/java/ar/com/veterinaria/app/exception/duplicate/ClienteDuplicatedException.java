package ar.com.veterinaria.app.exception.duplicate;

import ar.com.veterinaria.app.entities.Cliente;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ClienteDuplicatedException extends RuntimeException {

	private static final long serialVersionUID = 1093306691287711077L;

	public ClienteDuplicatedException(String cliente) {
		super("The Cliente '" + cliente + "' already exists.");
	}

	public ClienteDuplicatedException(int id) {
		super("The Cliente with id '" + id + "' already exists.");
	}

	public ClienteDuplicatedException(Cliente cliente) {
		super("The Cliente '" + cliente + "' already exists.");
	}
}

package ar.com.veterinaria.app.exception.notFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ar.com.veterinaria.app.entities.Cliente;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ClienteNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1093306691287711077L;

	public ClienteNotFoundException(Integer id) {
		super("Could not find Cliente with id " + id);
	}

	public ClienteNotFoundException(String cliente) {
		super("Could not find Cliente: " + cliente);
	}

	public ClienteNotFoundException(Cliente cliente) {
		super("Could not find Cliente: " + cliente.toString());
	}

}

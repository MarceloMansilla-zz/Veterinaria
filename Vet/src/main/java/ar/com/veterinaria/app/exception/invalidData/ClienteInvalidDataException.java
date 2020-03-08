package ar.com.veterinaria.app.exception.invalidData;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ar.com.veterinaria.app.entities.Cliente;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ClienteInvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 1093306691287711077L;

	public ClienteInvalidDataException(Cliente cliente) {
		super("Invalid Cliente Name: " + cliente.getName() + ", it must be capital or lower letters");
	}

}

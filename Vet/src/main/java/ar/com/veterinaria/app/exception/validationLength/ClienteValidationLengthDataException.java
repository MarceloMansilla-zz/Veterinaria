package ar.com.veterinaria.app.exception.validationLength;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ar.com.veterinaria.app.entities.Cliente;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ClienteValidationLengthDataException extends RuntimeException {

	private static final long serialVersionUID = -6430489116264901564L;

	public ClienteValidationLengthDataException(Cliente cliente) {
		super("Length name is over 10 character: " + cliente.getName().length() + " for name: " + cliente.getName());
	}

}

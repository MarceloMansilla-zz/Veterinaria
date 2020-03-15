package ar.com.veterinaria.app.exception.invalidData;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ar.com.veterinaria.app.entities.Address;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AddressInvalidDataException extends RuntimeException {

	private static final long serialVersionUID = 1093306691287711077L;

	public AddressInvalidDataException(Address breed) {
		super("Invalid Breed Name: " + breed.getName() + ", it must be capital or lower letters");
	}

}

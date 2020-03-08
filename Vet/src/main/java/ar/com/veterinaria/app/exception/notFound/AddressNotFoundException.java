package ar.com.veterinaria.app.exception.notFound;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import ar.com.veterinaria.app.entities.Address;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AddressNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1093306691287711077L;

	public AddressNotFoundException(Integer id) {
		super("Could not find Address with id " + id);
	}

	public AddressNotFoundException(String address) {
		super("Could not find Address: " + address);
	}

	public AddressNotFoundException(Address address) {
		super("Could not find Address: " + address.toString());
	}

}

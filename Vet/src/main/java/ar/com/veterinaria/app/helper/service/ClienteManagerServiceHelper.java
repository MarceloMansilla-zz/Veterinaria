package ar.com.veterinaria.app.helper.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.Cliente;
import ar.com.veterinaria.app.exception.invalidData.ClienteInvalidDataException;
import ar.com.veterinaria.app.exception.validationLength.ClienteValidationLengthDataException;

@Service
@Transactional
public class ClienteManagerServiceHelper {

	@Autowired
	private static ClienteServiceHelper clienteServiceHelper;

	@Autowired
	public ClienteManagerServiceHelper(ClienteServiceHelper clienteServiceHelper) {
		this.clienteServiceHelper = clienteServiceHelper;
	}

	public static boolean validate(Cliente cliente) {
		if (!clienteServiceHelper.isValidName(cliente)) {
			throw new ClienteInvalidDataException(cliente);

		} else if (!clienteServiceHelper.isValidLengthname(cliente)) {
			throw new ClienteValidationLengthDataException(cliente);
		}
		return true;
	}
}

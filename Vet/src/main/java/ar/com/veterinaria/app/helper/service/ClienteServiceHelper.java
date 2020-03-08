package ar.com.veterinaria.app.helper.service;

import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.Cliente;
import ar.com.veterinaria.app.helper.service.contract.ClienteContractServiceHelper;

@Service
public class ClienteServiceHelper extends BaseServiceHelper implements ClienteContractServiceHelper {

	@Override
	public boolean isValidName(Cliente cliente) {
		if (getNamePattern().matcher(cliente.getName()).matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isValidLengthname(Cliente cliente) {
		if (cliente.getName().length() < 50) {
			return true;
		}
		return false;
	}
}

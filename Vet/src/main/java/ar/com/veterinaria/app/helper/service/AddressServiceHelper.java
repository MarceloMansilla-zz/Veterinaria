package ar.com.veterinaria.app.helper.service;

import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.Address;
import ar.com.veterinaria.app.helper.service.contract.AddressContractServiceHelper;

@Service
public class AddressServiceHelper extends BaseServiceHelper implements AddressContractServiceHelper {

	@Override
	public boolean isValidName(Address address) {
		if (getNamePattern().matcher(address.getName()).matches()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isValidLengthname(Address address) {
		if (address.getName().length() < 50) {
			return true;
		}
		return false;
	}
}

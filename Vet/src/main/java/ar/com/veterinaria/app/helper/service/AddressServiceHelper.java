package ar.com.veterinaria.app.helper.service;

import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.Address;
import ar.com.veterinaria.app.helper.service.contract.AddressContractServiceHelper;
import ar.com.veterinaria.app.validatorPattern.ValidatorPatternServiceHelper;

@Service
public class AddressServiceHelper implements AddressContractServiceHelper {

	@Override
	public boolean isValidName(Address address) {
		if (ValidatorPatternServiceHelper.getNamePattern().matcher(address.getName()).matches()) {
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

	@Override
	public boolean isValidNumber(Address address) {
		if (ValidatorPatternServiceHelper.getNumberPattern().matcher(address.getNumber().toString()).matches()) {
			return true;
		}
		return false;
	}
}

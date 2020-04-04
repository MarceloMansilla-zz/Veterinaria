package ar.com.veterinaria.app.entities.helper.service;

import org.springframework.stereotype.Service;

import ar.com.veterinaria.app.bo.validatorPattern.ValidatorPatternServiceHelper;
import ar.com.veterinaria.app.entities.Address;
import ar.com.veterinaria.app.entities.helper.service.contract.AddressContractServiceHelper;

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
	public boolean isValidLengthName(Address address) {
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

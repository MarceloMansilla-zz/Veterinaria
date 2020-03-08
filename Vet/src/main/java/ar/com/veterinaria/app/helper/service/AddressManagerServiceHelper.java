package ar.com.veterinaria.app.helper.service;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.veterinaria.app.entities.Address;
import ar.com.veterinaria.app.entities.Breed;
import ar.com.veterinaria.app.exception.invalidData.AddressInvalidDataException;
import ar.com.veterinaria.app.exception.invalidData.BreedInvalidDataException;
import ar.com.veterinaria.app.exception.validationLength.AddressValidationLengthDataException;
import ar.com.veterinaria.app.exception.validationLength.BreedValidationLengthDataException;

@Service
@Transactional
public class AddressManagerServiceHelper {

	@Autowired
	private static AddressServiceHelper addressServiceHelper;

	@Autowired
	public AddressManagerServiceHelper(AddressServiceHelper addressServiceHelper) {
		this.addressServiceHelper = addressServiceHelper;
	}

	public static boolean validate(Address address) {
		/*if (!addressServiceHelper.isValidName(address)) {
			throw new AddressInvalidDataException(address);

		} else if (!addressServiceHelper.isValidLengthname(address)) {
			throw new AddressValidationLengthDataException(address);
		}*/
		return true;
	}
}

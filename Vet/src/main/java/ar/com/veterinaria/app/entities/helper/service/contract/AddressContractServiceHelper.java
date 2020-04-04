package ar.com.veterinaria.app.entities.helper.service.contract;

import ar.com.veterinaria.app.entities.Address;

public interface AddressContractServiceHelper extends BaseContractServiceHelper<Address> {
	
	boolean isValidNumber(Address address);
}

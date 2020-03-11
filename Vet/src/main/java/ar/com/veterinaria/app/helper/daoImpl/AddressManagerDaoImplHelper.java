package ar.com.veterinaria.app.helper.daoImpl;

import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.Address;
import ar.com.veterinaria.app.exception.duplicate.AddressDuplicatedException;
import ar.com.veterinaria.app.exception.duplicate.AnimalDuplicatedException;
import ar.com.veterinaria.app.exception.notFound.AddressNotFoundException;
import ar.com.veterinaria.app.exception.notFound.BreedNotFoundException;
import ar.com.veterinaria.app.repository.AddressRepository;

@Service
@Transactional
public class AddressManagerDaoImplHelper {

	@Autowired
	private static AddressRepository addressRepository;

	@Autowired
	private static AddressDaoImplHelper addressDaoImplHelper;

	@Autowired
	public AddressManagerDaoImplHelper(AddressDaoImplHelper addressDaoImplHelper, AddressRepository addressRepository) {
		this.addressDaoImplHelper = addressDaoImplHelper;
		this.addressRepository = addressRepository;
	}

	public static boolean validate(Address address) {
		if (addressDaoImplHelper.isDuplicated(addressRepository, address)) {
			throw new AddressDuplicatedException(address.getName());
		}
		return false;
	}

	public static boolean existId(Integer id) {
		if (addressDaoImplHelper.existId(addressRepository, id)) {
			return true;
		}
		throw new AddressNotFoundException(id);

	}

	public static boolean isDeleted(Integer id) {
		if (addressDaoImplHelper.deleted(addressRepository, id)) {
			throw new AddressNotFoundException(id);
		}
		return false;
	}

	public static List<Map<String, Object>> findAll() {
		return addressDaoImplHelper.findAll(addressRepository);
	}

	public static Address findAddressByName(String address) {
		Address breed = addressDaoImplHelper.findByName(addressRepository, address);
		if (breed != null) {
			return breed;
		}
		throw new AddressNotFoundException(address);
	}

	public static Address updateAddress(Integer id, Address address) {
		if (!addressDaoImplHelper.deleted(addressRepository, id)) {
			Address aAddress = addressDaoImplHelper.update(addressRepository, id, address);
			aAddress.setId(id);
			aAddress.setName(address.getName());
			aAddress.setCity(address.getCity());
			aAddress.setDepartment(address.getDepartment());
			aAddress.setNumber(address.getNumber());
			aAddress.setZip(address.getZip());
			return aAddress;
		}
		throw new AddressNotFoundException(id);
	}

}

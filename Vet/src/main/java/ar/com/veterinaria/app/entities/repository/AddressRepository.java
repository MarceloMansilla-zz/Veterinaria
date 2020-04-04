package ar.com.veterinaria.app.entities.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.veterinaria.app.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

	Address findAddressById(Integer id);

	List<Address> findAll();

	@SuppressWarnings("unchecked")
	Address save(Address address);

	void delete(Address address);
}

package ar.com.veterinaria.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import ar.com.veterinaria.app.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

	Cliente findClienteById(Integer id);

	List<Cliente> findAll();

	@SuppressWarnings("unchecked")
	Cliente save(Cliente cliente);

	void delete(Cliente cliente);
}

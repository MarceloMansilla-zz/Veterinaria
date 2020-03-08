package ar.com.veterinaria.app.helper.daoImpl;

import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.Cliente;
import ar.com.veterinaria.app.exception.ClienteException;
import ar.com.veterinaria.app.exception.notFound.BreedNotFoundException;
import ar.com.veterinaria.app.exception.notFound.ClienteNotFoundException;
import ar.com.veterinaria.app.repository.ClienteRepository;

@Service
@Transactional
public class ClienteManagerDaoImplHelper {

	@Autowired
	private static ClienteRepository clienteRepository;

	@Autowired
	private static ClienteDaoImplHelper clienteDaoImplHelper;

	@Autowired
	public ClienteManagerDaoImplHelper(ClienteDaoImplHelper clienteDaoImplHelper, ClienteRepository clienteRepository) {
		this.clienteDaoImplHelper = clienteDaoImplHelper;
		this.clienteRepository = clienteRepository;
	}

	public static boolean validate(Cliente cliente) {
		if (clienteDaoImplHelper.isDuplicated(clienteRepository, cliente)) {
			throw new ClienteException(cliente.getName());
		}
		return false;
	}

	public static boolean existId(Integer id) {
		if (clienteDaoImplHelper.existId(clienteRepository, id)) {
			return true;
		}
		throw new ClienteNotFoundException(id);

	}

	public static boolean isDeleted(Integer id) {
		if (!clienteDaoImplHelper.deleted(clienteRepository, id)) {
			return false;
		}
		throw new ClienteNotFoundException(id);

	}

	public static List<Map<String, Object>> findAll() {
		return clienteDaoImplHelper.findAll(clienteRepository);
	}

	public static Cliente findClienteByName(String t) {
		Cliente cliente = clienteDaoImplHelper.findByName(clienteRepository, t);
		if (cliente != null) {
			return cliente;
		}
		throw new BreedNotFoundException(t);
	}

	public static Cliente updateCliente(Integer id, Cliente cliente) {
		Cliente cCliente = clienteDaoImplHelper.update(clienteRepository, id, cliente);
		// cCliente.setId(id);
		// cCliente.setClinicalHistory(cliente.getName());
		return cCliente;
	}

}

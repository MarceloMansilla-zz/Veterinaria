package ar.com.veterinaria.app.service;

import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.dao.ClienteDao;
import ar.com.veterinaria.app.entities.Cliente;
import ar.com.veterinaria.app.helper.service.ClienteManagerServiceHelper;
import ar.com.veterinaria.app.service.contract.ClienteContractService;

@Service
@Transactional
public class ClienteService implements ClienteContractService {

	@Autowired
	private ClienteDao cliente;

	public ClienteService() {
	}

	@Override
	public Cliente findById(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID cannot be 0 or < 0");
		}
		return cliente.findById(id);
	}

	@Override
	public void remove(int id) {
		if (id <= 0) {
			throw new IllegalArgumentException("ID cannot be 0 or < 0 or this id do not exist");
		}
		cliente.remove(id);
	}

	@Override
	public List<Map<String, Object>> findAll() {
		List<Map<String, Object>> result = cliente.findAll();
		if (result.size() > 0) {
			return result;
		}
		return null;
	}

	@Override
	public Cliente add(Cliente t) {
		if (t == null) {
			throw new IllegalArgumentException("The passed object cannot be null.");
		}
		return cliente.add(t);
	}

	@Override
	public Cliente update(int id, Cliente breed) {
		if (breed == null) {
			throw new IllegalArgumentException("The passed object cannot be null.");
		}
		if (id <= 0) {
			throw new IllegalArgumentException("ID cannot be 0 or < 0 or this id do not exist");
		}
		return cliente.update(id, breed);
	}

	@Override
	public boolean exist(Cliente client) {
		if (client == null) {
			throw new IllegalArgumentException("The passed object cannot be null.");
		}
		return cliente.exist(client);
	}

	@Override
	public boolean isValidInputData(Cliente Cliente) {
		if (ClienteManagerServiceHelper.validate(Cliente)) {
			return true;
		}
		return false;
	}

}

package ar.com.veterinaria.app.helper.daoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ar.com.veterinaria.app.entities.Cliente;
import ar.com.veterinaria.app.helper.daoImpl.contract.ClienteContractDaoImplHelper;

@Service
public class ClienteDaoImplHelper implements ClienteContractDaoImplHelper {

	private static final Logger logger = LoggerFactory.getLogger(ClienteDaoImplHelper.class);

	@Override
	public boolean isDuplicated(JpaRepository<Cliente, Integer> repository, Cliente cliente) {
		List<Cliente> result = repository.findAll();
		int ini = 0;
		while (ini < result.size()) {
			Cliente cCliente = result.get(ini);
			if (cCliente.getName().equals(cliente.getName())) {
				return true;
			}
			ini++;
		}
		return false;
	}

	@Override
	public boolean existId(JpaRepository<Cliente, Integer> repository, Integer id) {
		List<Cliente> result = repository.findAll();
		int ini = 0;
		while (ini < result.size()) {
			Cliente cCliente = result.get(ini);
			if (cCliente.getIdClient().equals(id)) {
				return true;
			}
			ini++;
		}
		return false;
	}

	@Override
	public boolean deleted(JpaRepository<Cliente, Integer> repository, Integer id) {
		List<Cliente> result = repository.findAll();
		int ini = 0;
		while (ini < result.size()) {
			Cliente cCliente = result.get(ini);
			if (cCliente.getIdClient().equals(id) && cCliente.isDeleted()) {
				return true;
			}
			ini++;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> findAll(JpaRepository<Cliente, Integer> repository) {
		try {
			List<Map<String, Object>> list = new ArrayList<>();
			Map<String, Object> map = new HashMap<>();
			List<Cliente> result = repository.findAll();
			for (Cliente cliente : result) {
				map = new HashMap<>();
				if (!cliente.isDeleted()) {
					map.put(cliente.getIdClient().toString(), cliente);
					list.add(map);
				}
			}
			return list;
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@Override
	public Cliente findByName(JpaRepository<Cliente, Integer> repository, String t) {
		List<Cliente> result = repository.findAll();
		int ini = 0;
		while (ini < result.size()) {
			Cliente cCliente = result.get(ini);
			if (cCliente.getName().equals(t)) {
				return cCliente;
			}
			ini++;
		}
		return null;
	}

	@Override
	public Cliente update(JpaRepository<Cliente, Integer> repository, Integer id, Cliente clinicalHistory) {
		List<Cliente> result = repository.findAll();
		int ini = 0;
		while (ini < result.size()) {
			Cliente cCliente = result.get(ini);
			if (cCliente.getIdPerson().equals(id)) {
				return cCliente;
			}
			ini++;
		}
		return null;
	}
}

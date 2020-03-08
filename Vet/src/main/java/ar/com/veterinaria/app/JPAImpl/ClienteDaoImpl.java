package ar.com.veterinaria.app.JPAImpl;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ar.com.veterinaria.app.dao.ClienteDao;
import ar.com.veterinaria.app.entities.Cliente;
import ar.com.veterinaria.app.exception.notFound.ClinicalHistoryNotFoundException;
import ar.com.veterinaria.app.helper.daoImpl.ClienteManagerDaoImplHelper;
import ar.com.veterinaria.app.helper.daoImpl.ClinicalHistoryManagerDaoImplHelper;
import ar.com.veterinaria.app.repository.ClienteRepository;

@Repository
public class ClienteDaoImpl implements ClienteDao {

	private static final Logger logger = LoggerFactory.getLogger(ClienteDaoImpl.class);

	@Autowired
	private ClienteRepository clienteRepository;

	public ClienteDaoImpl() {
		super();
	}

	@Override
	public Cliente findById(int id) {
		try {
			if (!ClienteManagerDaoImplHelper.isDeleted(id)) {
				return clienteRepository.findClienteById(id);
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		throw new ClinicalHistoryNotFoundException(id);
	}

	@Override
	public void remove(int id) {
		if (!ClienteManagerDaoImplHelper.isDeleted(id)) {
			Cliente cliente = clienteRepository.findClienteById(id);
			// cliente.setId(id);
			// cliente.setDeleted(true);
			clienteRepository.save(cliente);
		} // falta validar id
	}

	@Override
	public Cliente add(Cliente cliente) {
		try {
			clienteRepository.save(cliente);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return cliente;
	}

	@Override
	public Cliente update(int id, Cliente cliente) {
		if (ClienteManagerDaoImplHelper.existId(id)) {
			if (!ClienteManagerDaoImplHelper.isDeleted(id)) {
				clienteRepository.save(ClienteManagerDaoImplHelper.updateCliente(id, cliente));
				return cliente;
			}
		}
		return null;
	}

	@Override
	public List<Map<String, Object>> findAll() {
		return ClinicalHistoryManagerDaoImplHelper.findAll();
	}

	@Override
	public boolean exist(Cliente cliente) {
		if (!ClienteManagerDaoImplHelper.validate(cliente)) {
			return false;
		}
		return true;
	}

	@Override
	public Cliente findClienteByName(String cliente) {
		return ClienteManagerDaoImplHelper.findClienteByName(cliente);
	}

}

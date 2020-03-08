package ar.com.veterinaria.app.dao;

import ar.com.veterinaria.app.entities.Cliente;

public interface ClienteDao extends BaseDao<Cliente> {

	Cliente findClienteByName(String client);

}

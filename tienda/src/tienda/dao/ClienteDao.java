package tienda.dao;

import tienda.entities.Cliente;
import tienda.util.Conexion;

public class ClienteDao extends Conexion<Cliente> implements GenericDao<Cliente> {

	public ClienteDao() {
		super(Cliente.class);
	}
}


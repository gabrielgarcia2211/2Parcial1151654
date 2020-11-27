package tienda.dao;

import tienda.entities.Tienda;
import tienda.util.Conexion;

public class TiendaDao extends Conexion<Tienda> implements GenericDao<Tienda> {

	public TiendaDao() {
		super(Tienda.class);
	}
}

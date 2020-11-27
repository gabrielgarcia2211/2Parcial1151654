package tienda.dao;

import tienda.entities.Servicio;
import tienda.util.Conexion;

public class ServicioDao extends Conexion<Servicio> implements GenericDao<Servicio> {

	public ServicioDao() {
		super(Servicio.class);
	}
}


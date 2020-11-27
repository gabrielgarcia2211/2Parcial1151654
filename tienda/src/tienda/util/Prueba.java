package tienda.util;

import tienda.dao.ClienteDao;
import tienda.dao.ServicioDao;
import tienda.dao.TiendaDao;
import tienda.entities.Cliente;
import tienda.entities.Servicio;
import tienda.entities.Tienda;

public class Prueba {
	
	
	
	public static void main(String[] args) {
		
		//CREAR CLIENTE
		Cliente c = new Cliente();
		ClienteDao cDao = new ClienteDao();
		
		c.setId(0);
		c.setNombre("gabriel garcia");
		c.setEmail("gabrielgq@gmail.com");
		c.setClave("12345");
		
		cDao.insert(c);
		
		
		//CREAR TIENDA
		Tienda t = new Tienda();
		TiendaDao tDao = new TiendaDao();
		
		t.setId(0);
		t.setClave("12345");
		t.setDescripcion("nueva descripcion");
		t.setEmail("tienda@gmail.com");
		t.setFacebook("nuevo facebook");
		t.setImagen("imagen");
		t.setLema("lema");
		t.setNombre("nombre tienda");
		t.setPropietario("gabriel");
		t.setWeb("mi web");
		
		tDao.insert(t);
		
		
		//CREAR SERVICIO
		
		Servicio s = new Servicio();
		ServicioDao sDao = new ServicioDao();
		
		Tienda tiendaBean = tDao.find(1);
		
		s.setId(0);
		s.setDescripcion("nueva descripcion");
		s.setNombre("servicio");
		s.setTiendaBean(tiendaBean);
		
		sDao.insert(s);
		
		
		
		//SEGUIR LA TIENDA POR UN SERVICIO
		
		
		
		
		
		
		//ACTUALIZAR UNA TIENDA
		
		TiendaDao tDao2 = new TiendaDao();
		
		Tienda t2 = tDao2.find(1);
		
		t2.setClave("12345");
		t2.setDescripcion("nueva descripcion");
		t2.setEmail("tienda@gmail.com");
		t2.setFacebook("nuevo facebook");
		t2.setImagen("imagen");
		t2.setLema("lema");
		t2.setNombre("nombre tienda");
		t2.setPropietario("gabriel");
		t2.setWeb("mi web");
		
		tDao2.update(t2);
		

		
		
		
	}
}

package tienda.util;

import tienda.dao.ClienteDao;
import tienda.entities.Cliente;

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
		
		
		//CREAR SERVICIO
		
		
		
		//SEGUIR LA TIENDA POR UN SERVICIO

		
		
		
	}
}

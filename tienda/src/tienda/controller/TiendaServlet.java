package tienda.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import tienda.dao.ClienteDao;
import tienda.dao.ServicioDao;
import tienda.dao.TiendaDao;
import tienda.entities.Cliente;
import tienda.entities.Servicio;
import tienda.entities.Tienda;

/**
 * Servlet implementation class TiendaServlet
 */
@WebServlet("/TiendaServlet")
public class TiendaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TiendaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro=request.getParameter("parametro");
		
		if (parametro.equals("login")) {
			
			response.sendRedirect("login.jsp");
			
		} else 
			if (parametro.equals("registro")) {
				
				response.sendRedirect("registro.jsp");
				
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String parametro=request.getParameter("parametro");
		
		if (parametro.equals("registrarUsuario")) {
			
			String inputNombre = request.getParameter("inputNombre");  
			String inputLema = request.getParameter("inputLema");
			String inputDescripcion = request.getParameter("inputDescripcion");
			String inputEmail = request.getParameter("inputEmail");
			String inputPassword = request.getParameter("inputPassword");
			String inputPropietario = request.getParameter("inputPropietario");
			String inputFacebook = request.getParameter("inputFacebook");
			String inputWeb = request.getParameter("inputWeb");
			String inputImagen = request.getParameter("inputImagen");
			
			Tienda t = new Tienda();
			TiendaDao tDao = new TiendaDao();
			
			
			Tienda tienda = tDao.findByField("email", inputEmail);
			
			if(tienda!=null) {
				request.setAttribute("resultado", 0);

		        request.getRequestDispatcher("registro.jsp").forward(request, response);
			}else {
					
				t.setId(0);
				t.setClave(inputPassword);
				t.setDescripcion(inputDescripcion);
				t.setEmail(inputEmail);
				t.setFacebook(inputFacebook);
				t.setImagen(inputImagen);
				t.setLema(inputLema);
				t.setNombre(inputNombre);
				t.setPropietario(inputPropietario);
				t.setWeb(inputWeb);
				
				tDao.insert(t);
				
				
				
				response.sendRedirect("index.jsp");
			}
			
				
		}if (parametro.equals("loginUsuario")) {
			
			String inputEmail = request.getParameter("inputEmail");  
			String inputPassword = request.getParameter("inputPassword");
			
			
			TiendaDao tDao = new TiendaDao();
			ClienteDao cDao = new ClienteDao();
			
		
			Tienda tienda = tDao.findByField("email", inputEmail);
			Cliente cliente = cDao.findByField("email", inputEmail);
			
			
			if(tienda!=null) {
				if(tienda.getClave().equals(inputPassword)){
					List<Servicio> s =  new ArrayList<Servicio>();
					ServicioDao server = new ServicioDao();
					
					s = server.findByFieldList("id", tienda.getId());
					
					request.setAttribute("data", s);
					request.getRequestDispatcher("servicio.jsp").forward(request, response);
				}
			}
			
		    if(cliente!=null) {
				if(cliente.getClave().equals(inputPassword)){
					
					List<Servicio> s =  new ArrayList<Servicio>();
					ServicioDao server = new ServicioDao();
					
					s = server.list();
					
					request.setAttribute("data", s);
					request.getRequestDispatcher("servicio.jsp").forward(request, response);
				
				}
			}
			
			request.setAttribute("resultado", 0);

	        request.getRequestDispatcher("login.jsp").forward(request, response);
			
			
			
		}
	}

}










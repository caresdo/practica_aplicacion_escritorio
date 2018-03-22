package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ClientesDAO;
import daosImpl.ClientesDAOImpl;
import modelo.Cliente;

@WebServlet("/ServletGuardarCambioCliente")
public class ServletGuardarCambioCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("titulo");
		String calle = request.getParameter("calle");
		String numeracion = request.getParameter("numeracion");
		String codigoPostal = request.getParameter("codigoPostal");
		String poblacion = request.getParameter("poblacion");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String particularOEmpresa = request.getParameter("particularOEmpresa");
		String id = request.getParameter("campoId");
		
		//deberiamos validar todos los datos
		//TODO
		//fin validacion
		
		Cliente cliente = new Cliente(nombre,  calle,  numeracion, codigoPostal,  poblacion,  telefono, email,  particularOEmpresa);
		System.out.println("ServletGuardarCambio"+cliente.toString());
		cliente.setId(Integer.parseInt(id));
		ClientesDAO clientesDAO = new ClientesDAOImpl();
		clientesDAO.guardarCambiosCliente(cliente);
		
		request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
		
	}

}

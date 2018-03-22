package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ClientesDAO;
import daosImpl.ClientesDAOImpl;

@WebServlet("/ServletBorrarCliente")
public class ServletBorrarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("cliente de id: "+ id);
		ClientesDAO clienteDAO = new ClientesDAOImpl();
		clienteDAO.borrarCliente(id);
		request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
		
		
	}

}

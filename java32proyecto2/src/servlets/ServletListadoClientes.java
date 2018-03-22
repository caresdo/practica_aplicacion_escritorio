package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ClientesDAO;
import daosImpl.ClientesDAOImpl;

@WebServlet("/ServletListadoClientes")
public class ServletListadoClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClientesDAO daoCliente = new ClientesDAOImpl();
		
		request.setAttribute("clientes", daoCliente.obtenerClientes());
		
		request.getRequestDispatcher("listadoClientes.jsp").forward(request,response);
		
		
	}//end doget
}//end class

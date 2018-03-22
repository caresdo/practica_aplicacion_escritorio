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

@WebServlet("/ServletEditarCliente")
public class ServletEditarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ClientesDAO clientesDAO = new ClientesDAOImpl();
		Cliente clienteEditar = clientesDAO.obtenerClientePorId(id);
		request.setAttribute("clienteEditar", clienteEditar);
		request.getRequestDispatcher("editarCliente.jsp").forward(request, response);
	}

}

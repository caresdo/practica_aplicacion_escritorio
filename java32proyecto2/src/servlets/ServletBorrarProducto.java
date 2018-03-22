package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ProductosDAO;
import daosImpl.ProductosDAOImpl;

@WebServlet("/ServletBorrarProducto")
public class ServletBorrarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("producto de id: "+ id);
		ProductosDAO productoDAO = new ProductosDAOImpl();
		productoDAO.borrarProducto(id);
		request.getRequestDispatcher("ServletListadoProductos").forward(request, response);
		
		
	}

}

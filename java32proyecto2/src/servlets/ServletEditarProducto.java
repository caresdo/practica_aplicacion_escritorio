package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ProductosDAO;
import daosImpl.ProductosDAOImpl;
import modelo.Producto;

@WebServlet("/ServletEditarProducto")
public class ServletEditarProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		ProductosDAO productosDAO = new ProductosDAOImpl();
		Producto productoEditar = productosDAO.obtenerProductoPorId(id);
		request.setAttribute("productoEditar", productoEditar);
		request.getRequestDispatcher("editarProducto.jsp").forward(request, response);
	}

}

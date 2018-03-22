package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ProductosDAO;
import daosImpl.ProductosDAOImpl;

@WebServlet("/ServletListadoProductos")
public class ServletListadoProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductosDAO daoProducto = new ProductosDAOImpl();
		
		request.setAttribute("productos", daoProducto.obtenerProductos());
		
		request.getRequestDispatcher("listadoProductos.jsp").forward(request,response);
		
		
	}//end doget
}//end class

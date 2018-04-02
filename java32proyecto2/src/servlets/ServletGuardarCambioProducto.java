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

@WebServlet("/ServletGuardarCambioProducto")
public class ServletGuardarCambioProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String cantidad = request.getParameter("cantidad");
		String precio = request.getParameter("precio");
		String oferta = request.getParameter("oferta");
		String fechaCad = request.getParameter("fechaCad");
		String proveedor = request.getParameter("proveedor");
		String comentario = request.getParameter("comentario");
		String id = request.getParameter("id");
		
		//deberiamos validar todos los datos
		//TODO
		//fin validacion
		
		Producto producto = new Producto(nombre,  cantidad,  precio, oferta,  fechaCad,  proveedor, comentario);
		System.out.println("ServletGuardarCambio"+producto.toString());
		producto.setId(Integer.parseInt(id));
		ProductosDAO productosDAO = new ProductosDAOImpl();
		productosDAO.guardarCambiosProducto(producto);
		
		request.getRequestDispatcher("ServletListadoProductos").forward(request, response);
		
	}

}

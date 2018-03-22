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

@WebServlet("/ServletRegistroProducto")
public class ServletRegistroProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("identificado")==null){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		System.out.println("se ejecuta el post del servlet registro producto");
		// recoger datos del formulario
		String nombre = request.getParameter("nombre");
		String cantidad = request.getParameter("cantidad");
		String precio = request.getParameter("precio");
		String oferta = request.getParameter("oferta");
		String fechaCad = request.getParameter("fechaCad");
		String proveedor = request.getParameter("proveedor");
		String comentario = request.getParameter("comentario");
		/* validacion de datos
			String expresionRegularTitulo="[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]{3,10}";
			Pattern pattern = Pattern.compile(expresionRegularTitulo);
			Matcher matcher = pattern.matcher(titulo);
			if (matcher.matches()){
				System.out.println("titulo ok");
			}	else{
				System.out.println("titulo no valido");
				request.setAttribute("mensaje", "titulo no valido");
				request.getRequestDispatcher("registroProductos.jsp").forward(request, response);
				
			}
			
		 fin de la validacion*/
		Producto nuevoProducto = new Producto(nombre, cantidad, precio, oferta, fechaCad, proveedor, comentario);
		System.out.println("vamos a registrar" + nuevoProducto.toString());
		ProductosDAO productosDAO = new ProductosDAOImpl();
		productosDAO.registrarProducto(nuevoProducto);
		// desde un servlet no deberia mostrar nada al usuario para eso estan
		// las jsp que son las encargadas de realizar la vista de la aplicacion
		
		//el server continua la ejecucion en esta jsp
		request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
		
	}

}

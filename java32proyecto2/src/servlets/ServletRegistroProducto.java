package servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		String precio = request.getParameter("precio").replace(",", ".");
		String oferta = request.getParameter("oferta").replace(",", ".");
		String fechaCad = request.getParameter("fechaCad");
		String proveedor = request.getParameter("proveedor");
		String comentario = request.getParameter("comentario");
		
			int a = 0;
			String expresionRegularTexto="[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]{3,10}";
			String expresionRegularComentario="[0-9a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]{0,100}";
			String expresionRegularNumero="[0-9]{1,11}";
			String expresionRegularPrecio="\\d+(.\\d+)?";
			String expresionRegularFecha="\\d{2}-\\d{2}-\\d{4}";
			
			Pattern patternTexto = Pattern.compile(expresionRegularTexto);
			Matcher matcherNombre = patternTexto.matcher(nombre);
			if (matcherNombre.matches()){}	else{
				System.out.println("nombre no valido");
				request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
				a=1;				
			}
			Matcher matcherProveedor = patternTexto.matcher(proveedor);
			if (matcherProveedor.matches()){}	else{
				System.out.println("proveedor no valido");
				request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
				a=1;				
			}
			
			Pattern patternNumero = Pattern.compile(expresionRegularNumero);
			Matcher matcherCantidad = patternNumero.matcher(cantidad);
			if (matcherCantidad.matches()){}	else{
				System.out.println("cantidad no valido");
				request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
				a=1;				
			}
			
			Pattern patternPrecio = Pattern.compile(expresionRegularPrecio);
			Matcher matcherPrecio = patternPrecio.matcher(precio);
			if (matcherPrecio.matches()){}	else{
				System.out.println("precio no valido");
				request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
				a=1;				
			}
			Matcher matcherOferta = patternPrecio.matcher(oferta);
			if (matcherOferta.matches()){}	else{
				System.out.println("oferta no valido");
				request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
				a=1;				
			}
			
			Pattern patternFecha = Pattern.compile(expresionRegularFecha);
			Matcher matcherFechaCad = patternFecha.matcher(fechaCad);
			if (matcherFechaCad.matches()){}	else{
				System.out.println("fecha caducidad no valido");
				request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
				a=1;				
			}
			
			Pattern patternComentario = Pattern.compile(expresionRegularComentario);
			Matcher matcherComentario = patternComentario.matcher(comentario);
			if (matcherComentario.matches()){}	else{
				System.out.println("comentario no valido");
				request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
				a=1;				
			}
			
			
			if (a==0){
				Producto nuevoProducto = new Producto(nombre, cantidad, precio, oferta, fechaCad, proveedor, comentario);
				System.out.println("vamos a registrar" + nuevoProducto.toString());
				ProductosDAO productosDAO = new ProductosDAOImpl();
				productosDAO.registrarProducto(nuevoProducto);
				request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("registrarProducto.jsp").forward(request, response);
			}
		
	}

}

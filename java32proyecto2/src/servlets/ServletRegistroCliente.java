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

@WebServlet("/ServletRegistroCliente")
public class ServletRegistroCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("identificado")==null){
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
		System.out.println("se ejecuta el post del servlet registro cliente");
		// recoger datos del formulario
		String nombre = request.getParameter("nombre");
		String calle = request.getParameter("calle");
		String numeracion = request.getParameter("numeracion");
		String codigoPostal = request.getParameter("codigoPostal");
		String poblacion = request.getParameter("poblacion");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String particularOEmpresa = request.getParameter("particularOEmpresa");
		/* validacion de datos
			String expresionRegularTitulo="[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]{3,10}";
			Pattern pattern = Pattern.compile(expresionRegularTitulo);
			Matcher matcher = pattern.matcher(titulo);
			if (matcher.matches()){
				System.out.println("titulo ok");
			}	else{
				System.out.println("titulo no valido");
				request.setAttribute("mensaje", "titulo no valido");
				request.getRequestDispatcher("registroClientes.jsp").forward(request, response);
				
			}
			
		 fin de la validacion*/
		Cliente nuevoCliente = new Cliente(nombre,calle,numeracion,codigoPostal,poblacion,telefono,email,particularOEmpresa);
		System.out.println("vamos a registrar" + nuevoCliente.toString());
		ClientesDAO clientesDAO = new ClientesDAOImpl();
		clientesDAO.registrarCliente(nuevoCliente);
		// desde un servlet no deberia mostrar nada al usuario para eso estan
		// las jsp que son las encargadas de realizar la vista de la aplicacion
		
		//el server continua la ejecucion en esta jsp
		request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
		
	}

}

package servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		// validacion de datos
			String expresionRegularTexto="[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]{3,10}";
			String expresionRegularTodo="[0-9a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]{3,20}";
			String expresionRegularNumero="[0-9]{1,11}";
			String expresionRegularEmail="[^@]+@[^@]+\\.[a-zA-Z]{2,}";
			int a=0;
			
			Pattern pattern = Pattern.compile(expresionRegularTexto);
			Matcher matcher = pattern.matcher(nombre);
			if (matcher.matches()){}	else{
				System.out.println("error nombre");
				//request.setAttribute("mensaje", "nombre no valido");
				request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
				a=1;
			}
			Matcher matcherParticularEmpresa = pattern.matcher(particularOEmpresa);
			if (matcherParticularEmpresa.matches()){}	else{
				System.out.println("error particular o empresa");
				request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
				a=1;
			}
			
			Pattern patternTodo = Pattern.compile(expresionRegularTodo);
			Matcher matcherCalle = patternTodo.matcher(calle);
			if (matcherCalle.matches()){}	else{
				System.out.println("error calle");
				request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
				a=1;
			}
			Matcher matcherPoblacion = patternTodo.matcher(poblacion);
			if (matcherPoblacion.matches()){}	else{
				System.out.println("error poblacion");
				request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
				a=1;
			}
			
			Pattern patternNum = Pattern.compile(expresionRegularNumero);
			Matcher matcherNumeracion = patternNum.matcher(numeracion);
			if (matcherNumeracion.matches()){}	else{
				System.out.println("error numeracion");
				request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
				a=1;
			}
			Matcher matcherCodigoPostal = patternNum.matcher(codigoPostal);
			if (matcherCodigoPostal.matches()){}	else{
				System.out.println("error codigo postal");
				request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
				a=1;
			}
			Matcher matcherTelefono = patternNum.matcher(telefono);
			if (matcherTelefono.matches()){}	else{
				System.out.println("error telefono");
				request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
				a=1;
			}
			
			Pattern patternEmail = Pattern.compile(expresionRegularEmail);
			Matcher matcherEmail = patternEmail.matcher(email);
			if (matcherEmail.matches()){}	else{
				System.out.println("error email");
				request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
				a=1;
			}
			
			if (a==0){
				Cliente nuevoCliente = new Cliente(nombre,calle,numeracion,codigoPostal,poblacion,telefono,email,particularOEmpresa);
				System.out.println("vamos a registrar" + nuevoCliente.toString());
				ClientesDAO clientesDAO = new ClientesDAOImpl();
				clientesDAO.registrarCliente(nuevoCliente);
				request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
			}
		// fin de la validacion

		// desde un servlet no deberia mostrar nada al usuario para eso estan
		// las jsp que son las encargadas de realizar la vista de la aplicacion
		
		//el server continua la ejecucion en esta jsp
		
		
	}

}

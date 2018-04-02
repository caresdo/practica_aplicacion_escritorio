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

@WebServlet("/ServletGuardarCambioCliente")
public class ServletGuardarCambioCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre = request.getParameter("nombre");
		String calle = request.getParameter("calle");
		String numeracion = request.getParameter("numeracion");
		String codigoPostal = request.getParameter("codigoPostal");
		String poblacion = request.getParameter("poblacion");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String particularOEmpresa = request.getParameter("particularOEmpresa");
		String id = request.getParameter("id");
		
		//deberiamos validar todos los datos
		String expresionRegularTexto="[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]{3,10}";
		String expresionRegularTodo="[0-9a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—\\s]{3,20}";
		String expresionRegularNumero="[0-9]{1,11}";
		String expresionRegularEmail="[^@]+@[^@]+\\.[a-zA-Z]{2,}";
		int a=0;
		
		Pattern pattern = Pattern.compile(expresionRegularTexto);
		Matcher matcher = pattern.matcher(nombre);
		if (matcher.matches()){}	else{
			System.out.println("error nombre");
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
			a=1;
		}
		Matcher matcherParticularEmpresa = pattern.matcher(particularOEmpresa);
		if (matcherParticularEmpresa.matches()){}	else{
			System.out.println("error particular o empresa");
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
			a=1;
		}
		
		Pattern patternTodo = Pattern.compile(expresionRegularTodo);
		Matcher matcherCalle = patternTodo.matcher(calle);
		if (matcherCalle.matches()){}	else{
			System.out.println("error calle");
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
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
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
			a=1;
		}
		Matcher matcherCodigoPostal = patternNum.matcher(codigoPostal);
		if (matcherCodigoPostal.matches()){}	else{
			System.out.println("error codigo postal");
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
			a=1;
		}
		Matcher matcherTelefono = patternNum.matcher(telefono);
		if (matcherTelefono.matches()){}	else{
			System.out.println("error telefono");
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
			a=1;
		}
		
		Pattern patternEmail = Pattern.compile(expresionRegularEmail);
		Matcher matcherEmail = patternEmail.matcher(email);
		if (matcherEmail.matches()){}	else{
			System.out.println("error email");
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
			a=1;
		}
		
		if (a==0){
			Cliente cliente = new Cliente(nombre,  calle,  numeracion, codigoPostal,  poblacion,  telefono, email,  particularOEmpresa);
			System.out.println("ServletGuardarCambio"+cliente.toString());
			cliente.setId(Integer.parseInt(id));
			ClientesDAO clientesDAO = new ClientesDAOImpl();
			clientesDAO.guardarCambiosCliente(cliente);
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
			
		}else {
			request.getRequestDispatcher("ServletListadoClientes").forward(request, response);
		}
		//fin validacion
		
		
	}

}

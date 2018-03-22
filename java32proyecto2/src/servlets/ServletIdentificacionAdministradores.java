package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.AdministradoresDAO;
import daosImpl.AdministradoresDAOImpl;

@WebServlet("/ServletIdentificacionAdministradores")
public class ServletIdentificacionAdministradores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("campoLogin");
		String pass = request.getParameter("campoPass");
		AdministradoresDAO administradorsDAO =new AdministradoresDAOImpl();
		if(administradorsDAO.identificarAdministrador(login, pass)){
			//administrador identificado correctamente
			request.getSession().setAttribute("identificado", "ok");
			request.getRequestDispatcher("principal.jsp").forward(request, response);
		}else{
			//email o pass incorrecto
			request.setAttribute("mensaje", "email o pass incorrecto");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}//end else
	}//end service

}//end class

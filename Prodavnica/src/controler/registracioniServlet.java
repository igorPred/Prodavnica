package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import buissnesServices.MetodeRegistracija;

/**
 * Servlet implementation class registracioniServlet
 */
@WebServlet(description = "Ovo je servlet za registraciju", urlPatterns = { "/registracioniServlet" })
public class registracioniServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String userName =request.getParameter("userName");
	String password =request.getParameter("password");
	
	MetodeRegistracija metode =new MetodeRegistracija ();
	if (metode.ubaciUsera(userName, password)) {
		response.sendRedirect("index.html");
	}else {
		response.sendRedirect("registracija.html");

	}
		
	}

}

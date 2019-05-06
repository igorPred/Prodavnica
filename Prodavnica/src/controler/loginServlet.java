package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import buissnesServices.LoginMetode;
import model.Admin;
import model.User;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet(description = "login", urlPatterns = { "/loginServlet" })
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName =request.getParameter("userName");
		String password =request.getParameter("password");
		
		
		LoginMetode metode =new LoginMetode ();

		if (metode.daLiPostojiUser(userName)) {
			//proveri password 
			
	if (metode.daLiJeDobarPassowrd(userName, password)){
			User user =metode.vratiUsera(userName, password);
		    if (user !=null) {
		    	
		    	HttpSession sesija = request.getSession();
		    	sesija.setAttribute("ovdeCuvamUsera", user);
		    	
		    	Admin admin =new Admin ();
		    	
		    	if (userName.equals(admin.getAdminUserName()) && password.equals(admin.getAdminPassword())) {
		    		response.sendRedirect("jsp/admin.jsp");
		    	}else {
		    		response.sendRedirect("jsp/user.jsp");
		    	}
		    	
		    	
		    	
		    }else {
		    	response.sendRedirect("loginError.html");
		    }
		
		
			}else {
				response.sendRedirect("loginError.html");
			}
			
			
			
		}else {
			response.sendRedirect("loginEror.html");
		}
	}

}

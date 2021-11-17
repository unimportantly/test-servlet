package servlets;

import java.io.IOException;

import org.apache.tomcat.jakartaee.bcel.Const;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

@WebServlet("/compte")
public class Compte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//get a session to track
		HttpSession session = req.getSession();
		
		//get the user back from the constant
		User user = (User) session.getAttribute(Const.STATIC_INITIALIZER_NAME);
		
		//get the different attributes from the user object
		session.setAttribute("nom", user);
		session.setAttribute("article", user);
		session.setAttribute("email", user);
		session.setAttribute("role", user);

		//forwards the request to the compte.jsp page
		req.getRequestDispatcher("/WEB-INF/compte.jsp").forward(req, resp);
		
		//checks if there is a user logged in, otherwise redirects to the home page
		if( user == null ) {
		resp.sendRedirect(this.getServletContext().getContextPath()+ "/testServlet/accueil"); 
		}
	}
	
}
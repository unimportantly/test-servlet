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

@WebServlet("/index")
public class Accueil extends HttpServlet {
	
	/**
	 * empty constructor
	 * @throws ServletException
	 */
	public Accueil() throws ServletException{
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		 * //get a session to track HttpSession session = req.getSession(); //create a
		 * user object User user = new User("jean", "jean@caramail.fr", 6, "regular");
		 * //store the user with a constant to be able to access it later
		 * session.setAttribute(Const.STATIC_INITIALIZER_NAME, user);
		 * 
		 * //forwards the request to the index.jsp page
		 */		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	}
}
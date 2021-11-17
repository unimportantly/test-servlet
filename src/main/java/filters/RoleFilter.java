package filters;

import java.io.IOException;

import org.apache.tomcat.jakartaee.bcel.Const;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;

@WebFilter("/admin")
public class RoleFilter implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		//get the req & resp as http objects
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		//récupère la session
		HttpSession session = request.getSession();
		
		//récupère l'user
		User user = (User) session.getAttribute(Const.STATIC_INITIALIZER_NAME);
		
		//check if user is admin
		if (user.getRole().equals("admin")) {
			//let user through
			chain.doFilter(request, response);
		}
		//send user back to home page
		else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/index");
			dispatcher.include(request, response);
		}
	}

}

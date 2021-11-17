package servlets;

import java.io.IOException;

import org.apache.tomcat.jakartaee.bcel.Const;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Article;
import models.User;

@WebServlet("/article1")
public class Article1 extends HttpServlet {

	public Article1() {
	}

	/**
	 * links to the appropriate .jsp page
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// grab the session
		HttpSession session = req.getSession();

		// recreates the article1 object from the request
		Article article1 = (Article) session.getAttribute("article1");
		//System.out.println(article1.getAuthor());
		  //set the attributes from the object
		  session.setAttribute("titre", article1.getTitle());
		 // session.setAttribute("auteur", article1.getAuthor().getName());
		  session.setAttribute("texte", article1.getText());
		 

		req.getRequestDispatcher("/WEB-INF/article1.jsp").forward(req, resp);
	}
}

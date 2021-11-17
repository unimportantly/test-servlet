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

@WebServlet("/articles")
public class Articles extends HttpServlet{

	public Articles() {
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//get a session to track
		HttpSession session = req.getSession();
				
		//get the user back from the constant
		User user = (User) session.getAttribute(Const.STATIC_INITIALIZER_NAME);
		
		Article article1 = new Article("Title1", user, "text");
		Article article2 = new Article("Title2", user, "text");
		Article article3 = new Article("Title3", user, "text");
		Article article4 = new Article("Title4", user, "text");
		Article article5 = new Article("Title5", user, "text");
		Article article6 = new Article("Title6", user, "text");
		
		//TODO can't access the author's name
		session.setAttribute("titre", article1.getTitle());
		session.setAttribute("auteur", article1.getAuthor().getName());
		session.setAttribute("texte", article1.getText());
		session.setAttribute("titre", article2.getTitle());
		session.setAttribute("auteur", article2.getAuthor().getName());
		session.setAttribute("texte", article2.getText());
		session.setAttribute("titre", article3.getTitle());
		session.setAttribute("auteur", article3.getAuthor().getName());
		session.setAttribute("texte", article3.getText());
		session.setAttribute("titre", article4.getTitle());
		session.setAttribute("auteur", article4.getAuthor().getName());
		session.setAttribute("texte", article4.getText());
		session.setAttribute("titre", article5.getTitle());
		session.setAttribute("auteur", article5.getAuthor().getName());
		session.setAttribute("texte", article5.getText());
		session.setAttribute("titre", article6.getTitle());
		session.setAttribute("auteur", article6.getAuthor().getName());
		session.setAttribute("texte", article6.getText());

		req.getRequestDispatcher("/WEB-INF/articles.jsp").forward(req, resp);
	}
}

package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		/*
		User user = (User) session.getAttribute(Const.STATIC_INITIALIZER_NAME);
		
		
		System.out.println(user.toString());
		Article article1 = new Article("Title1", user, "text");
		session.setAttribute("article1", article1);
		Article article2 = new Article("Title2", user, "text");
		session.setAttribute("article2", article2);
		Article article3 = new Article("Title3", user, "text");
		session.setAttribute("article3", article3);
		Article article4 = new Article("Title4", user, "text");
		session.setAttribute("article4", article4);
		Article article5 = new Article("Title5", user, "text");
		session.setAttribute("article5", article5);
		Article article6 = new Article("Title6", user, "text");
		session.setAttribute("article6", article6);
		
		//TODO can't access the author's name
		*/
		
		List<User> users = new ArrayList<User>();
		List<Article> articles = new ArrayList<Article>();
		for (int i = 1; i <= 4; i++) {
			String name = "user" + i;
			String email = "user" + i + "@email.com";
			int nbrPost = i; 
			String role; 
			if (i % 2 == 0) {
				role = "admin";
			} else {
				role = "user";
			}
			users.add(new User(name, email, nbrPost, role));
			for (int j = 0; j < nbrPost; j++) {
				String titre = "titre" + j;
				User auteur = users.get(i-1);
				String texte = "texte" + j;
				articles.add(new Article(titre, auteur, texte));
			}

		}
		
		

		req.getRequestDispatcher("/WEB-INF/articles.jsp").forward(req, resp);
	}
}

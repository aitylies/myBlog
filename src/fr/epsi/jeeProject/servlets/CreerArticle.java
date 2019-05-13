package fr.epsi.jeeProject.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.jeeProject.beans.Blog;
import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.IBlogDao;
import fr.epsi.jeeProject.dao.IUtilisateurDao;
import fr.epsi.jeeProject.dao.HSQLImpl.BlogDao;
import fr.epsi.jeeProject.dao.HSQLImpl.UtilisateurDao;

/**
 * Servlet implementation class CreerArticle
 */
@WebServlet("/CreerArticle")
public class CreerArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerArticle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("creerArticle.jsp").forward(request, response);			

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		// Récupération des params
		String titre = request.getParameter("cTitre");
		String email = request.getParameter("cEmail"); 
		String content = request.getParameter("cMessage"); 
        System.out.println("ICI ------>"+email);
		
		// Création d'un article
		IBlogDao blogDao = new BlogDao();
		Blog article = new Blog(); 
		IUtilisateurDao userDao = new UtilisateurDao();
		Utilisateur userBean = new Utilisateur(); 
		userBean.setEmail(email);
		
			
			
		article.setTitre(titre);
		article.setCreateur(userBean);
		article.setDescription(content);
		
		try {
			blogDao.createBlog(article);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		request.setAttribute("Creation", "Votre article a bien ete enregistree");
		request.getRequestDispatcher("creerArticle.jsp").forward(request, response);			

	}

}

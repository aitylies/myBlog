package fr.epsi.jeeProject.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

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
 * Servlet implementation class Dashboard
 */
@WebServlet("/Dashboard")
public class Dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		//IUtilisateurDao userDao = new UtilisateurDao();
		Utilisateur userBean = new Utilisateur() ;
		userBean.setEmail("aitylies@hotmail.fr");
		
		IBlogDao blogDao = new BlogDao(); 
		Blog bl = new Blog(); 

		request.setAttribute("Article", blogDao.getBlogs(userBean));
		//System.out.println("ICIIIIII"+blogDao.getBlogs(userBean).get(0));
		request.getRequestDispatcher("accueil.jsp").forward(request, response);
		//		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
		
		
		
		
		
		
	}

}

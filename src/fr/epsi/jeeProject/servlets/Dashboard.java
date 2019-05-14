package fr.epsi.jeeProject.servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
		
		List<Blog> maListe = new ArrayList<Blog>(); 
		
		
		IBlogDao blogDao = new BlogDao(); 
		Blog bl = new Blog(); 

		try {
			maListe = blogDao.getAllBlogs();
			//System.out.println("Iciiii -----> "+maListe.get(0).getTitre().toString());
			System.out.println("TAILLE DE LA LISTE"+maListe.size());
			request.setAttribute("ListeBlog", maListe);

			for(int i=0; i<=maListe.size()-1; i++)
			{
				System.out.println("Iciiii1 -----> "+maListe.get(i).getTitre().toString());
				System.out.println("Iciiii2 -----> "+maListe.get(i).getDateCreation().toString());
				System.out.println("Iciiii3 -----> "+maListe.get(i).getDescription().toString());
				//System.out.println("Iciiii4 -----> "+maListe.get(i).getCreateur().toString());
				
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 
		
		
		try {
			request.setAttribute("Article", blogDao.getBlogs(userBean));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println("ICIIIIII"+blogDao.getBlogs(userBean).get(0));
		request.getRequestDispatcher("accueil.jsp").forward(request, response);
		//		request.getRequestDispatcher("index.jsp").forward(request, response);
		
		
		
		
		
		
		
		
		
	}

}

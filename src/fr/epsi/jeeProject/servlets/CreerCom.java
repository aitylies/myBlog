package fr.epsi.jeeProject.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epsi.jeeProject.beans.Blog;
import fr.epsi.jeeProject.beans.Reponse;
import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.IBlogCommentaireDao;
import fr.epsi.jeeProject.dao.IUtilisateurDao;
import fr.epsi.jeeProject.dao.HSQLImpl.BlogCommentaireDao;
import fr.epsi.jeeProject.dao.HSQLImpl.BlogDao;
import fr.epsi.jeeProject.dao.HSQLImpl.UtilisateurDao;

/**
 * Servlet implementation class CreerCom
 */
@WebServlet("/CreerCom")
public class CreerCom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreerCom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Récupération des params
				Integer id = Integer.valueOf(request.getParameter("cId"));
				String name = request.getParameter("cName");
				String email = request.getParameter("cEmail"); 
				String content = request.getParameter("cMessage"); 
				
				// Création d'un commentaire
				IBlogCommentaireDao blogCommentaireDao = new BlogCommentaireDao();
				Reponse com = new Reponse(); 
				IUtilisateurDao userDao = new UtilisateurDao();
			
				// create a java calendar instance
				Calendar calendar = Calendar.getInstance();

				// get a java date (java.util.Date) from the Calendar instance.
				// this java date will represent the current date, or "now".
				java.util.Date currentDate = calendar.getTime();

				// now, create a java.sql.Date from the java.util.Date
				java.sql.Date date = new java.sql.Date(currentDate.getTime());


				Utilisateur userBean = new Utilisateur(); 
				Blog blogBean = new Blog();
				userBean.setEmail(email);
				blogBean.setId(id);
				
					
				com.setBlog(blogBean);
				com.setCommentaire(content);
				com.setBlogger(userBean);
				com.setPublication(date);
				
				try {
					blogCommentaireDao.createReponse(com);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
				request.setAttribute("Creation", "Votre article a bien ete enregistree");
				request.getRequestDispatcher("article.jsp").forward(request, response);		
	}

}

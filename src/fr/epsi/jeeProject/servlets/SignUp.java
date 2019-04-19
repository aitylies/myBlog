package fr.epsi.jeeProject.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.jeeProject.dao.IUtilisateurDao;
import fr.epsi.jeeProject.dao.mockImpl.MockUtilisateurDao;
import fr.epsi.jeeProject.listener.StartupListener;

/**
 * Servlet implementation class Connect
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet 
{

	
	
	private static final Logger Logger = LogManager.getLogger(StartupListener.class); 

	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		Logger.info("Je suis dans ma servlet");
		request.getRequestDispatcher("TestInscription.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	//	Logger.info("Je suis dans ma servlet POST");
	//	request.getRequestDispatcher("TestConnexion.jsp").forward(request, response);
	//	request.setAttribute("MESSAGE","Merci de renseigner votre login ou votre mdp" );
	//	request.getRequestDispatcher("index.jsp").forward(request, response); 
		
		String user = request.getParameter("email");
		String password = request.getParameter("password");
		Logger.info("User "+user+" try to connect with password "+password);
		
		IUtilisateurDao userDao = new MockUtilisateurDao();
		
		
		
		if (user==null || user.contentEquals(""))
		{
			request.setAttribute("MESSAGE", "Merci de renseigner le login");
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
		else
		{
			userDao.getUtilisateur(user);
			
			
			//TODO Implementer la base de données
			//request.getRequestDispatcher("listBlogs.jsp").forward(request, response);
			request.getRequestDispatcher("TestInscription.jsp").forward(request, response);
		
		}
	}

}

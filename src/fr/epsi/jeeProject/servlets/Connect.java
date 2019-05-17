package fr.epsi.jeeProject.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.IUtilisateurDao;
import fr.epsi.jeeProject.dao.HSQLImpl.UtilisateurDao;
import fr.epsi.jeeProject.dao.mockImpl.MockUtilisateurDao;
import fr.epsi.jeeProject.listener.StartupListener;

/**
 * Servlet implementation class Connect
 */
@WebServlet("/Connect")
public class Connect extends HttpServlet 
{

	
	
	private static final Logger Logger = LogManager.getLogger(StartupListener.class); 

	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connect() {
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
		
		HttpSession maSession = request.getSession();
		
		if( maSession.getAttribute("isConnected").toString() == "true" )
		{
			request.getRequestDispatcher("accueil.jsp").include(request, response);
			Logger.info("Je suis deja co");
		}
		else
		{
			request.getRequestDispatcher("index.jsp").forward(request, response);
			Logger.info("Je suis pas co");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//doGet(request, response);
	//	Logger.info("Je suis dans ma servlet POST");
	//	request.getRequestD‚ispatcher("TestConnexion.jsp").forward(request, response);
	//	request.setAttribute("MESSAGE","Merci de renseigner votre login ou votre mdp" );
	//	request.getRequestDispatcher("index.jsp").forward(request, response); 
		
		String userMail = request.getParameter("email_signin");
		String userPassword = request.getParameter("password_signin");
		Logger.info("User "+userMail+" try to connect with password "+userPassword);
		
		IUtilisateurDao userDao = new UtilisateurDao();
		Utilisateur userBean = userDao.getUtilisateur(userMail);
		
		HttpSession maSession = request.getSession();
		maSession.setAttribute("isConnected", false);
		
		
		if( maSession.getAttribute("isConnected").toString() == "true" )
		{
			request.getRequestDispatcher("/Dashboard").include(request, response);

		}
		else
		{
			if (userBean==null || userMail.contentEquals(""))
			{
				request.setAttribute("MESSAGE", "Merci de renseigner le login");
				request.getRequestDispatcher("index.jsp").forward(request,response);
			}
			else
			{
				if(userMail.equals(userBean.getEmail()) && userPassword.equals(userBean.getPassord()))
				{
					maSession.setAttribute("isConnected",true );
					
					Logger.info("CONNEXION OK");
					System.out.println("Connexion ok");
					// Include : Pour rediriger vers un Servlet
					request.getRequestDispatcher("/Dashboard").include(request, response);
				}
				else
				{
					Logger.info("CONNEXION KO");
					System.out.println("Connexion KO");
					request.setAttribute("Erreur", "Login ou mot de passe incorrect");
					request.getRequestDispatcher("index.jsp").forward(request, response);

				}
			}
		}
		
		
	}
		
}



package fr.epsi.jeeProject.servlets;

import java.io.IOException;
import java.sql.SQLException;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String userName = request.getParameter("name_signup");
		String userMail = request.getParameter("email_signup");
		String userPassword = request.getParameter("password_signup");
		
		Logger.info("Name "+userName+" try to connect with Email : "+userMail+" password "+userPassword);
		
		IUtilisateurDao userDao = new UtilisateurDao();
		Utilisateur userBean = new Utilisateur() ;
		
		userBean.setNom(userName);
		userBean.setEmail(userMail);
		userBean.setPassord(userPassword); 
		try {
			userDao.createUtilisateur(userBean);
			request.setAttribute("Inscription", "Votre compte a été crée. Vous pouvez désormais vous connecté");
			request.getRequestDispatcher("index.jsp").forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}

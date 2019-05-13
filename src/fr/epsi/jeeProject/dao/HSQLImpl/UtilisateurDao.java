package fr.epsi.jeeProject.dao.HSQLImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;

import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.IUtilisateurDao;

public class UtilisateurDao implements IUtilisateurDao {

	private static final Logger logger = LogManager.getLogger(UtilisateurDao.class);

	@Override
	public Utilisateur getUtilisateur(String email) {

		Utilisateur myUser = null;
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003", "SA", "");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS WHERE email = ?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				myUser = new Utilisateur();
				myUser.setEmail(rs.getString(1));
				myUser.setNom(rs.getString(2));
				myUser.setPassord(rs.getString(4));
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			myUser = null;
			logger.error("Error while getting user " + email, e);
		}
		finally {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (Exception e) {
				logger.warn("Error while closing connection");
			}
		}

		return myUser;

	}

	@Override
	public void createUtilisateur(Utilisateur utilisateur) throws SQLException {
		
		
		LocalDateTime ldt = LocalDateTime.now();
		Connection con = null;
		String date =  DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.FRENCH).format(ldt);
		
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003", "SA", "");
			PreparedStatement ps = con.prepareStatement("INSERT INTO USERS(EMAIL, NOM, DATE_CREATION, PASSWORD, IS_ADMIN) VALUES (?,?,?,?,?)"); 
			ps.setString(1, utilisateur.getEmail());
			ps.setString(2, utilisateur.getNom());
			ps.setString(3, date);
			ps.setString(4, utilisateur.getPassord());
			ps.setString(5, "false");
			ps.executeUpdate();
			logger.warn(ps.toString());
			con.close();

			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			try 
			{
				if (con != null && !con.isClosed()) 
				{
					con.close();
				}
			} 
			catch (Exception e) 
			{
				logger.warn("2 - Error while closing connection");
			}
		}
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) throws SQLException {
// TODO Auto-generated method stub

	}

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) throws SQLException {
// TODO Auto-generated method stub

	}

	@Override
	public boolean isExist(Utilisateur utilisateur) throws SQLException {
		Connection con = null;
			
			try {
				con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003", "SA", "");
				PreparedStatement ps = con.prepareStatement("SELECT * FROM USERS WHERE EMAIL = ?");
				ps.setString(1, utilisateur.getEmail());
				ResultSet rs = ps.executeQuery();
				if (rs.next()) 
				{
					return true;	
				}
				rs.close();
				con.close();
			}
			catch (SQLException e) 
			{
				logger.error("Error while getting user account ", e);
			}
			finally 
			{
				try 
				{
					if (con != null && !con.isClosed()) 
					{
						con.close();
					}
				}
				catch (Exception e) 
				{
					logger.warn("Error while closing connection");
				}
			}
			
			return false; 
	}

}
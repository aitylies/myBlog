package fr.epsi.jeeProject.dao.HSQLImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import fr.epsi.jeeProject.beans.Blog;
import fr.epsi.jeeProject.beans.Reponse;
import fr.epsi.jeeProject.beans.Utilisateur;
import fr.epsi.jeeProject.dao.IBlogCommentaireDao;
import fr.epsi.jeeProject.dao.IBlogDao;

public class BlogCommentaireDao implements IBlogCommentaireDao
{
	private static final Logger logger = LogManager.getLogger(UtilisateurDao.class);

	public List<Reponse> getReponse(Blog blog)
	{
		List<Reponse> resultat = new ArrayList<Reponse>();
	
		Reponse myReponse = null; 
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003", "SA", "");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM BLOG_COMMENTAIRE WHERE ID = ?");
			ps.setLong(1, blog.getId());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				myReponse = new Reponse();
				myReponse.setCommentaire(rs.getString(2));
				myReponse.setPublication(rs.getDate(4));
				resultat.add(myReponse); 
			}
			rs.close();
			con.close();
	} catch (SQLException e) {
		myReponse = null;
		logger.error("Error while getting blog ", e);
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

	return resultat;


}
	public Integer createReponse(Reponse reponse) throws SQLException
	{
		Reponse myReponse = null; 
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003", "SA", "");
			PreparedStatement ps = con.prepareStatement("INSERT INTO BLOG_COMMENTAIRES VALUES (NEXT VALUE FOR ?, ?, ?, CURDATE())");
			ps.setInt(1,reponse.getBlog().getId());
			ps.setString(2, reponse.getCommentaire());
			ps.setString(3, reponse.getBlogger().getEmail());

			logger.warn(ps.toString());
			ps.executeUpdate();
			logger.debug(ps.toString());
			con.close();
			
		} catch (SQLException e) {
			myReponse = null;
			logger.error("Error while getting blog ", e);
		}
		finally {
			try {
				if (con != null && !con.isClosed()) {
					con.close();
				}
			} catch (Exception e) {
				logger.error("Error while closing connection");
			}
		}

		return -1; 
		
	}

	public void deleteBlog(Blog blog) throws SQLException
	{
		Reponse myReponse = null; 
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003", "SA", "");
			PreparedStatement ps = con.prepareStatement("DELETE FROM BLOG_COMMENTAIRES WHERE ID = ?");
			ps.setInt(1,blog.getId());
			logger.debug(ps.toString());
			ps.executeUpdate();
			con.close();
			
		} catch (SQLException e) {
			myReponse = null;
			logger.error("Error while deleting blog ", e);
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
	}
	
	
	
	
	
}

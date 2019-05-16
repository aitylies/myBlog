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

		return -1; 
		
	}
	public void updateBlog(Blog blog) throws SQLException
	{
		// TODO 
	}
	
	public void deleteBlog(Blog blog) throws SQLException
	{
		// TODO 
	}
	
	public void addReponse(Blog blog, Reponse reponse) throws SQLException
	{
		// TODO 
	}
	
	
	
	
}

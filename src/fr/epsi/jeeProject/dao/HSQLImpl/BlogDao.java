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
import fr.epsi.jeeProject.dao.IBlogDao;

public class BlogDao implements IBlogDao
{
	private static final Logger logger = LogManager.getLogger(UtilisateurDao.class);

	
	
	public List<Blog> getBlogs(Utilisateur utilisateur)
	{
		List<Blog> resultat = new ArrayList<Blog>();

		Blog myBlog = null; 
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003", "SA", "");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM BLOG WHERE email = ?");
			ps.setString(1, utilisateur.getEmail());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				myBlog = new Blog();
				myBlog.setId(rs.getInt(1));
				myBlog.setTitre(rs.getString(2));
				myBlog.setDescription(rs.getString(3));
				myBlog.setDateCreation(rs.getDate(5));
				resultat.add(myBlog); 
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			myBlog = null;
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
	
	
	public List<Blog> getAllBlogs()
	{
		List<Blog> resultat = new ArrayList<Blog>();

		Blog myBlog = null; 
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003", "SA", "");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM BLOG");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				myBlog = new Blog();
				myBlog.setId(rs.getInt(1));
				myBlog.setTitre(rs.getString(2));
				myBlog.setDescription(rs.getString(3));
				myBlog.setDateCreation(rs.getDate(5));
				resultat.add(myBlog); 
			}
			rs.close();
			con.close();
		} catch (SQLException e) {
			myBlog = null;
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
	
	public Blog getBlog(Integer id)
	{

		Blog myBlog = null; 
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003", "SA", "");
			PreparedStatement ps = con.prepareStatement("SELECT * FROM BLOG WHERE ID = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				myBlog = new Blog();
				myBlog.setId(rs.getInt(1));
				myBlog.setTitre(rs.getString(2));
				myBlog.setDescription(rs.getString(3));
				myBlog.setDateCreation(rs.getDate(5));
				//System.out.println("ICIIIIII"+myBlog.getDescription());
				return myBlog;
				
			}
			rs.close();
			con.close();
			
		} catch (SQLException e) {
			myBlog = null;
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

		return myBlog;


	}
	
	public Integer createBlog(Blog blog) throws SQLException
	{
		Blog myBlog = null; 
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9003", "SA", "");
			PreparedStatement ps = con.prepareStatement("INSERT INTO BLOG VALUES (NEXT VALUE FOR ID_BLOG, ?, ?, ?, CURDATE(), CURDATE(), ?)");
			ps.setString(1,blog.getTitre());
			ps.setString(2, blog.getDescription());
			ps.setString(3, blog.getCreateur().getEmail());
			ps.setInt(4, 1);
			logger.debug(ps.toString());
			ps.executeUpdate();
			con.close();
			logger.debug(ps);
		} catch (SQLException e) {
			myBlog = null;
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

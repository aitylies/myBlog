package fr.epsi.jeeProject.dao;

import java.sql.SQLException;
import java.util.List;

import fr.epsi.jeeProject.beans.Blog;
import fr.epsi.jeeProject.beans.Reponse;
import fr.epsi.jeeProject.beans.Utilisateur;

public interface IBlogDao {

	Blog getBlog(Integer id) throws SQLException;
	List<Blog> getAllBlogs() throws SQLException;
	List<Blog> getBlogs(Utilisateur utilisateur) throws SQLException;;
	Integer createBlog(Blog blog) throws SQLException;
	void updateBlog(Blog blog) throws SQLException;
	void deleteBlog(Blog blog) throws SQLException;
	void addReponse(Blog blog, Reponse reponse) throws SQLException;
	
}

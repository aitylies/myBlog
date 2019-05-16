package fr.epsi.jeeProject.dao;

import java.sql.SQLException;

import fr.epsi.jeeProject.beans.Reponse;

public interface IBlogCommentaireDao {
	Integer createReponse(Reponse reponse) throws SQLException;
}

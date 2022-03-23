package dao;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import modele.Cage;
import modele.Animal;

public class AnimalDAO extends DAO<Animal> {

	public AnimalDAO(Connection conn) throws SQLException{
		super(conn);
	}

	@Override
	public boolean create(Animal obj)throws SQLException {
		java.sql.Statement requeteAnimaux = conn.createStatement();
		java.sql.ResultSet resultatAnimaux = requeteAnimaux.executeQuery("INSERT INTO LesAnimaux VALUES ('"+obj.getNomA()+"','"+obj.getSexe()+"','"+obj.getType()+"','"+obj.getFonctionCage()+"','"+obj.getPays()+"',"+obj.getAnNais()+","+obj.getLaCage().getNoCage()+")"); 
		requeteAnimaux.close();
	    resultatAnimaux.close(); 
		return true;
	}

	@Override
	public Animal read(Object obj) throws SQLException{
		return null;
	}

	@Override
	public Set<Animal> readAll() throws SQLException {
		Set<Animal> animaux = new HashSet<>();
	java.sql.Statement requete = conn.createStatement();
	ResultSet resultat = requete.executeQuery("SELECT noCage,nomA,sexe,type_an  FROM LESANIMAUX");
	while(resultat.next()){
		Animal A1 = new Animal();
		Cage c = new Cage();
		c.setNoCage(resultat.getInt("noCage"));
		A1.setLaCage(c);
		A1.setNomA(resultat.getString("nomA"));
		A1.setSexe(resultat.getString("sexe"));
		A1.setType(resultat.getString("type_an"));
		animaux.add(A1);
	}
		requete.close();
		resultat.close();
		return animaux;
	}

	@Override
	public boolean update(Animal animal) throws SQLException{
		return false;
	}

	@Override
	public boolean delete(Animal obj) throws SQLException{
		return false;
	}

}

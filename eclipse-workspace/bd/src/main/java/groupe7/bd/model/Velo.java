package groupe7.bd.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import groupe7.bd.*;
import groupe7.bd.utils.TheConnection;

public class Velo {
	// Attributs
	Interface inter;// Permet d'accer au fonction de l'interface
	private int idVelo;
	private int idBornette;
	private Model modeleVelo;
	private Etat etat;
	private Date dateMeS;

	// Constructeur
	public Velo() {
		this.idVelo = 0;
		this.modeleVelo = Model.manuel;
		this.etat = Etat.ok;
		this.dateMeS = inter.dateStrConv("01/01/0000 00:00:00.00");
	}

	public Velo(int idVelo, Model modeleVelo, Etat etat, Date dateMeS) {
		this.idVelo = idVelo;
		this.modeleVelo = modeleVelo;
		this.etat = etat;
		this.dateMeS = dateMeS;
	}

	// Fonctions applications
	/*
	 * [Sql]
	 * Intteroge la base de donnèe pour rècupèrer les valeurs du velo "idVelo".
	 * [Java]
	 * Met à jour les valeur de l'objet courant
	 */
	public void loadVelo(int idVelo) {

		try {
			//SQL
			Connection conn=TheConnection.getInstance();
			java.sql.Statement requete;
			
			//Sql commande
			String sqlCommand = "SELECT * FROM Velo WHERE (idVelo = "+idVelo+");";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommand);
			//Java
			resultat.next();
			this.idVelo = resultat.getInt("idVelo");
			this.idBornette = resultat.getInt("idBornette");
			this.modeleVelo = Model.valueOf(resultat.getString("modelVelo"));
			this.etat = Etat.valueOf(resultat.getString("etatVelo"));
			this.dateMeS = inter.convDateSQLToJAVA(resultat.getString("dateMenS"));
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * [Sql]
	 * Intteroge la base de donnèe pour rècupèrer les valeurs du velo qui est a la
	 * bornette "idBornette".
	 * [Java]
	 * Met à jour les valeurs de l'objet courant
	 */
	public void loadVeloFromBornette(int idBornette) {

		try {
			// SQL
			Connection conn = TheConnection.getInstance();
			java.sql.Statement requete;

			// Sql commande
			String sqlCommand = "SELECT * FROM Velo WHERE (idBornette = " + idBornette + ");";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommand);
			// Java
			resultat.next();
			this.idVelo = resultat.getInt("idVelo");
			this.idBornette = resultat.getInt("idBornette");
			this.modeleVelo = Model.valueOf(resultat.getString("modelVelo"));
			this.etat = Etat.valueOf(resultat.getString("etatVelo"));
			this.dateMeS = inter.convDateSQLToJAVA(resultat.getString("dateMenS"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Fonctions applications
	/*
	 * [Sql]
	 * Intteroge la base de donnèe pour rècupèrer les valeurs du premier velo
	 * de la location id location.
	 * [Java]
	 * Met à jour les valeur de l'objet courant
	 */
	public void loadVeloFirstFromLocation(int idLocation) {
		try {
			// SQL
			Connection conn = TheConnection.getInstance();
			java.sql.Statement requete;

			// Sql commande
			String sqlCommand = "SELECT * FROM LocationsDetail WHERE (idLocations = " + idLocation + ") LIMIT 1";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommand);
			while (resultat.next()) {
				// JAVA
				this.idVelo = resultat.getInt("idVelo");
			}
			loadVelo(this.idVelo);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// getters et setters
	public int getIdVelo() {
		return idVelo;
	}

	public void setIdVelo(int idVelo) {
		this.idVelo = idVelo;
	}

	public int getIdBornette() {
		return idBornette;
	}

	public void setIdBornette(int idBornette) {
		this.idBornette = idBornette;
	}

	public Model getModeleVelo() {
		return modeleVelo;
	}

	public void setModeleVelo(Model modeleVelo) {
		this.modeleVelo = modeleVelo;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Date getDateMeS() {
		return dateMeS;
	}

	public void setDateMeS(Date dateMeS) {
		this.dateMeS = dateMeS;
	}
}

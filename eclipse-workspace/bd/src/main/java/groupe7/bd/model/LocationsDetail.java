package groupe7.bd.model;

import groupe7.bd.*;
import groupe7.bd.utils.TheConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LocationsDetail {
	//
	Interface inter;// Permet d'accer au fonction de l'interface
	private int idLocationsDetails;
	private int idLocations;
	private int idVelo;
	private double prix;
	private int depart;
	private int arrivee;
	private Date debut;
	private Date fin;
	private int fini;

	// contructeur
	public LocationsDetail() {
		this.idLocations = inter.locationCourante.getIdLocations();
		this.idVelo = inter.veloCourant.getIdVelo();
		this.depart = inter.stationCourante.getIdStation();
		this.debut = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
	}

	// Fonctions applications

	/*
	 * [Java]
	 * Affiche les valeur de l'objet courant si fini est à true
	 */
	public void ShowLocationFini() {
		if (this.fini == 1) {
			System.out.println("Velo N°" + this.idVelo + " Prix: " + this.prix + "€ De la sation " + this.depart + " à "
					+ this.debut + " Jusqu'à la sation " + this.arrivee + " à " + this.fin);
		}
	}

	/*
	 * [Java]
	 * Affiche les valeur de l'objet courant
	 */
	public void ShowLocation() {
		System.out.println("Velo N°" + this.idVelo + " Prix: " + this.prix + "€ De la sation " + this.depart + " à "
				+ this.debut + " Jusqu'à la sation " + this.arrivee + " à " + this.fin);
	}

	/*
	 * [Sql]
	 * Intteroge la base de donnèe pour rècupèrer les valeurs de la locationsDetails
	 * "idLocationsDetail".
	 * [Java]
	 * Met à jour les valeur de l'objet courant
	 */
	public void loadLocationIdLocations(int idLocationsDetail) {
		try {
			// SQL
			Connection conn = TheConnection.getInstance();
			java.sql.Statement requete;

			// Sql commande
			String sqlCommad = "SELECT * FROM LocationsDetail  WHERE (idLocationsDetails = " + idLocationsDetail + ")";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			while (resultat.next()) {
				// JAVA
				this.idLocationsDetails = resultat.getInt("idLocationsDetail");
				this.idLocations = resultat.getInt("idLocations");
				this.idVelo = resultat.getInt("idVelo");
				this.prix = resultat.getDouble("prix");
				this.depart = resultat.getInt("depart");
				this.arrivee = resultat.getInt("arrivee");

				String debut = resultat.getString("debut");
				this.debut = inter.convDateSQLToJAVA(debut);

				String fin = resultat.getString("fin");
				this.fin = inter.convDateSQLToJAVA(fin);

				this.fini = resultat.getInt("fini");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * [Sql]
	 * Enregistre la nouvelle location details".
	 */
	public void saveLocationDetail() {
		try {
			String str_fin = null;
			Object str_prix = null;
			Object str_arrivee = null;
			if (this.fin != null)
				str_fin = "'" + this.getFinSQL() + "'";
			if (this.prix != 0.0)
				str_prix = this.prix;
			if (this.arrivee != 0)
				str_arrivee = this.arrivee;

			// Sql
			String sqlCommand = "INSERT INTO LocationsDetail (idLocations,idVelo,prix,depart,arrivee,debut,fin,fini) VALUES"
					+ "(" + this.idLocations + "," + this.idVelo + "," + str_prix + "," + this.depart
					+ "," + str_arrivee + ",'" + this.getDebutSQL() + "',"
					+ str_fin + "," + this.fini + ");";
			Connection conn = TheConnection.getInstance();

			Statement stmt;
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlCommand);

			// retourne l' id de l'abonne
			sqlCommand = "SELECT MAX(idLocationsDetail) AS id FROM LocationsDetail;";
			Statement requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommand);

			while (resultat.next()) {
				this.idLocationsDetails = resultat.getInt("id");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// getters et setters
	public int getIdLocationsDetails() {
		return idLocationsDetails;
	}

	public void setIdLocationsDetails(int idLocationsDetails) {
		this.idLocationsDetails = idLocationsDetails;
	}

	public int getIdLocations() {
		return idLocations;
	}

	public void setIdLocations(int idLocations) {
		this.idLocations = idLocations;
	}

	public int getIdVelo() {
		return idVelo;
	}

	public void setIdVelo(int idVelo) {
		this.idVelo = idVelo;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public int getDepart() {
		return depart;
	}

	public void setDepart(int depart) {
		this.depart = depart;
	}

	public int getArrivee() {
		return arrivee;
	}

	public void setArrivee(int arrivee) {
		this.arrivee = arrivee;
	}

	public Date getDebut() {
		return debut;
	}

	public String getDebutSQL() {
		return inter.convDateJAVAToSQL(debut);
	}

	public void setDebut(Date debut) {
		this.debut = debut;
	}

	public Date getFin() {
		return fin;
	}

	public String getFinSQL() {
		return inter.convDateJAVAToSQL(fin);
	}

	public void setFin(Date localDateTime) {
		this.fin = localDateTime;
	}

	public int getFini() {
		return fini;
	}

	public void setFini(int fini) {
		this.fini = fini;
	}
}
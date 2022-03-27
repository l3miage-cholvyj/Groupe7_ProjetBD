package groupe7.bd.model;

import groupe7.bd.*;
import groupe7.bd.utils.TheConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LocationsDetail {
	//
	Interface inter;//Permet d'accer au fonction de l'interface
	private int idLocationsDetails;
	private int idLocations;
	private int idVelo;
	private double prix;
	private int depart;
	private int arrivee;
	private Date debut;
	private Date fin;
	private boolean fini;
	
	
	//contructeur
	
	//getters et setters
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
	
	public void setFin(Date fin) {
		this.fin = fin;
	}
	public boolean getFini() {
		return fini;
	}
	public void setFini(boolean fini) {
		this.fini = fini;
	}
	
	//Fonctions applications
	
	/* 
	 * [Java]
	 * Affiche les valeur de l'objet courant si fini est à true
	 */
	public void ShowLocationFini() {
		if (this.fini == true) {
			System.out.println("Velo N°"+this.idVelo+" Prix: "+this.prix+"€ De la sation "+this.depart+" à "+this.debut+" Jusqu'à la sation "+this.arrivee+" à "+this.fin);			
		}
	}
	
	/* 
	 * [Java]
	 * Affiche les valeur de l'objet courant
	 */
	public void ShowLocation() {
		System.out.println("Velo N°"+this.idVelo+" Prix: "+this.prix+"€ De la sation "+this.depart+" à "+this.debut+" Jusqu'à la sation "+this.arrivee+" à "+this.fin);			
	}
	
	/* [Sql]
	 * Intteroge la base de donnèe pour rècupèrer les valeurs de la locationsDetails "idLocationsDetail".
	 * [Java]
	 * Met à jour les valeur de l'objet courant
	 */
	public void loadLocationIdLocations(int idLocationsDetail) {
		int b;
		try {
			//SQL
			Connection conn=TheConnection.getInstance();
			java.sql.Statement requete;
			
			//Sql commande
			String sqlCommad = "SELECT * FROM LocationsDetail  WHERE (idLocationsDetail = "+idLocationsDetail+")";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			while (resultat.next()) {
				//JAVA
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
				
				b =  resultat.getInt("fini");
				if (b == 1) this.fini = true; else this.fini = false; 
				
			}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* [Sql]
	 * Enregistre la nouvelle location details".
	 */
	public void saveLocationDetail() {
		try {
			//Sql
			String sqlCommad = "INSERT INTO LocationsDetail (idLocations,idVelo,prix,depart,arrivee,debut,fin,fini) VALUES"
					+"("+this.idLocations+","+this.idVelo+","+this.prix+","+this.depart+","+this.arrivee+",'"
							+this.getDebutSQL()+"','"+this.getFinSQL()+"','"+this.fini+");";
			Connection conn=TheConnection.getInstance();
			
			Statement stmt;
			stmt = conn.createStatement();
			stmt.executeUpdate(sqlCommad);
			
			//retourne l' id de l'abonne
			sqlCommad = "SELECT MAX(idLocationsDetail) AS id FROM idLocationsDetail;";
			Statement requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			
			while (resultat.next()) {
				this.idLocationsDetails = resultat.getInt("id");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}

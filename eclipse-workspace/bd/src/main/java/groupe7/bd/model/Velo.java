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
	//Attributs
	Interface inter;//Permet d'accer au fonction de l'interface
	private int idVelo;
	private Model modeleVelo;
	private Etat etat;
	private Date dateMeS;

	//Constructeur
	public Velo() {
		this.idVelo = 0;
		this.modeleVelo = Model.Manuel;
		this.etat = Etat.Ok;
		this.dateMeS = Interface.dateStrConv("01/01/0000 00:00:00.00");
	}
	
	public Velo(int idVelo, Model modeleVelo, Etat etat, Date dateMeS) {
		this.idVelo = idVelo;
		this.modeleVelo = modeleVelo;
		this.etat = etat;
		this.dateMeS = dateMeS;
	}

	//getters et setters
	public int getIdVelo() {
		return idVelo;
	}
	
	public void setIdVelo(int idVelo) {
		this.idVelo = idVelo;
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
	
	//Fonctions applications
	/* [Sql]
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
			String sqlCommad = "SELECT * FROM Velo WHERE (idVelo = "+idVelo+")";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			while (resultat.next()) {
				//JAVA
				this.idVelo = resultat.getInt("idVelo");
			}	
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Fonctions applications
	/* [Sql]
	 * Intteroge la base de donnèe pour rècupèrer les valeurs du premier velo
	 * de la location id location.
	 * [Java]
	 * Met à jour les valeur de l'objet courant
	 */
	public void loadVeloFirstFromLocation(int idLocation) {
		try {
			//SQL
			Connection conn=TheConnection.getInstance();
			java.sql.Statement requete;
			
			//Sql commande
			String sqlCommad = "SELECT * FROM LocationsDetail WHERE (idLocations = "+idLocation+") LIMIT 1";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			while (resultat.next()) {
				//JAVA
				this.idVelo = resultat.getInt("idVelo");
			}
			loadVelo(this.idVelo);
				
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}


}

package groupe7.bd.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import groupe7.bd.*;
import groupe7.bd.utils.TheConnection;

public class Station {
	//Attributs
	Interface inter;//Permet d'accer au fonction de l'interface
	private int idStation;
	private String adresse;
	private Status status;

	
	//--Constructeurs-- 

	//getters et setters
	
	public int getIdStation() {
		return idStation;
	}

	public void setIdStation(int idStation) {
		this.idStation = idStation;
	}
	
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	//Fonctions applications
	
	/* [Sql]
	 * Intteroge la base de donnèe pour rècupèrer les valeurs de la station "idStaion".
	 * [Java]
	 * Met à jour les valeur de l'objet courant
	 *
	 */
	public void loadStation(int idStation) {
		try {
			//SQL
			Connection conn=TheConnection.getInstance();
			java.sql.Statement requete;
			
			//Sql commande
			String sqlCommad = "SELECT * FROM Station  WHERE (idStation = "+idStation+")";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			while (resultat.next()) {
				//JAVA
				this.idStation= resultat.getInt("idStation");
				this.adresse=resultat.getString("adresse");
				String statu;
				statu = resultat.getString("statu");
				switch(statu){
					case "vplus": this.status=Status.VPlus;
					break;
					case "vmoins" : this.status=Status.VMoins;
					break;
					case "vnul": this.status=Status.VNul;
					break;
					default : this.status = null;
				}
			}
				
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/* [Sql]
	 * Intteroge la base de donnèe pour rècupèrer l'id de la 1 première bornette de la Station courante qui
	 * est associé à un velo de Model type.
	 * [Java]
	 * et le retourne (idBornette) renvoie 0 si aucunne bornnette ne corrspond aux critaires
	 *
	 */
	public int veloExiste(Model type) {
		int idBornette = 0;
		String modelVelo;
		
		//type
		if (type == Model.Manuel) modelVelo = "manuel"; else modelVelo = "electrique";
		
		//SQL
		Connection conn=TheConnection.getInstance();
		java.sql.Statement requete;
		
		//Sql commande
		String sqlCommad = "SELECT * FROM Velo LEFT JOIN Bornette USING (idBornette) WHERE (idStation = "+this.idStation+" and modelVelo = '"+modelVelo+"') LIMIT 1";
		try {
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			while (resultat.next()) {
				idBornette = resultat.getInt(idBornette);
			}
			return idBornette; 
			
		} 
		catch (SQLException e) {
			return 0;
			//e.printStackTrace();
		}
		
	}
	

	/* [Sql]
	 * * Intteroge la base de donnèe pour rècupèrer l'id de la 1 première bornette de la Station courante qui
	 * est associé à aucun vélo.
	 * [Java]
	 * et le retourne (idBornette) renvoie 0 si aucunne bornnette ne correspond aux critaires
	 *
	 */
	public int getFirstIdBornetteLibre() {
		int idBornette = -1;

		//SQL
		Connection conn=TheConnection.getInstance();
		java.sql.Statement requete;
		
		//Sql commande
		String sqlCommad = "SELECT * FROM Velo RIGHT JOIN Bornette USING (idBornette) WHERE (idStation = "+this.idStation+" and etatBornette = 'ok' and idVelo is NULL) LIMIT 1";
		try {
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			while (resultat.next()) {
				idBornette = resultat.getInt("idBornette");
			}
			return idBornette;
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}


}

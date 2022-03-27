package groupe7.bd.model;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import groupe7.bd.*;
import groupe7.bd.utils.TheConnection;

public class Bornette {
	//Attributs
	Interface inter;//Permet d'accer au fonction de l'interface
	private int idBornette;
	private Etat etatBornette;
	
	

	//getters et setters
    public int getIdBornette(){
		return idBornette;
	}
	public void setIdBornette(int idBornette){
		this.idBornette=idBornette;
	}

	public Etat getEtatBornette(){
		return etatBornette;
	}
	public void setEtatBornette(Etat etatBornette){
		this.etatBornette=etatBornette;
	}
	
	//Fonctions applications
	
	/* [Sql]
	 * Intteroge la base de donnèe pour rècupèrer les valeurs de la bornette "idBornette".
	 * [Java]
	 * Met à jour les valeur de l'objet courant
	 *
	 */
	public void loadBornette(int idBornette) {
		
		try {
			//SQL
			Connection conn=TheConnection.getInstance();
			java.sql.Statement requete;
			
			//Sql commande
			String sqlCommand = "SELECT * FROM Bornette  WHERE (idBornette = "+idBornette+")";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommand);

			//JAVA
			resultat.next();
			this.idBornette = resultat.getInt("idBornette");
			this.etatBornette = Etat.valueOf(resultat.getString("etatBornette"));
				
			//fermeture des descripteurs 
			requete.close();
			resultat.close();
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

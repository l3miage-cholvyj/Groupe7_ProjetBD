package groupe7.bd.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import groupe7.bd.*;
import groupe7.bd.utils.TheConnection;

public class Client {
	//Attributs
	Interface inter;//Permet d'accer au fonction de l'interface
	int idClient;
	String numeroCarteBancaire;
	
	//Constructeurs

	public Client(int idClient, String numeroCarteBancaire) {
		this.idClient = idClient;
		this.numeroCarteBancaire = numeroCarteBancaire;
	}
	//getters et setters
	public String getNumeroCarteBancaire() {
		return numeroCarteBancaire;
	}
	public void setNumeroCarteBancaire(String numeroCarteBancaire) {
		this.numeroCarteBancaire = numeroCarteBancaire;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	
	//Fonctions applications
	/* NON PRIORITAIRE
	 * 
	 * [Sql]
	 * Intteroge la base de donnèe pour rècupèrer toutes les locations "TERMINEES" de l'abonné.
	 * 	Note on peut ajouter les locations en cours mais cela doit apparaitre clairement dans l'affiche
	 * 
	 * [Java]
	 * Affiche toutes les informations de l'objet courant
	 * Travailler l'affichage si possible
	 * 	exemple:
	 * 		Location N° XX Prix: XX
	 * 		détail:
	 * 			du XX/XX/XXXX au XX/XX/XXXX
	 * 			avec les vélos :
	 * 					id velo: XX
	 * 		
	 * 		Location N° XX Prix: XX
	 * 		détail:
	 * 			du XX/XX/XXXX au XX/XX/XXXX
	 * 			avec les vélos :
	 * 					id velo: XX
	 */
	public void showHistorique() {
		//SQL
		Connection conn=TheConnection.getInstance();
		java.sql.Statement requete;
				
		//Sql commande
		//System.out.println("->"+this.idClient);
		String sqlCommand = "SELECT * FROM Locations WHERE (idClient = "+this.idClient+");";
		try {
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommand);
					
			Location location;
					
			while (resultat.next()) {
				location = new Location();
				location.loadLocationIdLocations(resultat.getInt("IdLocations"));
				System.out.println("+------+");
				location.shownLocationIdLocations();
				System.out.println("+-----+");
			}
		}
		catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	//Fonctions applications
		/* NON PRIORITAIRE
		 * 
		 * [Sql]
		 * Intteroge la base de donnèe pour rècupèrer toutes les locations "NON-TERMINEES" de l'abonné.
		 * 	Note on peut ajouter les locations en cours mais cela doit apparaitre clairement dans l'affiche
		 * 
		 * [Java]
		 * Affiche toutes les informations de l'objet courant
		 */
		public void showEnCours() {
			//SQL
			Connection conn=TheConnection.getInstance();
			java.sql.Statement requete;
					
			//Sql commande
			//System.out.println("->"+this.idClient);
			String sqlCommand = "SELECT * FROM Locations WHERE (idClient = "+this.idClient+" && fini = 0);";
			try {
				requete = conn.createStatement();
				ResultSet resultat = requete.executeQuery(sqlCommand);
						
				Location location;
						
				while (resultat.next()) {
					location = new Location();
					location.loadLocationIdLocations(resultat.getInt("IdLocations"));
					System.out.println("+------+");
					location.shownLocationIdLocations();
					System.out.println("+-----+");
				}
			}
			catch (SQLException e){
				e.printStackTrace();
			}
			
		}
		
		/* [Sql]
		 * Interoge dans la base de donnèe
		 * le nombre de location en cours
		 * de l'abonné et le retourne
		 */
		public int calculNbLocationEnCours() {
			int nbLocation = 0;
			
			//SQL
			Connection conn=TheConnection.getInstance();
			java.sql.Statement requete;
			
			//Sql commande
			String sqlCommand = "SELECT COUNT(*) AS nbLocations  FROM Locations NATURAL JOIN Client LEFT JOIN Abonne USING (idClient) WHERE (fini = 0 and idClient = "+this.idClient+");";
			try {
				requete = conn.createStatement();
				ResultSet resultat = requete.executeQuery(sqlCommand);
				while (resultat.next()) {
					nbLocation = resultat.getInt("nbLocations");
				}
				return nbLocation;
			}
			catch (SQLException e){
				return 0;
			}

		}
		/* [Sql]
		 * Interoge la base de donnèe
		 * pour trouver la location avec l'index = indexLocation
		 * de l'objet courant. Et le retourne
		 * 
		 * ATTENTION doit instancier une location pour pouvoir la retourner
		 * 
		 */
		public Location getLocation(int indexLocation) {
			Location location = new Location();

			//SQL
			Connection conn=TheConnection.getInstance();
			java.sql.Statement requete;
			
			//Sql commande
			String sqlCommand = "SELECT * FROM Locations NATURAL JOIN Client LEFT JOIN Abonne USING (idClient) WHERE (idClient = "+this.idClient+");";
			try {
				requete = conn.createStatement();
				ResultSet resultat = requete.executeQuery(sqlCommand);
				for (int i = 0; i < indexLocation;i++) {
					resultat.next();
				}
				
				location.loadLocationIdLocations(resultat.getInt("idLocations"));
				
				return location;
				
			}
			catch (SQLException e){
				return location;
			}
		}
}

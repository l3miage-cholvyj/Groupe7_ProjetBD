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

public class Location {
	Interface inter;//Permet d'accer au fonction de l'interface
	private int idLocations;
	private int idClient;
	private List<LocationsDetail> velos;
	private String codeSecret;
	private Double prix;
	private boolean fini;

	//contructeur
	public Location() {
		this.idLocations = 0;
		this.idClient = 0;
		this.velos = new ArrayList<LocationsDetail>();
		this.codeSecret = null;
		this.prix = 0.0;
		this.fini = false;
	}
	
	/*
	public Location(int numCB,int idVelo, int codeSecret, Date dateDebutLocation, Date dateFinLocation) {
		this.numCB=numCB;
		this.idVelo=idVelo;
		this.codeSecret=codeSecret;
		this.dateDebutLocation=dateDebutLocation;
		this.dateFinLocation=dateFinLocation;
	}*/
	
	//getters et setters

	public int getIdLocations() {
		return idLocations;
	}

	public void setIdLocation(int idLocations) {
		this.idLocations = idLocations;
	}

	public List<LocationsDetail> getVelos() {
		return velos;
	}

	public void setVelos(List<LocationsDetail> velos) {
		this.velos = velos;
	}

	public String getCodeSecret() {
		return codeSecret;
	}

	public void setCodeSecret(String codeSecret) {
		this.codeSecret = codeSecret;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}
	
	public boolean getFini() {
		return fini;
	}

	public void setFini(boolean fini) {
		this.fini = fini;
	}
	
	//Fonctions applications
	
	
	/* [Sql]
	 * Intteroge la base de donnèe pour rècupèrer les valeurs de la location "idLocations".
	 * [Java]
	 * Met à jour les valeur de l'objet courant
	 */
	public void loadLocationIdLocations(int idLocations) {
		
		try {
			//SQL
			Connection conn=TheConnection.getInstance();
			java.sql.Statement requete;
			
			//Sql commande
			String sqlCommad = "SELECT * FROM Locations  WHERE (idLocations = "+idLocations+")";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			while (resultat.next()) {
				//JAVA
				this.idLocations = resultat.getInt("idLocations");
				this.codeSecret = resultat.getString("codeSecret");
				this.prix = resultat.getDouble("prix");
				this.fini = resultat.getBoolean("fini");
				loadLocationAllVelo(); // velos
				
			}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * [Java]
	 * Affiche la valeur de l'objet courant
	 */
	public void shownLocationIdLocations() {
		System.out.println("Location N°"+this.idLocations);
		System.out.println("codeSecret: "+this.codeSecret);
		System.out.println("prix: "+this.prix);
		System.out.println("fini :"+this.fini);
		System.out.println("***");
		for (LocationsDetail LocatationDetail : velos) LocatationDetail.ShowLocation();
		System.out.println("***");
		
	}
	
	
	/*
	 * [Java]
	 * Fixe la valeurs de l'attributs numCB
	 * et instance un nouveau client avec le numCB codeSecret
	 * avant de l'associer à la location courante.
	 * 
	 * [Sql]
	 * Met à jour la base de donnèe en créant une location associé à aucun abonné (client sans abonnement)
	 */
	public void editLocationAnonyme(String numCB,String codeSecret) {
		//[Java]
		//CodeSecret
		this.codeSecret = codeSecret;
		
		//numCB
		Client clientAnnonyme = new Client(0,numCB);
		
		//[Sql]
		try {
			String sqlCommad = "INSERT INTO Client (numCB) VALUES ('"+clientAnnonyme.getNumeroCarteBancaire()+"')";
			Connection conn=TheConnection.getInstance();
			
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sqlCommad, Statement.RETURN_GENERATED_KEYS);
			
			
			//retourne l' id client
			sqlCommad = "SELECT MAX(idClient) AS id FROM Client;";
			Statement requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			
			while (resultat.next()) {
				clientAnnonyme.setIdClient(resultat.getInt("id"));
				this.idClient = resultat.getInt("id");
			}
			
			//Sql commande new abonne
			sqlCommad = "INSERT INTO Locations (idClient,prix,codeSecret,fini) VALUES ("
			+clientAnnonyme.getIdClient()+","+this.prix+",'"+this.codeSecret+"','"+this.fini+"');";
			stmt = conn.createStatement();
			
			//Statement stmt = conn.prepareStatement(sqlCommad, Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate(sqlCommad);
			
			//retourne l' id de l'abonne
			sqlCommad = "SELECT MAX(idLocations) AS id FROM Locations;";
			requete = conn.createStatement();
			resultat = requete.executeQuery(sqlCommad);
			
			while (resultat.next()) {
				this.idLocations = resultat.getInt("id");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * [Java]
	 * Fixe les valeurs des attributs numCB et codeSecret à null car client abonné
	 * [Sql]
	 * Met à jour la base de donnèe en créant une location associé à l'abonneId (client avec abonnement)
	 */
	public void editLocationAbonne(int idClient) {
		//[Java]
		//idClient
		this.idClient = idClient;
				
		//[Sql]
		try {
			Connection conn=TheConnection.getInstance();
		
			//Sql commande new Locations
			String sqlCommad = "INSERT INTO Locations (idClient,prix,codeSecret,fini) VALUES ("
			+this.idClient+","+this.prix+",'"+this.codeSecret+"','"+this.fini+"');";
			Statement stmt = conn.createStatement();
					
			//Statement stmt = conn.prepareStatement(sqlCommad, Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate(sqlCommad);
					
			//retourne l' id de la locations
			sqlCommad = "SELECT MAX(idLocations) AS id FROM Locations;";
			Statement requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
					
			while (resultat.next()) {
					this.idLocations = resultat.getInt("id");
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	/*
	 * [Java]
	 * ajoute la location à list idVelos
	 * [Sql]
	 * Met à jour la base en ajoutant le velo à la location courante 
	 */
	public void editAjouterUnVelo(LocationsDetail Location) {
		//Java
		this.velos.add(Location);
		//Sql
		Location.saveLocationDetail();
	}
	
	/*
	 * [Sql]
	 * Intteroge la base de donnèe pour rècupèrer les valeurs de la location dont le codeSecret est codeSecret.
	 * [Java]
	 * Met à jour les valeur de l'objet courant
	 */
	public void loadLocationClient(String codeSecret) {
		//SQL
		Connection conn=TheConnection.getInstance();
		java.sql.Statement requete;
		
		//Sql commande
		String sqlCommad = "SELECT COUNT(*) FROM LocationsDetail WHERE (codeSecret = "+codeSecret+");";
		try {
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			while (resultat.next()) {
				loadLocationIdLocations(resultat.getInt("idLocations"));
			}
		}
		catch (SQLException e){

		}
	}
	
	/*
	 * [Sql]
	 * Intteroge la base de donnèe pour rècupèrer les vélos de la location courante.
	 * [Java]
	 * Met à jour les valeur de l'objet courant
	 */
	public void loadLocationAllVelo(){
		//SQL
		Connection conn=TheConnection.getInstance();
		java.sql.Statement requete;
				
		//Sql commande
		String sqlCommad = "SELECT * FROM LocationsDetail WHERE (idLocations = "+idLocations+");";
		try {
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			while (resultat.next()) {
				LocationsDetail location = new LocationsDetail();
				location.loadLocationIdLocations(resultat.getInt("idLocationsDetail"));
				this.velos.add(location);
			}
		}
		catch (SQLException e){

		}
	}
	
	/*
	 * [Sql]
	   Interoge dans la base de donnèe
	 * le nombre de vélo de la location en cours
	 * et le retourne
	 * */
	public int calculNbVelo() {
		int nbVelo = -1;
		
		//SQL
		Connection conn=TheConnection.getInstance();
		java.sql.Statement requete;
		
		//Sql commande
		String sqlCommad = "SELECT COUNT(*) AS nbVelo FROM LocationsDetail WHERE (idLocations = "+this.idLocations+" and fini = 0);";
		try {
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			while (resultat.next()) {
				nbVelo = resultat.getInt("nbVelo");
			}
			return nbVelo;
		}
		catch (SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	
	/*
	 * [Java]
	 * Fixe l'heure de retour de la sousLocations Courante
	 * 
	 * [Sql]
	 * 1) Mettre à jour la location dans la base de donnè
	 * 
	 * */
	public void editLocationStart(LocationsDetail sousLocation) {
		//JAVA
		sousLocation.setDebut(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		
		//Sql
		try {
			Connection conn=TheConnection.getInstance();
					
			//Sql commande new Locations
			String sqlCommad = "UPDATE LocationsDetail SET debut = "+sousLocation.getDebutSQL()+" WHERE (idLocationsDetail = "+sousLocation.getIdLocationsDetails()+")";
			Statement stmt = conn.createStatement();
							
			stmt.executeUpdate(sqlCommad);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * [Java]
	 * Fixe l'heure de retour de la sousLocations Courante
	 * 
	 * [Sql]
	 * 1) Mettre à jour la location dans la base de donnè
	 * 
	 * */
	public void editLocationEnd(LocationsDetail sousLocation) {
		//JAVA
		sousLocation.setFin(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));
		sousLocation.setFini(true);
		
		//Sql
		try {
			Connection conn=TheConnection.getInstance();
					
			//Sql commande new Locations
			String sqlCommad = "UPDATE LocationsDetail SET fin = '"+sousLocation.getFinSQL()+"', fini = 1 WHERE (idLocationsDetail = "+sousLocation.getIdLocationsDetails()+")";
			Statement stmt = conn.createStatement();
							
			stmt.executeUpdate(sqlCommad);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * [Java]
	 * Fixe à fin la location Courante
	 * 
	 * [Sql]
	 * 1) Mettre à jour la location dans la base de donnè
	 * 
	 * */
	public void editLocationsEnd() {
		//JAVA
		this.fini =true;
		
		//Sql
		try {
			Connection conn=TheConnection.getInstance();
					
			//Sql commande new Locations
			String sqlCommad = "UPDATE Locations SET fini = 1 WHERE (idLocations = "+this.idLocations+")";
			Statement stmt = conn.createStatement();
							
			stmt.executeUpdate(sqlCommad);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/*
	 * [Java]
	 * Calcul le prix de la location pour un velo
	 * 
	 * [Sql]
	 * Met à jour le prix de la location du velo la base de donnèe
	 */
	public double calculPrixLocation(LocationsDetail location) {
		//Java
		Double calculPrix = 0.0;
		//TODO
		location.setPrix(calculPrix);
		//Sql
		try {
			Connection conn=TheConnection.getInstance();
					
			//Sql commande new Locations
			String sqlCommad = "UPDATE LocationsDetail SET prix = "+location.getPrix()+" WHERE (idLocationsDetail = "+location.getIdLocationsDetails()+")";
			Statement stmt = conn.createStatement();
							
			stmt.executeUpdate(sqlCommad);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 17;

	}
	
	/*
	 * [Java]
	 * Calcul le prix de la location pour tous
	 * les velos
	 * 
	 * [Sql]
	 * Met à jour le pris de la location courante dans la base de donnèe
	 */
	public void calculPrixLocations() {
		//Java
		
		prix = 0.0;
		for (LocationsDetail location : velos) {
			calculPrixLocation(location);
			prix += location.getPrix();
		}
		
		//Sql
		try {
			Connection conn=TheConnection.getInstance();
			
			//Sql commande new Locations
			String sqlCommad = "UPDATE Locations SET prix = "+prix+" WHERE (idLocations = "+this.idLocations+");";
			Statement stmt = conn.createStatement();
					
			stmt.executeUpdate(sqlCommad);
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}

	}
	

}

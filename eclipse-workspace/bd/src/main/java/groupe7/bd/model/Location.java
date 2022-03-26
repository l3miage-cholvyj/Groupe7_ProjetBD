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

public class Location {
	private int idLocations;
	private List<Velo> velos;
	private String codeSecret;
	private Double prix;
	private boolean fini;

	//contructeur
	public Location() {
		this.idLocations = 0;
		this.velos = new ArrayList<Velo>();
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

	public List<Velo> getVelos() {
		return velos;
	}

	public void setVelos(List<Velo> velos) {
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
			String sqlCommad = "SELECT * FROM Locations  WHERE (idLocation = "+idLocations+")";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			while (resultat.next()) {
				//JAVA
				this.idLocations = resultat.getInt("idLocations");
				this.codeSecret = resultat.getString("codeSecret");
			}
				
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* [Sql]
	 * Intteroge la base de donnèe pour rècupèrer les valeurs de la location "idLocations".
	 * [Java]
	 * Met à jour les valeur de l'objet courant
	 */
	public void shownLocationIdLocations() {
		System.out.println("Location N°"+this.idLocations);
		//Affiché vélo TODO
		System.out.println("codeSecret: "+this.codeSecret);
		System.out.println("prix: "+this.prix);
		System.out.println("fini :"+this.fini);
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
		//CodeSecret
		this.codeSecret = codeSecret;
		
		//Client
		Client clientAnnonyme = new Client();
		
		//TODO
		/*
		clientAnnonyme.getIdClient();	
		clientAnnonyme.getNumeroCarteBancaire();*/
		
	}

	/*
	 * [Java]
	 * Fixe les valeurs des attributs numCB et codeSecret à null car client abonné
	 * [Sql]
	 * Met à jour la base de donnèe en créant une location associé à l'abonneId (client avec abonnement)
	 */
	public void editLocationAbonne(String numCB,int abonneId) {
		// TODO
		
	}
	
	/*
	 * [Java]
	 * ajoute le velo à list idVelos
	 * [Sql]
	 * Met à jour la base en ajoutant le velo à la location courante 
	 */
	public void editAjouterUnVelo(Velo velo) {
		//Java
		this.velos.add(velo);
		//Sql
		//String sqlCommad = "INSERT INTO Location (numCB) VALUES ('"+this.numeroCarteBancaire+"')";
		Connection conn=TheConnection.getInstance();
		
		//Statement stmt = conn.createStatement();
		//stmt.executeUpdate(sqlCommad, Statement.RETURN_GENERATED_KEYS);
	}
	
	/*
	 * [Sql]
	 * Intteroge la base de donnèe pour rècupèrer les valeurs de la location dont le codeSecret est codeSecret.
	 * [Java]
	 * Met à jour les valeur de l'objet courant
	 */
	public void loadLocationClient(String codeSecret) {
		// TODO
	}
	
	/*
	 * [Sql]
	   Interoge dans la base de donnèe
	 * le nombre de vélo de la location en cours
	 * et le retourne
	 * */
	public int calculNbVelo() {
		int nbVelo = 0;
		
		//SQL
		Connection conn=TheConnection.getInstance();
		java.sql.Statement requete;
		
		//Sql commande
		String sqlCommad = "SELECT COUNT(*) FROM LocationsDetail WHERE (idLocations = "+this.idLocations+");";
		try {
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			while (resultat.next()) {
				nbVelo = resultat.getInt("nbVelo");
			}
			return nbVelo;
		}
		catch (SQLException e){
			return nbVelo;
		}
	}
	
	/*
	 * [Java]
	 * 1) Retire le veloCourant de velos  
	 * 2) Si dateFinLocation est null  alors la fixer à now()
	 * 		On prend l'heur de remise du premier velo pour toutes la location 
	 * 
	 * [Sql]
	 * 1) Mettre à jour la location dans la base de donnè 
	 * 2) Mettre à jour le velo dans la base de donnè (le relier à l'idBornette)
	 * 
	 * */
	public void editVeloRendu(int idVelo,int idBornette) {
		// TODO
		
	}
	
	/*
	 * [Java]
	 * Calcul le prix de la location pour un velo
	 * 
	 * [Sql]
	 * Met à jour le prix de la location du velo la base de donnèe
	 */
	public double calculPrixVelo(int idVelo) {
		return 26;
		//TODO

	}
	
	/*
	 * [Java]
	 * Calcul le prix de la location pour tous
	 * les velos
	 * 
	 * [Sql]
	 * Met à jour le pris de la location courante dans la base de donnèe
	 */
	public void calculPrixLocation() {
		prix = 0.0;
		for (Velo velo : velos) {
			prix += calculPrixVelo(velo.getIdVelo());
		}

	}
	

}

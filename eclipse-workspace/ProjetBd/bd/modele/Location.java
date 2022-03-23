package modele;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import main.Interface;

public class Location {
	Interface inter;//Permet d'accer au fonction de l'interface
	private String numCB;
	private List<Velo> velos;
	private String codeSecret;
	private Date dateDebutLocation;
	private Date dateFinLocation;
	private Double prix;

	//contructeur
	public Location() {
		this.numCB = null;
		this.velos = new ArrayList<Velo>();
		this.codeSecret = null;
		Date dateDebutLocation =  Interface.now();
		this.dateDebutLocation = dateDebutLocation;
		Date dateFinLocation =  null;
		this.dateFinLocation = dateFinLocation;
		this.prix = 0.0;
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
	public String getNumCB(){
		return numCB;
	}
	public void  setNumCB(String numCB){
		this.numCB=numCB;	
    }

	public List<Velo> getIdVelo() {
		return velos;
	}

	public String getCodeSecret(){
		return codeSecret;
	}
	public void setCodeSecret(String codeSecret){
		this.codeSecret=codeSecret;
	}

	public Date getDateDebutLocation(){
		return dateDebutLocation;
	}
	public void setDateDebutLocation(Date dateDebutLocation){
		this.dateDebutLocation=dateDebutLocation;
	}
	public Date getDateFinLocation(){
		return dateFinLocation;
	}
	public void setDateFinLocation(Date dateFinLocation){
		this.dateFinLocation=dateFinLocation;
	}
	
	public int getIdLocation() {
		return 0;
	}
	
	public double getPrix() {
		return prix;
	}
	
	//Fonctions applications
	
	/*
	 * [Java]
	 * Fixe les valeurs des attributs numCB et codeSecret
	 * [Sql]
	 * Met à jour la base de donnèe en créant une location associé à aucun abonné (client sans abonnement)
	 */
	public void editLocationAnonyme(String numCB,String codeSecret) {
		// TODO	
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
		// TODO
		
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
		// TODO
		return 0;
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
		// TODO
		return 0;

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
			// TODO
		}

	}

	public void editSplitLocation() {
		// TODO Auto-generated method stub
		
	}
	

}

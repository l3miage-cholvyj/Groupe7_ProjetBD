package groupe7.bd.model;

import groupe7.bd.*;

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
		// TODO
		
	}
	
	/* [Sql]
	 * Intteroge la base de donnèe pour rècupèrer l'id de la 1 première bornette de la Station courante qui
	 * est associé à un velo de Model type.
	 * [Java]
	 * et le retourne (idBornette) renvoie 0 si aucunne bornnette ne corrspond aux critaires
	 *
	 */
	public int veloExiste(Model type) {
		// TODO Auto-generated method stub
		return 0;
	}
	

	/* [Sql]
	 * * Intteroge la base de donnèe pour rècupèrer l'id de la 1 première bornette de la Station courante qui
	 * est associé à aucun vélo.
	 * [Java]
	 * et le retourne (idBornette) renvoie 0 si aucunne bornnette ne correspond aux critaires
	 *
	 */
	public int getFirstIdBornetteLibre() {
		// TODO Auto-generated method stub
		return 0;
	}


}

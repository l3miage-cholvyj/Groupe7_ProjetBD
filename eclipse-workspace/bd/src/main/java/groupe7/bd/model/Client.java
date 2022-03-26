package groupe7.bd.model;

import groupe7.bd.*;

public class Client {
	//Attributs
	Interface inter;//Permet d'accer au fonction de l'interface
	int idClient;
	String numeroCarteBancaire;
	
	//Constructeurs

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
	
}

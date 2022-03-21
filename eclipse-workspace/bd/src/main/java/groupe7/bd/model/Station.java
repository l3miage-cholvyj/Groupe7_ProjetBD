package groupe7.bd.model;

import groupe7.bd.*;

public class Station {

	Interface inter;//Permet d'accer au fonction de l'interface
	
	private String adresse;
	private Status status;

	//constructeurs
	public Station(String adresse){
		this.adresse = adresse;
		this.status = Status.VNul;
	}

	public Station(String adresse, Status status){
		this.adresse = adresse;
		this.status = status;
	}

	//getters et setters
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
}

package groupe7.bd.model;

import groupe7.bd.*;
import java.sql.Date;

public class Location {
	Interface inter;//Permet d'accer au fonction de l'interface
    private int numCB;
	private int idVelo;
	private int codeSecret;
	private Date dateDebutLocation;
	private Date dateFinLocation;
	
	//contructeur
	public Location(int numCB,int idVelo, int codeSecret, Date dateDebutLocation, Date dateFinLocation) {
		this.numCB=numCB;
		this.idVelo=idVelo;
		this.codeSecret=codeSecret;
		this.dateDebutLocation=dateDebutLocation;
		this.dateFinLocation=dateFinLocation;
	}

	public void AjouterUnVelo(){
		//TODO...
	}

	//getters et setters

	public int getNumCB(){
		return numCB;
	}
	public void  setNumCB(int numCB){
    this.numCB=numCB;	}

	public int getIdVelo() {
		return idVelo;
	}

	public void setIdVelo(int idVelo) {
		this.idVelo = idVelo;
	}

	public int getCodeSecret(){
		return codeSecret;
	}
	public void setCodeSecret(int codeSecret){
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

}

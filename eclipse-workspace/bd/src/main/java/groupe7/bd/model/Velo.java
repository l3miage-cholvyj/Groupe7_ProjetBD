package groupe7.bd.model;

import java.sql.Date;

import groupe7.bd.*;

public class Velo {

	Interface inter;//Permet d'accer au fonction de l'interface

	private int idVelo;
	private Model modeleVelo;
	private Etat etat;
	private Date dateMeS;

	//Constructeur
	public Velo(int idVelo, Model modeleVelo, Etat etat, Date dateMeS) {
		this.idVelo = idVelo;
		this.modeleVelo = modeleVelo;
		this.etat = etat;
		this.dateMeS = dateMeS;
	}

	//getters et setters
	public int getIdVelo() {
		return idVelo;
	}

	public void setIdVelo(int idVelo) {
		this.idVelo = idVelo;
	}

	public Model getModeleVelo() {
		return modeleVelo;
	}

	public void setModeleVelo(Model modeleVelo) {
		this.modeleVelo = modeleVelo;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public Date getDateMeS() {
		return dateMeS;
	}

	public void setDateMeS(Date dateMeS) {
		this.dateMeS = dateMeS;
	}

}

package modele;
import main.Interface;

public class Bornette {
	//Attributs
	Interface inter;//Permet d'accer au fonction de l'interface
	private int idBornette;
	private Etat etatBornette;
	
	//Constructeurs
	public Bornette (){
        this.idBornette=0;
		  this.etatBornette=Etat.Ok;
	}
	
	public Bornette (int idBornette,Etat etatBornette){
        this.idBornette=idBornette;
		  this.etatBornette=etatBornette;
	}

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
		// TODO
		
	}

}

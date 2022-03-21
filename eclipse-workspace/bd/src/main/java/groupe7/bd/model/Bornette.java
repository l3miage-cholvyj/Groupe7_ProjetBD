package groupe7.bd.model;
import groupe7.bd.*;

public class Bornette {	

	Interface inter;//Permet d'accer au fonction de l'interface
	private int idBornette;
	private Etat etatBornette;

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

}

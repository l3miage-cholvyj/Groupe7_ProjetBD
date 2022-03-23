package groupe7.bd.model;
import groupe7.bd.*;

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
	 * le type de retour c'est void ou bien bornette ?? j'ai mis bornette
	 * Réponse c'est VOID et le ? dans ta requete c'est le paramètre idBornette
	 */
	public void loadBornette(int idBornette){
	
	}
	public Bornette loadBornette(int idBornette) {
		
		try {
		Connection conn=TheConnection.getInstance();
		PreparedStatement statement = conn.prepareStatement("select *from Bornette where idBorne=?");
		statement.setInt(1,idBornette);
		ResultSet resultat =  statement.executeQuery();
		Bornette borne =  new Bornette();
		while(resultat.next()){
			borne.setIdBornette(resultat.getInt("idBorne"));
		}

		return borne;
			
		} catch (Exception e) {
			e.printStackTrace();
			//TODO: handle exception
			return null;
		}
		
		// TODO
		
	}

}

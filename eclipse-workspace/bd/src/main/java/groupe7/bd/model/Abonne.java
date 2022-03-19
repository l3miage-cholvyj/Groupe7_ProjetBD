package groupe7.bd.model;
import groupe7.bd.*;

public class Abonne {
	
	Interface inter;//Permet d'accer au fonction de l'interface

	/*Crée une nouvelle instance d'abonne et la retourne
	* Inscrit cette instance dans la base de donnée
	*/
	public void newAbonne() {
		//TODO
		System.out.println( "---------------------------------" );
		System.out.println( "Création d'un abonnée");
		System.out.println( "Veuillez entrer votre: ");
		System.out.println( "nom: ");inter.demandeString();
		System.out.println( "prénom: ");inter.demandeString();
		System.out.println( "N° de CB: ");inter.demandeCompteBancaire();
		System.out.println( "Date de naissance: ");inter.demandeDate();
		System.out.println( "Sexe [F,H]: ");inter.demandeSexe();
		System.out.println( "Définir un code secret: ");inter.demandeCodeSecret();
		System.out.println( "");
			
		System.out.println( "Félicitaions vous êtes abonnèes");
		System.out.println( "");
		
		
	}
	
	/*Retourne le nom de l'abonnee*/
	public String getNom() {
		//TODO
		return "nom";
	}
	
	/*Retourne le prénom de l'abonnee*/
	public String getPrenom() {
		//TODO
		return "prenom";
	}
	
	/*Recherche dans la base de donnée l'abonné correspondant aux paramètres
	 *et le retourne.
	 *Renvoie null si aucun abonné ne correspond aux paramètres
	 */
	public Abonne connectionAbonne(String nomAbonne, String codeSecretAbonne) {
		//TODO
		return null;
	}
	
	/*Affiche toutes les informations de l'abonné
	*/
	public void getInformation() {
		//TODO	
	}

	/*Modifie les informations de l'abonné
	*/
	public void Edit() {
		// TODO
	}

	/* Crée une nouvelle instance de location
	 * et l'associe à l'abonné courant.
	 * Inscrire cette location dans la base de donnée
	 */
	public void newLocation() {
		// TODO
	}
	
	/* Crée une nouvelle instance de location
	 * et l'associe à l'abonné courant (null).
	 * Inscrire cette location dans la base de donnée
	 * avec le codeSecret
	 */
	public void newLocation(String codeSecret) {
		// TODO
	}

}

package groupe7.bd.model;
import groupe7.bd.*;

public class Abonne {
	//Attributs
	Interface inter;//Permet d'accer au fonction de l'interface
	
	//Constructeurs
		
	//getters et setters
	public String getNom() {
		//TODO
		return "nom";
	}
	
	public String getPrenom() {
		//TODO
		return "prenom";
	}
	
	public String getCB() {
		//TODO
		return "prenom";
	}
	
	//Fonctions applications
	
	/* [Sql]
	 * Intteroge la base de donnèe pour rècupèrer les valeurs de l'abonné qui possède le nom nomAbonne
	 * et le codeSercret codeSecretAbonne.
	 * [Java]
	 * Met à jour les valeur de l'objet courant si l'un abonne à été trouvé dans la base de donnèes sinon renvoie null
	 *
	 */
	public void loadAbonne(String nomAbonne, String codeSecretAbonne) {
		// TODO	
	}
	
	/* 
	 * [Java]
	 * Demande les valeurs de chaque attribut à l'uttilisateur et met à jour l'objet courant
	 * [Sql]
	 * Enregistre dans la base de donnè de nouvelle abonne en utilisant les valeurs de l'objet courant
	 */
	public void SaveNewAbonne() {
		//debut des demandes user [Java] déja revu par Khoi et Marez TODO
		System.out.println( "Création d'un abonnée");
		System.out.println( "Veuillez entrer votre: ");
		System.out.println( "nom: ");inter.demandeString();
		System.out.println( "prénom: ");inter.demandeString();
		System.out.println( "N° de CB: ");inter.demandeCarteBancaire();
		System.out.println( "Date de naissance: ");inter.demandeDate();
		System.out.println( "Sexe [F,H]: ");inter.demandeSexe();
		System.out.println( "Définir un code secret: ");inter.demandeCodeSecret();
		System.out.println( "");
			
		System.out.println( "Félicitaions vous êtes abonnèes");
		System.out.println( "");
		
		//Pour fixer les valeurs dans les attributs utiliser this.nom = ... ou si ça marche pas les setteurs
		//Khoi Marez ici mettre votre code du constructeur Abonne(avec les arguments)
		
		//[SQL] TODO
		
	}
	
	/* NON PRIORITAIRE
	 * [Java]
	 * Affiche toutes les informations de l'objet courant
	 * Travailler l'affichage si possible
	 * 	exemple:
	 * 		nom: XXX prénom : XXX
	 * 		age: XXX ans
	 * 
	 */
	public void showProfil() {
		// TODO
		
	}
	
	/* NON PRIORITAIRE
	 * [Java]
	 * Modifie les informations de l'objet courant
	 * [Sql]
	 * Met à jour dans la base de donnè l' abonne en utilisant les valeurs de l'objet courant
	 * 
	 * Note: version bourain on supprime l'abonneCourant et en recrée un nouveau
	 * 
	 */
	public void editProfil() {
		// TODO Auto-generated method stub
		
	}
	
	/* NON PRIORITAIRE
	 * 
	 * [Sql]
	 * Intteroge la base de donnèe pour rècupèrer toutes les locations "TERMINEES" de l'abonné.
	 * 	Note on peut ajouter les locations en cours mais cela doit apparaitre clairement dans l'affiche
	 * 
	 * [Java]
	 * Affiche toutes les informations de l'objet courant
	 * Travailler l'affichage si possible
	 * 	exemple:
	 * 		Location N° XXX Prix: XXX
	 * 		détail:
	 * 			du XXX/XXX/XXX au XXX/XXX/XXX
	 * 			avec les vélos :
	 * 					id velo: XXX
	 * 		
	 * 		Location N° XXX Prix: XXX
	 * 		détail:
	 * 			du XXX/XXX/XXX au XXX/XXX/XXX
	 * 			avec les vélos :
	 * 					id velo: XXX
	 */
	public void showHistorique() {
		// TODO Auto-generated method stub
		
	}
	
	/* A sup si attrib idAbo
	 * [Sql]
	 * Interroge la base de donnèe pour optenir l'id de l'objet courant
	 * et le retourne
	 */
	
	public int getAbonneId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/* [Sql]
	 * Interoge dans la base de donnèe
	 * le nombre de location en cours
	 * de l'abonné et le retourne
	 * 
	 */
	public int calculNbLocation() {
		// TODO
		return 0;
	}
	
	/* [Sql]
	 * Interoge la base de donnèe
	 * pour trouver la location avec l'index = indexLocation
	 * de l'objet courant. Et le retourne
	 * 
	 * ATTENTION doit instancier une location pour pouvoir la retourner
	 * 
	 */
	public Location getLocation(int indexLocation) {
		// TODO
		return null;
	}
	
	/*[Sql]
	 * Intteroge la base de donnèe pour rècupèrer toutes les locations "EN COURS" de l'abonné.
	 *Affiche les résultat sous la forme:
		 * 	(1)-> location n°1 /dateDébut/
		 *  (2)-> location n°2 /dateDébut/
	 */
	public void showLocation() {
		// TODO
		
	}


	

	
	
	
	//public Abonne(String nomAbonne, String codeSecretAbonne) {
		// TODO Auto-generated constructor stub
	//}

	/*Crée une nouvelle instance d'abonne et la retourne
	* Inscrit cette instance dans la base de donnée
	*/
	/*public void newAbonne() {
		//TODO
		System.out.println( "---------------------------------" );
		System.out.println( "Création d'un abonnée");
		System.out.println( "Veuillez entrer votre: ");
		System.out.println( "nom: ");inter.demandeString();
		System.out.println( "prénom: ");inter.demandeString();
		System.out.println( "N° de CB: ");inter.demandeCarteBancaire();
		System.out.println( "Date de naissance: ");inter.demandeDate();
		System.out.println( "Sexe [F,H]: ");inter.demandeSexe();
		System.out.println( "Définir un code secret: ");inter.demandeCodeSecret();
		System.out.println( "");
			
		System.out.println( "Félicitaions vous êtes abonnèes");
		System.out.println( "");
		
		
	}*/
	
	
	
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

	

	/*Interoge la base de donnèe pour savoir
	 *  si le le code secret et celui d'un abonné 
	 * annonyme
	 */
	public boolean verifCode(int demandeCodeSecret) {
		// TODO
		return false;
	}

	

}

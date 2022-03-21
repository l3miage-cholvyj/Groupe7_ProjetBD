package groupe7.bd;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.InputMismatchException;

import groupe7.bd.model.*;

public class Interface {
	
	private static Station stationCourante;
	private static Bornette bornetteCourante;
	private static Velo veloCourant;
	private static Location locationCourante;
	private static Trajet trajetCourant;
	private static Client clientCourant;
	private static Abonne abonneCourant;
	private static boolean flag20;
	private static boolean flag30;
	
	//Tableau des idPages
	private static int tabIdPage[][] ={
		/*N°00*/{-1,11,10,30,40,-1,-1,-1,-1,-1},/*N°01*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°02*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°03*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°04*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°05*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°06*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°07*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°08*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°09*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°10*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°11*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°12*/{-1,-1,-1,-1,-1,-1,0,-1,-1,-1},/*N°13*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°14*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°15*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°16*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°17*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°18*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°19*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°20*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°21*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°22*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°23*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°24*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°25*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°26*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°27*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°28*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°29*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°30*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°31*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°32*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°33*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°34*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°35*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°36*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°37*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°38*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°39*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°40*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°41*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°42*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°43*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°44*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°45*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°46*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°47*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°48*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},/*N°49*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
		/*N°50*/{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}
	};
	
	/*
	 * Génére un code secret aléatoire pour les utilisateurs anonymes (sans abonnement)
	 */
	public static String genererCodeSecret() {
		//TODO
		return "111111111";
	}
	
	/*
	 * Attend que l'utilisateur appuie sur n'importe quelle touche
	 */
	public static void attentAppuieTouche() {
		//TODO
	}
	
	/*
	 * Demande à l'utilisateur d'entrer une chaîne
	 * de caractère et la retourne. 
	*/
	public static String demandeString() {
		//TODO
		return "null";
	}
	
	/*
	 * Demande à l'utilisateur d'entrée un entier compris
	 * entre min et max inclus et le retourne
	*/
	public static int demandeInt(int min,int max) {
		// TODO
		return 0;
	}
	
	/*
	 * Demande à l'utilisateur d'entrée un sexe
	 * H (homme) F(femme) et le retourne
	*/
	public static Sexe demandeSexe() {
		// TODO
		return Sexe.H;
	}
	
	/*
	 * Convertie une chaîne de caractère de format (JJ/MM/AAAA) en une date local_date 
	 * et la retourne. 
	*/
	public static LocalDate dateStrConv(String dateStr) {
		DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    LocalDate local_date = LocalDate.parse(dateStr, JEFormatter);
	    
	    return local_date;
	}
	
	/*
	 * Demande à l'utilisateur d'entrer une date au format (JJ/MM/AAAA) chaine de caractère
	 * et la retourne. 
	*/
	public static LocalDate demandeDate() {
		LocalDate date =  dateStrConv("21/12/2021");
		// TODO
		return date;
	}
	
	/*
	 * Demande à l'utilisateur d'entrer un code
	 * secret et le retourne. 
	*/
	public static int demandeCodeSecret() {
		return 1234;// TODO
	}
	
	/*
	 * Demande à l'utilisateur d'entrer un numéro de carte
	 * bancaire et le retourne. 
	*/
	public static String demandeCarteBancaire() {
		return "155895124569475";// TODO
	}
	
	/*
	 * Demande à l'utilisateur d'entrer un nombre correspondant
	 * à son choix du menu et l'id de la page suivante.
	*/
	public static int choixMenu(int idPage){
		int idChoix,idPageNext = -1;
		java.util.Scanner entree =   new java.util.Scanner(System.in);
		
		System.out.println( "Entrer votre choix: " );
		
		while (idPageNext < 0) {
			try {
				idChoix = entree.nextInt();
				idPageNext = tabIdPage[idPage][idChoix];
				if (idPageNext == -1) System.out.println( "!--Choix invalide--!\n Entrer votre choix: ");
			}
			catch (InputMismatchException e) {
				 System.out.println( "!--Choix invalide--!\n");
				 idPageNext = choixMenu(idPage);
			}
		}
		
		return idPageNext;
		
	}
	
	/*
	 * Page 0X -> Gestion non-abonné
	 * Page 1X -> Gestion abonné
	 * Page 2X -> Prise de vélo
	 * Page 3X -> Retour de vélo
	 * Page 4X -> Débug
	 * */
	
	/*
	 * Page Home principale
	 */
	public static void InterfaceP0() {
		stationCourante = new Station(1);
		System.out.println( "---------------------------------" );
		System.out.println( "Bonjour! Bienvenue sur VéPick" );
		System.out.println( "Que voulez-vous faire ?" );
		System.out.println( "(1)->S'identifier" );
		System.out.println( "(2)->Créer un compte" );
		System.out.println( "(3)->Prendre un vélo" );
		System.out.println( "(4)->Rendre un vélo" );
		System.out.println( "" );
	}
	
	/*
	 * Page Accueil abonné
	 */
	public static void InterfaceP10() {
		
		System.out.println( "---------------------------------" );
		System.out.println( "Bonjour! "+abonneCourant.getNom()+""+abonneCourant.getPrenom());
		System.out.println( "Que voulez-vous faire ?" );
		
		System.out.println( "(1)->Information compte" );
		System.out.println( "(2)->Prendre un vélo" );
		System.out.println( "(3)->Rendre un vélo" );
		System.out.println( "(4)->Historique des locations" );
		System.out.println( "(5)->Afficher Stations Vplus Vmoins" );
		System.out.println( "(6)->Se déconnecter" );
	}
	
	/*
	 * Page d'identification
	 */
	public static void InterfaceP11() {
		String nomAbonne,codeSecretAbonne;
		
		System.out.println( "---------------------------------" );
		System.out.println( "Veuillez entrer votre ");
		System.out.println( "nom: ");nomAbonne = demandeString();
		System.out.println( "code secret: ");codeSecretAbonne = demandeString();
		
		/*
		 * Lance une identification
		 */
		abonneCourant = new Abonne(nomAbonne,codeSecretAbonne);
		if (abonneCourant.getNom() == null) {
			System.out.println( "Echec de la connexion" );
			Interface(0);
		}
		else {
			System.out.println( "Connexion réussie" );
			if (flag20 == true) Interface(20);
			else {
				if (flag30 == true) Interface(30);
				else Interface(10);	
			}
		}
	}

	/*
	 * Page de création d'un d'abonné
	 */
	public static void InterfaceP12() {
		
		abonneCourant.newAbonne();		
		Interface(10);
	}
	
	/*
	 * Affiche les informations de l'abonné
	 */
	public static void InterfaceP13() {
		abonneCourant.getInformation();
		System.out.println( "" );
		System.out.println( "(1)->Retourner au menu" );
		System.out.println( "(2)->Editer le profil" );
	}
	
	/*
	 * Edite les informations de l'abonné
	 */
	public static void InterfaceP14() {
		abonneCourant.Edit();
		attentAppuieTouche();
		Interface(10);
	}
	
	/*
	 * Affiche les stations VPlus et VMoins
	 */
	public static void InterfaceP15() {
		System.out.println( "Liste des stations VPlus" );
		stationCourante.ShowSationsVPlus();
		System.out.println( "Liste des stations VMoins" );
		stationCourante.ShowSationsVMoins();
		
		attentAppuieTouche();
		Interface(10);
	}
	
	/*
	 * Modiffie le flag 20
	 */
	public static void InterfaceP18() {
		flag20 = true; 
		Interface(10);
	}
	
	/*
	 * Modiffie le flag 30
	 */
		public static void InterfaceP19() {
			flag30 = true; 
			Interface(10);
		}

	/*
	 * Page home emprunt velo (location)
	 */
	public static void InterfaceP20() {
		//Créer une nouvelle instance de location pour l'abonneCourant
		locationCourante = new Location(abonneCourant);
		Interface(23);
	}
	
	/*
	 * Page emprunt vélo (sans abonnement)
	 */
	public static void InterfaceP21() {
		System.out.println( "Emprunter des vélos:");
		System.out.println( "(1)->Vous connecter");
		System.out.println( "(2)->Sans connexion" );
	}
	
	/*
	 * Page emprunt velo (génération code secret)
	 */
	public static void InterfaceP22() {
		String codeSecret = genererCodeSecret();
		locationCourante.rechercheCodeSecret(codeSecret);
		System.out.println( "Votre code secret est: "+codeSecret);
		attentAppuieTouche();
		Interface(23);	
	}
	
	/*
	 * Page home emprunt vélo (Veéo)
	 */
	public static void InterfaceP23() {
		System.out.println("Quel modèle de vélo voulez-vous");
		System.out.println( "(1)->Manuel" );
		System.out.println( "(2)->Electrique" );
		System.out.println( "(3)->Annuler saisie" );
	}
	
	/*
	 * Page de vérification de l'existence d'un vélo model Manuel
	 */
	public static void InterfaceP24() {
		bornetteCourante = stationCourante.veloExiste(Model.Manuel);
		if(bornetteCourante == null) {
			System.out.println("Erreur, ce modèle est indisponible");
			Interface(23);
		}
		else {
			veloCourant = new Velo(bornetteCourante);
			Interface(26);
		}
	}
	
	/*
	 * Page de vérification de l'existence d'un vélo model Electrique
	 */
	public static void InterfaceP25() {
		bornetteCourante = stationCourante.veloExiste(Model.Electrique);
		if(bornetteCourante == null) {
			System.out.println("Erreur, ce modèle est indisponible");
			Interface(23);
		}
		else {
			veloCourant = new Velo(bornetteCourante);
			Interface(26);
		}
	}
	
	
		
		
	public static void InterfaceP26() {
		locationCourante.AjouterUnVelo(veloCourant);
		System.out.println( "Prenez le velo n°"+veloCourant.getId()+ " à la bornette"+bornetteCourante.getId());
		Interface(23);
		//TODO
	}
	
	/*
	 * Page Remise vélo
	 */
	public static void InterfaceP30() {
		System.out.println( "Bonjour "+abonneCourant.getNom()+" "+abonneCourant.getPrenom());
		if (abonneCourant.nbLocation() == 1) { 
			locationCourante = abonneCourant.getLocation();
			Interface(34);
		}
		else Interface(33);
	}
	
	/*
	 * Page Remise sans Abonnement
	 */
	public static void InterfaceP31() {
		System.out.println( "Emprunter des vélos:");
		System.out.println( "(1)->Vous connecter");
		System.out.println( "(2)->Sans connexion" );
	}
	
	//Pages Code secret
	public static void InterfaceP32() {
		System.out.println( "Veuillez entrer votre code secret:");
		System.out.println( "Code secret:");
		locationCourante = new Location(demandeCodeSecret())
		if (locationCourante == null) {
			System.out.println( "Code secret Invalide");
			Interface(0);
		}
		else {
			Interface(34);
		}
		
	}
	
	//Choix de location
	public static void InterfaceP33() {
		abonneCourant.afficheLocation();
		System.out.println( "Veuillez choisir votre location:");
		int nbLocations = abonneCourant.nbLocation();
		int indexChoix = demandeInt(1,nbLocations);
		locationCourante = abonneCourant.getLocation(indexChoix);
		Interface(34);
	}
		
	//Remise de velo
	public static void InterfaceP34() {
		System.out.println( "Nombre de velo à rendre: "+abonneCourant.getNbVelo(locationCourante));
		locationCourante.getVelo();
		int id = veloCourant.getId();
		Model model = veloCourant.getModel();
		bornetteCourante = stationCourante.getPremierBornetteLibre(); 
		if(bornetteCourante == null) {
			System.out.println("Plus de place disponible, veuillez trouver une autre station");
			Interface(36);
		}
		else
		{
			int idBornette = bornetteCourante.getId();
			System.out.println( "Rendre le velo N°"+id+"de model: "+model+" à la bornette N° "+idBornette);
			System.out.println( "(1)->Confirmer la remise du velo");
			System.out.println( "(2)->Arrêter");
		}
	}
	
	//Valider Rendus Velo
	public static void InterfaceP35() {
		veloCourant.editTrajet(stationCourante);
		Interface(36);
	}
		
	//Stop Locations
	public static void InterfaceP36() {
		if (abonneCourant.getNbVelo(locationCourante) > 0) {
			//locationCourante.splitLocation();
			int prix = locationCourante.getPrix();
			System.out.println( "Votre location vous a coûté:"+locationCourante.getPrix()+"€");
			System.out.println( "Merci d'avoir utilisé Vé Pick");
		}
	}
	
	//Page d'erreur
	public static void 	InterfaceErr() {
		System.out.println( "---------------------------------" );
		System.out.println( "Page 404 Not found" );
		System.out.println( "---------------------------------" );
	}

	public static void Interface(int idPage) {
		
		//Lance la page N° idPage
		switch(idPage) {
			case 0: InterfaceP0();break;
			
			case 10: InterfaceP10();break;
			case 11: InterfaceP11();break;
			case 12: InterfaceP12();break;
			case 13: InterfaceP13();break;
			case 14: InterfaceP14();break;
			case 15: InterfaceP15();break;
			case 18: InterfaceP18();break;
			case 19: InterfaceP19();break;
			
			case 20: InterfaceP20();break;
			case 21: InterfaceP21();break;
			case 22: InterfaceP22();break;
			case 23: InterfaceP23();break;
			
			case 30: InterfaceP30();break;
			case 31: InterfaceP31();break;
			case 32: InterfaceP32();break;
			case 33: InterfaceP33();break;
			case 34: InterfaceP34();break;
			case 35: InterfaceP35();break;
			case 36: InterfaceP36();break;
			
			
			/*
			case 6: InterfaceP1();break;
			case 7: InterfaceP1();break;
			*/
			default: InterfaceErr();
		}
		
		//Choix du menu
		int nextIdPage = choixMenu(idPage);
		System.out.println( "---------------------------------\n" );
		Interface(nextIdPage);
	}
}

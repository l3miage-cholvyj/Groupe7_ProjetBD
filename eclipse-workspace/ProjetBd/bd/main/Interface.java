package main;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import modele.*;


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
			//{idPage,idPageSuivant(1->),idPageSuivant(2->),...}
			{0,11,12,21,31,-1,-1,-1,-1,-1},
			{10,13,22,33,16,15,0,-1,-1,-1},
			{13,10,14,-1,-1,-1,-1,-1,-1,-1},
			{21,18,22,-1,-1,-1,-1,-1,-1,-1},
			{23,24,25,27,-1,-1,-1,-1,-1,-1},
			{31,19,32,-1,-1,-1,-1,-1,-1,-1},
			{34,35,36,-1,-1,-1,-1,-1,-1,-1},
	};
	
	//FONCTIONS SHOW  Recherchent des valeurs dans la bases de donnèes et les affiches
	
		/*
		 * Recherche dans la base de donnèe toutes les station Vplus
		 * et les affiches
		 */
		public static void showSationsVPlus() {
			// TODO
		}
		
		/*
		 * Recherche dans la base de donnèe toutes les station Vmoins
		 * et les affiches
		 */
		public static void showSationsVMoins() {
			// TODO
		}
		
		/*
		 * [SQL]
		 * Interroge la base de donnèe pour récupèrer toutes les stations.
		 * Affiche les résultat sous la forme:
		 * 	(1)-> Station n° /idStaion/: /adresse/
		 *  (2)-> ...
		 * 
		 */
		public static void showAllStation() {
			// TODO
		}
		
		/*
		 * [SQL]
		 * Interroge la base de donnèe pour obetenir le nombre de stations
		 * et le retourne
		 */
		public static int calculNombreStation() {
			// TODO
			return 0;
		}
		
	
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
	 * Convertie une chaîne de caractère de format (dd/MM/yyyy HH:mm:ss.SS) en une date
	 * et la retourne. 
	*/
	public static Date dateStrConv(String dateStr) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss.SS");
		String strDate = sdf.format(dateStr);
		Date date;
		try {
			date = sdf.parse(strDate);
		} 
		catch (ParseException e) {
			return null;
			//e.printStackTrace();
		}
	    return date;
	}
	
	/*
	 * Renvoie la date et l'heure du jour. 
	*/
	public static Date now() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat();
		SimpleDateFormat sdf1 = new SimpleDateFormat();
	    sdf1.applyPattern("dd/MM/yyyy HH:mm:ss.SS");
	    String strDate = sdf.format(cal.getTime());
	    Date dateDuJour;
		try {
			dateDuJour = sdf1.parse(strDate);
		} catch (ParseException e) {
			return null;
			//e.printStackTrace();
		}
	    return dateDuJour;
		
	}
	
	/*
	 * Demande à l'utilisateur d'entrer une date au format (dd/MM/yyyy HH:mm:ss.SS)
	 * et la retourne comme une date.
	 * Cf: dateStrConv() pour converir un String en Date
	 * 		ATTENTION Gérer l'exception
	*/
	public static Date demandeDate() {
		Date date =  dateStrConv("01/01/0000 00:00:00.00");
		// TODO
		return date;
	}
	
	/*
	 * Demande à l'utilisateur d'entrer un code
	 * secret et le retourne. 
	*/
	public static String demandeCodeSecret() {
		return "0152";// TODO
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
		int idChoix = 0,idPageNext = -1,index = 0;
		java.util.Scanner entree =   new java.util.Scanner(System.in);
		
		//index de l'id page
		while ((tabIdPage[index][0] != idPage) && (index < tabIdPage.length)) {
			index++;
		}
		
		System.out.println( "Entrer votre choix: " );
		
		if (index == tabIdPage.length) {
			System.out.println( "!--Erreur tableau de redirection manquan--!\n");
		}
		
		while (idPageNext < 0) {
			try {
				idChoix = entree.nextInt();
				if (idChoix > 0) idPageNext = tabIdPage[index][idChoix];
				if ((idPageNext == -1) || (idChoix == 0) ) System.out.println( "!--Choix invalide--!\n Entrer votre choix: ");
			}
			catch (InputMismatchException e) {
				 System.out.println( "!--Choix invalide--!\n");
				 return -1;
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
		System.out.println( "---------------------------------" );
		//Choix de la station
		System.out.println( "A quel sations êtes vous ?");
		System.out.println( "" );
		showAllStation(); // Affiche les stations
		int nbStaions = calculNombreStation(); //Récupère le nombre de Stations
		int idStation = demandeInt(1,nbStaions); // Demande l'id de la Station à l'USER
		stationCourante = new Station(); // Crée une instance station "vide"	
		stationCourante.loadStation(idStation); // LOAD les valeur de la stationCourante
		
		//Affichage de l'écran
		System.out.println( "---------------------------------" );
		System.out.println( "Bonjour! Bienvenue sur VéPick" );
		System.out.println( "Que voulez-vous faire ?" );
		System.out.println( "" );
		System.out.println( "(1)->S'identifier" );
		System.out.println( "(2)->Créer un compte" );
		System.out.println( "(3)->Prendre un vélo" );
		System.out.println( "(4)->Rendre un vélo" );
	}
	
	/*
	 * Page Accueil abonné
	 */
	public static void InterfaceP10() {
		//Affichage de l'écran
		System.out.println( "---------------------------------" );
		System.out.println( "Bonjour! "+abonneCourant.getNom()+""+abonneCourant.getPrenom());
		System.out.println( "Que voulez-vous faire ?" );
		System.out.println( "" );
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
		
		//Demande les informations de connextion
		System.out.println( "---------------------------------" );
		System.out.println( "Veuillez entrer votre ");
		System.out.println( "" );
		System.out.println( "nom: ");nomAbonne = demandeString();
		System.out.println( "code secret: ");codeSecretAbonne = demandeString();
		System.out.println( "" );
		
		//Teste nom et codeSecret
		abonneCourant = new Abonne(); // Crée une instance Abonne "vide"
		abonneCourant.loadAbonne(nomAbonne,codeSecretAbonne); // LOAD les valeur de l'abonneCourant
		//ECHEC mauvais nom ou codeSecret
		if (abonneCourant.getNom() == null) {
			System.out.println("Echec de la connexion");
			Interface(0); //Retour home page 0
		}
		//SUCCES
		else {
			System.out.println( "Connexion réussie" );
			if (flag20 == true) {
				Interface(20); //Vers page emprunt vélo
			}
			else {
				if (flag30 == true) Interface(30); //Vers page remise vélo
				else Interface(10);	//Vers page home abonné
			}
		}
	}

	/*
	 * Page de création d'un d'abonné
	 */
	public static void InterfaceP12() {
		System.out.println( "---------------------------------" );
		abonneCourant = new Abonne(); // Crée une instance Abonne "vide"
		abonneCourant.SaveNewAbonne(); // Crée et enregistre le nouvelle abonèe
		Interface(10);
	}
	
	/*
	 * Affiche les informations de l'abonné
	 */
	public static void InterfaceP13() {
		System.out.println( "---------------------------------" );
		abonneCourant.showProfil(); // Affiche le profil de l'abonne courant
		System.out.println( "" );
		System.out.println( "(1)->Retourner au menu" );
		System.out.println( "(2)->Editer le profil" );
	}
	
	/*
	 * Edite les informations de l'abonné
	 */
	public static void InterfaceP14() {
		abonneCourant.editProfil();
		attentAppuieTouche();
		Interface(10);
	}
	
	/*
	 * Affiche les stations VPlus et VMoins
	 */
	public static void InterfaceP15() {
		System.out.println( "---------------------------------" );
		System.out.println( "Liste des stations VPlus" );
		showSationsVPlus();
		System.out.println( "" );
		System.out.println( "Liste des stations VMoins" );
		showSationsVMoins();
		
		attentAppuieTouche();
		Interface(10);
	}
	
	/*
	 * Affiche l'historique des locations
	 */
	public static void InterfaceP16() {
		System.out.println( "---------------------------------" );
		abonneCourant.showHistorique();
		
		attentAppuieTouche();
		Interface(10);
	}
	
	/* 
	 * Redirection de connexion vers l'emprunt velo
	 */
	public static void InterfaceP18() {
		flag20 = true;
		Interface(11);
	}
	
	/*
	 * Redirection de connexion vers la remise velo
	 */
	public static void InterfaceP19() {
		flag30 = true; 
		Interface(11);
	}

	/*
	 * Page home emprunt velo (location)
	 */
	public static void InterfaceP20() {
		//Créer une nouvelle instance de location vide
		locationCourante = new Location();
		locationCourante.editLocationAbonne(abonneCourant.getCB(),abonneCourant.getAbonneId());
		Interface(23);
	}
	
	/*
	 * Page emprunt vélo (sans abonnement)
	 */
	public static void InterfaceP21() {
		System.out.println( "---------------------------------" );
		System.out.println( "Emprunter des vélos:");
		System.out.println( "(1)->Vous connecter");
		System.out.println( "(2)->Sans connexion" );
	}
	
	/*
	 * Page emprunt velo (génération code secret)
	 */
	public static void InterfaceP22() {
		System.out.println( "---------------------------------" );
		System.out.println( "Veuillez entrer votre numéro de CB: " );
		String numCB = demandeCarteBancaire();
		String codeSecret = genererCodeSecret();
		locationCourante.editLocationAnonyme(numCB, codeSecret);
		System.out.println( "Votre code secret est: "+codeSecret);
		attentAppuieTouche();
		Interface(23);	
	}
	
	/*
	 * Page home emprunt vélo (Vélo)
	 */
	public static void InterfaceP23() {
		System.out.println( "---------------------------------" );
		System.out.println("Quel modèle de vélo voulez-vous");
		System.out.println( "(1)->Manuel" );
		System.out.println( "(2)->Electrique" );
		System.out.println( "(3)->Annuler saisie" );
	}
	
	/*
	 * Page de vérification de l'existence d'un vélo model Manuel
	 */
	public static void InterfaceP24() {
		int idBornette = stationCourante.veloExiste(Model.Manuel);
		bornetteCourante = new Bornette();
		bornetteCourante.loadBornette(idBornette);
		if(bornetteCourante == null) {
			System.out.println("Erreur, ce modèle est indisponible");
			Interface(23);
		}
		else {
			veloCourant = new Velo();
			veloCourant.loadVelo(bornetteCourante.getIdBornette());
			Interface(26);
		}
	}
	
	/*
	 * Page de vérification de l'existence d'un vélo model Electrique
	 */
	public static void InterfaceP25() {
		int idBornette = stationCourante.veloExiste(Model.Electrique);
		bornetteCourante = new Bornette();
		bornetteCourante.loadBornette(idBornette);
		if(bornetteCourante == null) {
			System.out.println("Erreur, ce modèle est indisponible");
			Interface(23);
		}
		else {
			veloCourant = new Velo();
			veloCourant.loadVelo(bornetteCourante.getIdBornette());
			Interface(26);
		}
	}
	
		
	public static void InterfaceP26() {
		System.out.println( "---------------------------------" );
		locationCourante.editAjouterUnVelo(veloCourant);
		System.out.println( "Prenez le velo n°"+veloCourant.getIdVelo()+ " à la bornette"+bornetteCourante.getIdBornette());
		attentAppuieTouche();
		Interface(23);
	}
	
	/*
	 * Fin de l'emprunt vélo
	 */
	public static void InterfaceP27() {
		System.out.println( "---------------------------------" );
		System.out.println( "Bonne Route avec vePick");
		attentAppuieTouche();
		Interface(0);	
	}
	
	/*
	 * Page Remise vélo
	 */
	public static void InterfaceP30() {
		System.out.println( "---------------------------------" );
		System.out.println( "Bonjour "+abonneCourant.getNom()+" "+abonneCourant.getPrenom());
		if (abonneCourant.calculNbLocation() == 1) { 
			locationCourante = abonneCourant.getLocation(0);
			Interface(34);
		}
		else Interface(33);
	}
	
	/*
	 * Page Remise sans Abonnement
	 */
	public static void InterfaceP31() {
		System.out.println( "---------------------------------" );
		System.out.println( "Emprunter des vélos:");
		System.out.println( "(1)->Vous connecter");
		System.out.println( "(2)->Sans connexion" );
	}
	
	//Pages Code secret
	public static void InterfaceP32() {
		System.out.println( "---------------------------------" );
		System.out.println( "Veuillez entrer votre code secret:");
		System.out.println( "Code secret:");
		locationCourante = new Location();
		String codeSecret = demandeCodeSecret();
		locationCourante.loadLocationClient(codeSecret);
		if (locationCourante == null) {
			System.out.println( "Code secret Invalide");
			attentAppuieTouche();
			Interface(0);
		}
		else {
			Interface(34);
		}
		
	}
	
	//Choix de location
	public static void InterfaceP33() {
		abonneCourant.showLocation();
		System.out.println( "---------------------------------" );
		System.out.println( "Veuillez choisir votre location:");
		int nbLocations = abonneCourant.calculNbLocation();
		int indexLocation = demandeInt(1,nbLocations);
		locationCourante = abonneCourant.getLocation(indexLocation-1);
		Interface(34);
	}
		
	//Remise de velo
	public static void InterfaceP34() {
		System.out.println( "---------------------------------" );
		System.out.println( "Nombre de velo à rendre: "+locationCourante.calculNbVelo());
		veloCourant = new Velo();
		veloCourant.loadVeloFirstFromLocation(locationCourante.getIdLocation());
		int id = veloCourant.getIdVelo();
		Model model = veloCourant.getModeleVelo();
		int idBornette = stationCourante.getFirstIdBornetteLibre();
		bornetteCourante = new Bornette();
		bornetteCourante.loadBornette(idBornette);
		if(bornetteCourante == null) {
			System.out.println("Plus de place disponible, veuillez trouver une autre station");
			Interface(36);
		}
		else
		{
			System.out.println( "Rendre le velo N°"+id+"de model: "+model+" à la bornette N° "+idBornette);
			System.out.println( "(1)->Confirmer la remise du velo");
			System.out.println( "(2)->Arrêter");
		}
	}

	//Valider Rendus Velo
	public static void InterfaceP35() {
		System.out.println( "---------------------------------" );
		locationCourante.editVeloRendu(veloCourant.getIdVelo(),bornetteCourante.getIdBornette());
		veloCourant = null;
		bornetteCourante = null;
		Interface(34);
	}
		
	//Stop Locations
	public static void InterfaceP36() {
		if (abonneCourant.calculNbLocation() > 0) {
			System.out.println( "---------------------------------" );
			locationCourante.editSplitLocation();
			locationCourante.calculPrixLocation();
			System.out.println( "Votre location vous a coûté:"+locationCourante.getPrix()+"€");
			System.out.println( "Merci d'avoir utilisé Vé Pick");
		}
	}
	
	
	//Page d'erreur
	public static void 	InterfaceErr() {
		System.out.println( "---------------------------------" );
		System.out.println( "Page 404 Not found" );
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
			case 16: InterfaceP16();break;
			case 18: InterfaceP18();break;
			case 19: InterfaceP19();break;
			
			case 20: InterfaceP20();break;
			case 21: InterfaceP21();break;
			case 22: InterfaceP22();break;
			case 23: InterfaceP23();break;
			case 24: InterfaceP24();break;
			case 25: InterfaceP25();break;
			case 26: InterfaceP26();break;
			case 27: InterfaceP27();break;
			
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
		System.out.println( "" );
		int nextIdPage = -1;
		while (nextIdPage < 0) {
			nextIdPage = choixMenu(idPage);
		}
		System.out.println( "---------------------------------\n" );
		Interface(nextIdPage);
	}
}

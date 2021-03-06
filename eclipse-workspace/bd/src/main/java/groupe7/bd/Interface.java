package groupe7.bd;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


import groupe7.bd.model.*;
import groupe7.bd.utils.TheConnection;

public class Interface {
	
	public static Station stationCourante;
	public static Bornette bornetteCourante;
	public static Velo veloCourant;
	public static Location locationCourante;
	public static Client clientCourant;
	public static Abonne abonneCourant;
	public static LocationsDetail sousLocationCourant;
	public static boolean flag20;
	public static boolean flag30;
	
	//Tableau des idPages
	private static int tabIdPage[][] ={
			//{idPage,idPageSuivant(1->),idPageSuivant(2->),...}
			{0,11,12,21,31,40,-1,-1,-1,-1},
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
		public void showSationsVPlus() {
			try {
				Connection conn=TheConnection.getInstance();
				java.sql.Statement requete;
			
				requete = conn.createStatement();
				ResultSet resultat = requete.executeQuery("SELECT * FROM Station WHERE statu = 'vplus'");
				int index = 1;
				while(resultat.next()){
					System.out.println("\tStation N°"+resultat.getString("idStation")+" "+resultat.getString("adresse"));
					index++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * Recherche dans la base de donnèe toutes les station Vmoins
		 * et les affiches
		 */
		public void showSationsVMoins() {
			try {
				Connection conn=TheConnection.getInstance();
				java.sql.Statement requete;
			
				requete = conn.createStatement();
				ResultSet resultat = requete.executeQuery("SELECT * FROM Station WHERE statu = 'vmoins'");
				int index = 1;
				while(resultat.next()){
					System.out.println("\tStation N°"+resultat.getString("idStation")+" "+resultat.getString("adresse"));
					index++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * [SQL]
		 * Interroge la base de donnèe pour récupèrer toutes les stations.
		 * Affiche les résultat sous la forme:
		 * 	(1)-> Station n° /idStaion/: /adresse/
		 *  (2)-> ... 
		 */
		public void showAllStation() {
			try {
				Connection conn=TheConnection.getInstance();
				java.sql.Statement requete;
			
				requete = conn.createStatement();
				ResultSet resultat = requete.executeQuery("SELECT * FROM Station");
				int index = 1;
				while(resultat.next()){
					System.out.println("("+index+")-> Station N°"+resultat.getString("idStation")+" "+resultat.getString("adresse"));
					index++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		/*
		 * [SQL]
		 * Interroge la base de donnèe pour obetenir le nombre de stations
		 * et le retourne
		 */
		public static int calculNombreStation() {
			try {
				Connection conn=TheConnection.getInstance();
				java.sql.Statement requete;
			
				requete = conn.createStatement();
				ResultSet resultat = requete.executeQuery("SELECT COUNT(*) AS NbStation FROM Station");
				resultat.next();
				int nbStation = resultat.getInt("NbStation");
				return nbStation;
			} catch (SQLException e) {
				e.printStackTrace();
				return 0;
			}
			
		}
		
	/*
	* Convertie une date JAVA au format date SQL
	*/
	public static String convDateJAVAToSQL(Date dateJava) {
		try{
			return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(dateJava);
		}
		catch(Exception e){
			return null;
		}
	}
	
	/*
	 * Convertie une date SQL au format date JAVA
	*/
	public static Date convDateSQLToJAVA(String dateStr) {
		try{
			return new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(dateStr);
		}
        catch(Exception e){
			return null;
		}
	}
	
	/*
	 * Convertie une chaîne de caractère de format (dd/MM/yyyy HH:mm:ss.SS) en une date
	 * et la retourne.
	*/
	public static Date dateStrConv(String dateStr) {
		try{
			return new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
		}
        catch(Exception e){
			return null;
        }
	}
		
	
	/*
	 * Retourne un entier en un string de length taille
	 */
	public static String convIntStr(int nbCodeS,int taille) {
		String codeSecret = Integer.toString(nbCodeS);
		//Plus grand
		while (codeSecret.length() < taille) {
			codeSecret = "0"+codeSecret;
		}
		return codeSecret;
	}
		
	/*
	 * Génére un code secret aléatoire pour les utilisateurs anonymes (sans abonnement)
	 */
	public static String genererCodeSecret() {
		int nbCodeS = 1 + (int) (Math.random() * 9998);
		String codeSecret = convIntStr(nbCodeS,4);
		return codeSecret;
	}
	
	/*
	 * Attend que l'utilisateur appuie sur n'importe quelle touche
	 */
	public static void attentAppuieTouche() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Appuyer sur une touche pour continuer");
		scanner.nextLine();
		
		//scanner.close();
	}
	
	/*
	 * Demande à l'utilisateur d'entrer une chaîne
	 * de caractère et la retourne. 
	*/
	public static String demandeString() {
		Scanner scanner = new Scanner(System.in);
		String str = "";
		
		while(str.isEmpty() == true){
			//System.out.println("Veuillez saisir une donnee non-vide!");
			str = scanner.nextLine();
		}
		//scanner.close();
		return str;
	}
	
	
	/*
	 * Demande à l'utilisateur d'entrée un entier compris
	 * entre min et max inclus et le retourne
	*/
	public static int demandeInt(int min,int max) {
		java.util.Scanner entree =   new java.util.Scanner(System.in);
		int entier = min - 1;

		while(entier < min || entier>max){
			try{
				System.out.println("Veuillez saisir un numero entre "+ min +" et " +max);
				entier = entree.nextInt();
				if (entier < min || entier>max) System.out.println( "!Saisie invalide!\n");
			}
			catch (InputMismatchException e) {
				 System.out.println( "!Saisie invalide!\n");
				 entier = demandeInt(min, max);
				 //entree.close();
				 return entier;
			}
			
			
		}
		//entree.close();
		return entier;
	}
	
	/*
	 * Demande à l'utilisateur d'entrée un sexe
	 * H (homme) F(femme) et le retourne
	*/
	public static Sexe demandeSexe() {
		Scanner scanner = new Scanner(System.in);
		String sexe = "";

		while(sexe.equals("h") == false && sexe.equals("f") == false){
			System.out.println("Veuillez saisir H (pour Homme) ou F (pour Femme)");
			sexe = scanner.nextLine();
		}
		//scanner.close();
		return Sexe.valueOf(sexe);
	}
	
	/*
	 * Demande à l'utilisateur d'entrer une date au format (dd/MM/yyyy HH:mm:ss.SS)
	 * et la retourne comme une date.
	 * Cf: dateStrConv() pour converir un String en Date
	 * 		ATTENTION Gérer l'exception
	*/
	public static Date demandeDate() {
		Date date =  null;
		
		Scanner scanner = new Scanner(System.in);
		String str;
		
		while(date ==  null){
			//System.out.println("Veuillez saisir une date sous la forme JJ/MM/AAAA");
			str = scanner.nextLine();
			date =  dateStrConv(str+" 00:00:00.00");
		}
		//scanner.close();
		return date;
	}
	
	//demandeCodeSecret() et demandeCarteBancaire() peuvent être fussionnées
	//en 1 fonction demandeSuiteDeChiffre(int tailleMax);
	//-----------------------------------------------------------------------------
	/*
	 * Demande à l'utilisateur d'entrer un code
	 * secret et le retourne. 
	*/
	public static String demandeCodeSecret() {
		String codeSecret = demandeString();
		//Tester si codeSecret est consitué que de chiffre
		// NON PRIORITAIRE
		return codeSecret;
	}
	
	/*
	 * Demande à l'utilisateur d'entrer un numéro de carte
	 * bancaire et le retourne. 
	*/
	public static String demandeCarteBancaire() {
		String carteBancaire = demandeString();
		//Tester si demandeCarteBancaire est consitué que de chiffre
		// NON PRIORITAIRE
		return carteBancaire;
	}
	//-----------------------------------------------------------------------------
	
	
	/*
	 * Demande à l'utilisateur d'entrer un nombre correspondant
	 * à son choix du menu et l'id de la page suivante.
	*/
	public static int choixMenu(int idPage){
		int idChoix = 0,idPageNext = -1,index = 0,index2 ,limite = 1;
		
		//index de l'id page
		while ((tabIdPage[index][0] != idPage) && (index < tabIdPage.length)) {
			index++;
		}
		
		//Erreur
		if (index == tabIdPage.length) {
			System.out.println( "!--Erreur tableau de redirection manquan--!\n");
		}
		
		//choix du menu de 1 à limite
		while ((tabIdPage[index][limite] != -1) && (index < 10)) {
			limite++;
		}
		index2 = demandeInt(1,limite-1);
		idPageNext = tabIdPage[index][index2];
		
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
	public  void InterfaceP0() {
		System.out.println( "---------------------------------" );
		//Choix de la station
		System.out.println( "A quel sations êtes vous ?");
		System.out.println( "" );
		showAllStation(); // Affiche les stations
		System.out.println( "" );
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
		System.out.println( "(5)->Affichage Table" );
	}
	
	/*
	 * Page Accueil abonné
	 */
	public  void InterfaceP10() {
		//Affichage de l'écran
		System.out.println( "---------------------------------" );
		System.out.println( "Bonjour! "+abonneCourant.getPrenom()+" "+abonneCourant.getNom());
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
	public  void InterfaceP11() {
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
		clientCourant = new Client(abonneCourant.getIdClient(),abonneCourant.getNumeroCarteBancaire());
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
	public  void InterfaceP12() {
		System.out.println( "---------------------------------" );
		abonneCourant = new Abonne(); // Crée une instance Abonne "vide"
		abonneCourant.SaveNewAbonne(); // Crée et enregistre le nouvelle abonèe
		clientCourant = new Client(abonneCourant.getIdClient(),abonneCourant.getNumeroCarteBancaire());
		Interface(10);
	}
	
	/*
	 * Affiche les informations de l'abonné
	 */
	public  void InterfaceP13() {
		System.out.println( "---------------------------------" );
		abonneCourant.showProfil(); // Affiche le profil de l'abonne courant
		System.out.println( "" );
		System.out.println( "(1)->Retourner au menu" );
		System.out.println( "(2)->Editer le profil" );
	}
	
	/*
	 * Edite les informations de l'abonné
	 */
	public  void InterfaceP14() {
		abonneCourant.editProfil();
		attentAppuieTouche();
		Interface(10);
	}
	
	/*
	 * Affiche les stations VPlus et VMoins
	 */
	public  void InterfaceP15() {
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
	public  void InterfaceP16() {
		System.out.println( "---------------------------------" );
		clientCourant.showHistorique();
		
		attentAppuieTouche();
		Interface(10);
	}
	
	/* 
	 * Redirection de connexion vers l'emprunt velo
	 */
	public  void InterfaceP18() {
		flag20 = true;
		Interface(11);
	}
	
	/*
	 * Redirection de connexion vers la remise velo
	 */
	public  void InterfaceP19() {
		flag30 = true; 
		Interface(11);
	}

	/*
	 * Page home emprunt velo (location)
	 */
	public  void InterfaceP20() {
		//Créer une nouvelle instance de location vide
		locationCourante = new Location();
		locationCourante.editLocationAbonne(abonneCourant.getIdClient());
		Interface(23);
	}
	
	/*
	 * Page emprunt vélo (sans abonnement)
	 */
	public  void InterfaceP21() {
		System.out.println( "---------------------------------" );
		System.out.println( "Emprunter des vélos:");
		System.out.println( "(1)->Vous connecter");
		System.out.println( "(2)->Sans connexion" );
	}
	
	/*
	 * Page emprunt velo (génération code secret)
	 */
	public  void InterfaceP22() {
		System.out.println( "---------------------------------" );
		System.out.println( "Veuillez entrer votre numéro de CB: " );
		String numCB = demandeCarteBancaire();
		String codeSecret = genererCodeSecret();
		System.out.println( "Votre code secret est: "+codeSecret);

		locationCourante = new Location();
		locationCourante.editLocationAnonyme(numCB, codeSecret);
		attentAppuieTouche();
		Interface(23);	
	}
	
	/*
	 * Page home emprunt vélo (Vélo)
	 */
	public  void InterfaceP23() {
		System.out.println( "---------------------------------" );
		System.out.println("Quel modèle de vélo voulez-vous");
		System.out.println( "(1)->Manuel" );
		System.out.println( "(2)->Electrique" );
		System.out.println( "(3)->Annuler saisie" );
	}
	
	/*
	 * Page de vérification de l'existence d'un vélo model Manuel
	 */
	public  void InterfaceP24() {
		int idBornette = stationCourante.veloExiste(Model.manuel);
		
		bornetteCourante = new Bornette();
		bornetteCourante.loadBornette(idBornette);
		if(bornetteCourante == null) {
			System.out.println("Erreur, ce modèle est indisponible");
			Interface(23);
		}
		else {
			veloCourant = new Velo();
			veloCourant.loadVeloFromBornette(bornetteCourante.getIdBornette());
			Interface(26);
		}
	}
	
	/*
	 * Page de vérification de l'existence d'un vélo model Electrique
	 */
	public  void InterfaceP25() {
		int idBornette = stationCourante.veloExiste(Model.electrique);
		bornetteCourante = new Bornette();
		bornetteCourante.loadBornette(idBornette);
		if(bornetteCourante == null) {
			System.out.println("Erreur, ce modèle est indisponible");
			Interface(23);
		}
		else {
			veloCourant = new Velo();
			veloCourant.loadVeloFromBornette(bornetteCourante.getIdBornette());
			
			Interface(26);
		}
	}
	
		
	public  void InterfaceP26() {
		System.out.println( "---------------------------------" );
		veloCourant.setIdBornette(0);

		sousLocationCourant = new LocationsDetail();
		sousLocationCourant.saveLocationDetail();
		locationCourante.editLocationStart(sousLocationCourant);
		
		System.out.println( "Prenez le velo n°"+veloCourant.getIdVelo()+ " à la bornette"+bornetteCourante.getIdBornette());
		attentAppuieTouche();
		Interface(23);
	}
	
	/*
	 * Fin de l'emprunt vélo
	 */
	public  void InterfaceP27() {
		System.out.println( "---------------------------------" );
		System.out.println( "Bonne Route avec vePick");
		attentAppuieTouche();
		Interface(0);	
	}
	
	/*
	 * Page Remise vélo
	 */
	public  void InterfaceP30() {
		System.out.println( "---------------------------------" );
		System.out.println( "Bonjour "+abonneCourant.getNom()+" "+abonneCourant.getPrenom());
		if (clientCourant.calculNbLocationEnCours() == 1) { 
			locationCourante = clientCourant.getLocation(1);
			Interface(34);
		}
		else Interface(33);
	}
	
	/*
	 * Page Remise sans Abonnement
	 */
	public  void InterfaceP31() {
		System.out.println( "---------------------------------" );
		System.out.println( "Dépot des vélos:");
		System.out.println( "(1)->Vous connecter");
		System.out.println( "(2)->Sans connexion" );
	}
	
	//Pages Code secret
	public  void InterfaceP32() {
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
	public  void InterfaceP33() {
		clientCourant.showEnCours();
		System.out.println( "---------------------------------" );
		System.out.println( "Veuillez choisir votre location:");
		int nbLocations = clientCourant.calculNbLocationEnCours();
		int indexLocation = demandeInt(1,nbLocations);
		locationCourante =  clientCourant.getLocation(indexLocation);
		sousLocationCourant = new LocationsDetail(0);
		sousLocationCourant = locationCourante.getVelos().get(0);
		
		Interface(34);
	}
		
	//Remise de velo
	public  void InterfaceP34() {
		sousLocationCourant = new LocationsDetail(0);
		sousLocationCourant = locationCourante.getVelos().get(0);
		System.out.println( "---------------------------------" );
		System.out.println( "Nombre de velo à rendre: "+locationCourante.calculNbVelo());
		veloCourant = new Velo();
		veloCourant.loadVeloFirstFromLocation(locationCourante.getIdLocations());
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
	public  void InterfaceP35() {
		System.out.println( "---------------------------------" );
		
		locationCourante.editLocationEnd(this.sousLocationCourant);
		sousLocationCourant = null;
		veloCourant = null;
		bornetteCourante = null;
		if (locationCourante.calculNbVelo() > 0) Interface(34);
		else {
			locationCourante.editLocationsEnd();
			InterfaceP36();
		}
	}
		
	//Stop Locations
	public  void InterfaceP36() {
		System.out.println( "---------------------------------" );
		locationCourante.calculPrixLocations();
		System.out.println( "Votre location vous a coûté:"+locationCourante.getPrix()+"€");
		System.out.println( "Merci d'avoir utilisé Vé Pick");
		locationCourante = null;
		sousLocationCourant = null;
		veloCourant = null;
		bornetteCourante = null;
		Interface(0);
		
	}
	
	//Affichage Table
	public  void InterfaceP40(){
		try {
			//Sql commande
			Connection conn=TheConnection.getInstance();
			java.sql.Statement requete;
			String sqlCommad = "SELECT * FROM Station";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			System.out.println("+STATION------------------------------------------------------------------------------------------+");
			System.out.println("|+idStation+\t+adresse+\t+statu+\t|");
			while (resultat.next()) {
				System.out.println("|"+resultat.getString("idStation")+"\t"+resultat.getString("adresse")+"\t"+resultat.getString("statu")+"\t|");
			}
			System.out.println("+---------------------------------------------------------------------------------------------+");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			//Sql commande
			Connection conn=TheConnection.getInstance();
			java.sql.Statement requete;
			String sqlCommad = "SELECT * FROM Bornette";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			System.out.println("+Bornette-----------------------------------------------------------------------------------------+");
			System.out.println("|+idBornette+\t+idStation+\t+etatBornette+\t|");
			while (resultat.next()) {
				System.out.println("|"+resultat.getString("idBornette")+"\t"+resultat.getString("idStation")+"\t"+resultat.getString("etatBornette")+"\t|");
			}
			System.out.println("+---------------------------------------------------------------------------------------------+");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			//Sql commande
			Connection conn=TheConnection.getInstance();
			java.sql.Statement requete;
			String sqlCommad = "SELECT * FROM Velo";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			System.out.println("+Velo------------------------------------------------------------------------------------------+");
			System.out.println("|+idVelo+\t+idBornette+\t+etatBornette+\t+dateMenS\t|");
			while (resultat.next()) {
				System.out.println("|"+resultat.getString("idVelo")+"\t"+resultat.getString("idBornette")+"\t"+resultat.getString("modelVelo")+"\t"+resultat.getString("dateMenS")+"\t|");
			}
			System.out.println("+---------------------------------------------------------------------------------------------+");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			//Sql commande
			Connection conn=TheConnection.getInstance();
			java.sql.Statement requete;
			String sqlCommad = "SELECT * FROM Client";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			System.out.println("+Client------------------------------------------------------------------------------------------+");
			System.out.println("|+idClient+\t+numCB+\t|");
			while (resultat.next()) {
				System.out.println("|"+resultat.getString("idClient")+"\t"+resultat.getString("numCB")+"\t|");
			}
			System.out.println("+---------------------------------------------------------------------------------------------+");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			//Sql commande
			Connection conn=TheConnection.getInstance();
			java.sql.Statement requete;
			String sqlCommad = "SELECT * FROM Abonne";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			System.out.println("+Abonne------------------------------------------------------------------------------------------+");
			System.out.println("|+idAbonne+\t+idClient+\t+nom+\t+dateMenS\t|");
			System.out.println("|+dateNaissance+\t+idClient+\t+dateAbonnement+\t+codeSecret\t|");
			
			while (resultat.next()) {
				System.out.println("|"+resultat.getString("idAbonne")+"\t"+resultat.getString("idClient")+"\t"+resultat.getString("nom")+"\t"+resultat.getString("prenom")+"\t|");
				System.out.println("|"+resultat.getString("dateNaissance")+"\t"+resultat.getString("sexe")+"\t"+resultat.getString("dateAbonnement")+"\t"+resultat.getString("codeSecret")+"\t|");
			}
			System.out.println("+---------------------------------------------------------------------------------------------+");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			//Sql commande
			Connection conn=TheConnection.getInstance();
			java.sql.Statement requete;
			String sqlCommad = "SELECT * FROM Locations";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			System.out.println("+Locations------------------------------------------------------------------------------------------+");
			System.out.println("|+idLocations+\t+idClient+\t+prix+\t+codeSecret\t+fini\t|");
			while (resultat.next()) {
				System.out.println("|"+resultat.getString("idLocations")+"\t"+resultat.getString("idClient")+"\t"+resultat.getString("prix")+"\t"+resultat.getString("codeSecret")+"\t"+resultat.getString("fini")+"\t|");
			}
			System.out.println("+---------------------------------------------------------------------------------------------+");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			//Sql commande
			Connection conn=TheConnection.getInstance();
			java.sql.Statement requete;
			String sqlCommad = "SELECT * FROM LocationsDetail";
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			System.out.println("+LocationsDetail------------------------------------------------------------------------------------------+");
			System.out.println("|+idLocationsDetail+\t+idLocations+\t+idVelo+\t+debut\t|");
			System.out.println("|+fin+\t+depart+\t+arrivee+\t+prix\t+fini\t|");
			
			while (resultat.next()) {
				System.out.println("|"+resultat.getString("idLocationsDetail")+"\t"+resultat.getString("idLocations")+"\t"+resultat.getString("idVelo")+"\t"+resultat.getString("debut")+"\t|");
				System.out.println("|"+resultat.getString("fin")+"\t"+resultat.getString("depart")+"\t"+resultat.getString("arrivee")+"\t"+resultat.getString("prix")+"\t"+resultat.getString("fini")+"\t|");
			}
			System.out.println("+---------------------------------------------------------------------------------------------+");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		Interface(0);
	}
	
	
	
	//Page d'erreur
	public void 	InterfaceErr() {
		System.out.println( "---------------------------------" );
		System.out.println( "Page 404 Not found" );
	}

	public void Interface(int idPage) {
		
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
				
			case 40: InterfaceP40();break;
			
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

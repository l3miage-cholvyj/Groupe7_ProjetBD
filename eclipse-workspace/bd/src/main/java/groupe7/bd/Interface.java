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
	
	//Attend que l'utilisateur appuye sur n'importe quel touche
	public static String genererCodeSecret() {
		//TODO
		return "111111111";
	}
	
	//Attend que l'utilisateur appuye sur n'importe quel touche
	public static void attentAppuyeTouche() {
		//TODO
	}
	
	/*
	 * Demande à l'utilisateur d'entrée une chaîne
	 * de caractère et la retourne. 
	*/
	public static String demandeString() {
		//TODO
		return "nul";
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
	 * Convertie une chaîne de caractère de format (JJ/MM/AAAA)
	 * de caractère et la retourne. 
	*/
	public static LocalDate dateStrConv(String dateStr) {
		DateTimeFormatter JEFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	    // parsing the string to convert it into date
	    LocalDate local_date = LocalDate.parse(dateStr, JEFormatter);
	    
	    return local_date;
	}
	
	/*
	 * Demande à l'utilisateur d'entrée une date
	 * de caractère et la retourne. 
	*/
	public static LocalDate demandeDate() {
		LocalDate date =  dateStrConv("21/12/2021");
		// TODO
		return date;
	}
	
	/*
	 * Demande à l'utilisateur d'entrée un code
	 * secret et le retourne. 
	*/
	public static int demandeCodeSecret() {
		return 1234;// TODO
	}
	
	/*
	 * Demande à l'utilisateur d'entrée un compte 
	 * bancaire et le retourne. 
	*/
	public static String demandeCompteBancaire() {
		return "155895124569475";// TODO
	}
	
	/*
	 * Demande à l'utilisateur d'entrée un nombre correspondant
	 * à son choix du menu et l'id de la page suivante.
	*/
	public static int choixMenu(int idPage){
		int idChoix,idPageNext = -1;
		java.util.Scanner entree =   new java.util.Scanner(System.in);
		
		System.out.println( "Entrer votre choix: " );
		
		//System.out.println(idPage);
		
		while (idPageNext < 0) {
			try {
				idChoix = entree.nextInt();
				idPageNext = tabIdPage[idPage][idChoix];
				if (idPageNext == -1) System.out.println( "!--Choix invalid--!\n Entrer votre choix: ");
			}
			catch (InputMismatchException e) {
				 System.out.println( "!--Choix invalid--!\n");
				 idPageNext = choixMenu(idPage);
			}
		}
		
		return idPageNext;
		
	}
	
	/*
	 * Page 0X -> Gestion non-abonnée
	 * Page 1X -> Gestion abonnée
	 * Page 2X -> Prise de vélo
	 * Page 3X -> Retour de vélo
	 * Page 4X -> Débug
	 * */
	
	//Page Home principale
	public static void InterfaceP0() {
		System.out.println( "---------------------------------" );
		System.out.println( "Bonjour! Bienvenue sur veli pack" );
		System.out.println( "Que voullez vous faire?" );
		System.out.println( "(1)->Se connecter" );
		System.out.println( "(2)->Créer un compte" );
		System.out.println( "(3)->Prendre un vélo" );
		System.out.println( "(4)->Rendre un vélo" );
		System.out.println( "" );
	}
	
	//Page Acceuile abonnée
	public static void InterfaceP10() {
		
		System.out.println( "---------------------------------" );
		System.out.println( "Bonjour! "+abonneCourant.getNom()+""+abonneCourant.getPrenom());
		System.out.println( "Que voullez vous faire?" );
		
		System.out.println( "(1)->Information compte" );
		System.out.println( "(2)->Prendre un vélo" );
		System.out.println( "(3)->Rendre un vélo" );
		System.out.println( "(4)->Historique des locations" );
		System.out.println( "(5)->Afficher Stations Vplus Vmoins" );
		System.out.println( "(6)->Se déconnecter" );
	}
	
	//Page de connection
	public static void InterfaceP11() {
		String nomAbonne,codeSecretAbonne;
		
		System.out.println( "---------------------------------" );
		System.out.println( "Veuillez entrer votre ");
		System.out.println( "nom: ");nomAbonne = demandeString();
		System.out.println( "code secret: ");codeSecretAbonne = demandeString();
		
		//Lance une connection
		abonneCourant.connectionAbonne(nomAbonne,codeSecretAbonne);
		if (abonneCourant.getNom() == null) {
			System.out.println( "Echec de la connection" );
			Interface(0);
		}
		else {
			System.out.println( "Connection réussi" );
			if (flag20 == true) Interface(20);
			else {
				if (flag30 == true) Interface(30);
				else Interface(10);	
			}
		}
	}

	//Page de création d'un d'abonné
	public static void InterfaceP12() {
		
		abonneCourant.newAbonne();		
		Interface(10);
	}
	
	//Affiche les information de l'abonné
	public static void InterfaceP13() {
		abonneCourant.getInformation();
		System.out.println( "" );
		System.out.println( "(1)->Retourner au menu" );
		System.out.println( "(2)->Editer le profil" );
	}
	
	//Edite les information de l'abonné
	public static void InterfaceP14() {
		abonneCourant.Edit();
		attentAppuyeTouche();
		Interface(10);
	}
	
	//Affiche les stations VPlus et VMoins
	public static void InterfaceP15() {
		System.out.println( "Liste des stations VPlus" );
		stationCourante.ShowSationsVPlus();
		System.out.println( "Liste des stations VMoins" );
		stationCourante.ShowSationsVMoins();
		
		attentAppuyeTouche();
		Interface(10);
	}

	//Page home emprunt velo (location)
	public static void InterfaceP20() {
		//Crée une nouvelle instance de location pour l'abonneCourant
		abonneCourant.newLocation();
		Interface(23);
	}
	
	//Page emprunt velo (sans abonnement)
	public static void InterfaceP21() {
		System.out.println( "Emprunter des velos:");
		System.out.println( "(1)->Vous connectez");
		System.out.println( "(2)->Sans connextion" );
	}
	
	//Page emprunt velo (génération code secret)
	public static void InterfaceP22() {
		String codeSecret = genererCodeSecret();
		abonneCourant.newLocation(codeSecret);
		System.out.println( "Votre code secret est: "+codeSecret);
		attentAppuyeTouche();
		Interface(23);	
	}
	
	//Page home emprunt velo (Velo)
	public static void InterfaceP23() {
		locationCourante.AjouterUnVelo();
		System.out.println( "Prener le velo n° idVelo à la bornette id bornette" );
		System.out.println( "" );
		//TODO
	}
	
	//Pages Remise velo
	public static void InterfaceP30() {
		//TODO
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
			//case 1: InterfaceP1();break;
			case 11: InterfaceP11();break;
			case 12: InterfaceP12();break;
			case 20: InterfaceP20();break;
			case 30: InterfaceP30();break;
			case 10: InterfaceP10();break;
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

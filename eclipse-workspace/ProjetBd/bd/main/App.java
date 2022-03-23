
package main;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import dao.CageDAO;
import dao.GardienDAO;
import dao.AnimalDAO;
import modele.Cage;
import modele.Gardien;
import modele.Animal;
import modele.Velo;
import utils.LectureClavier;
import utils.TheConnection;

public class App {

	public static void main(String args[]) {

		try {
			
			
			System.out.println("bonjour ");
			affichageAnimaux();

			// traitement d'exception
		} catch (SQLException e) {
			TheConnection.close();
			System.err.println("failed");
			System.out.println("Affichage de la pile d'erreur");
			e.printStackTrace(System.err);
			System.out.println("Affichage du message d'erreur");
			System.out.println(e.getMessage());
			System.out.println("Affichage du code d'erreur");
			System.out.println(e.getErrorCode());	    
		}
	}

	/**
	 * Afficher la liste des animaux avec leur numéro de cage.
	 * @throws SQLException 
	 */
	private static void affichageAnimaux() throws SQLException{
	  /*Connextion à la base*/
	  Connection conn=TheConnection.getInstance();
	  java.sql.Statement requete = conn.createStatement();
	 ResultSet resultat = requete.executeQuery("SELECT * from Station");
while(resultat.next()){
System.out.println("id: " + resultat.getInt("idStation"));
System.out.println("nom: " + resultat.getString("adresse"));
System.out.println("prenom: " + resultat.getString("statu"));
	 }
	  conn.rollback();
	}


	/**
	 * Ajouter un animal en choisissant sa cage de destintation
	 */
	private static void ajouterAnimal() throws SQLException{
		/*Nouvel Animal*/
		/*Connextion à la base*/
		Connection conn=TheConnection.getInstance();
		AnimalDAO A1 = new AnimalDAO(conn);
		Animal newAnimal = new Animal();
		Scanner clavier = new Scanner(System.in);
		
		/*Récupération du nom*/
		System.out.println("Veuillez saisir le nom: ");
		newAnimal.setNomA(clavier.nextLine());

		/*Récupération du Sexe*/
		System.out.println("Veuillez saisir le sexe: ");
		newAnimal.setSexe(clavier.nextLine());

		/*Récupération du numéro de type animal*/
		System.out.println("Veuillez saisir le type d'animal: ");
		newAnimal.setType(clavier.nextLine());

		/*Récupération du numéro de type animal*/
		System.out.println("Veuillez saisir la fonction de la cage: ");
		newAnimal.setFonctionCage(clavier.nextLine());

		
		/*Récupération du numéro de type animal*/
		System.out.println("Veuillez saisir le pays");
		newAnimal.setPays(clavier.nextLine());

		
		/*Récupération de l'anné de naissance*/
		System.out.println("Veuillez saisir l'année de naissance'");
		newAnimal.setAnNais(clavier.nextInt());

		
		/*Récupération du numéro de cage*/
		System.out.println("Veuillez saisir le numéro de cage: ");
		Cage laCage = new Cage();
		laCage.setNoCage(clavier.nextInt());
		newAnimal.setLaCage(laCage);

		A1.create(newAnimal);
		/*Crétion d'une requête*/
		System.out.println("......Enregistrement de l'animal réussi.........");
	
	conn.commit();
	}

	/**
	 * Ajouter une cage à la liste de cages gardés par un gardien (en option)
	 */
	private static void ajouterCageGardien() throws SQLException{
	  Connection conn=TheConnection.getInstance();
	
		/* TO DO */
	  conn.commit();
	}

}
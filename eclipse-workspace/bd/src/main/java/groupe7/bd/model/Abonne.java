package groupe7.bd.model;
import groupe7.bd.*;
import groupe7.bd.utils.TheConnection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class Abonne {
	//Attributs
	Interface inter;//Permet d'accer au fonction de l'interface
	int idAbonne;
	int idClient;
	String nom;
	String prenom;
	String numeroCarteBancaire;
	Date dateDeNaissance;
	Sexe sexe;
	Date dateDAbonnement;
	String codeSecret;
	
	
	//Constructeurs
		
	//getters et setters
	public int getIdAbonne() {
		return idAbonne;
	}

	public void setIdAbonne(int idAbonne) {
		this.idAbonne = idAbonne;
	}
	
	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNumeroCarteBancaire() {
		return numeroCarteBancaire;
	}

	public void setNumeroCarteBancaire(String numeroCarteBancaire) {
		this.numeroCarteBancaire = numeroCarteBancaire;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public Sexe getSexe() {
		return sexe;
	}

	public void setSexe(Sexe sexe) {
		this.sexe = sexe;
	}

	public Date getDateDAbonnement() {
		return dateDAbonnement;
	}

	public void setDateDAbonnement(Date dateDAbonnement) {
		this.dateDAbonnement = dateDAbonnement;
	}

	public String getCodeSecret() {
		return codeSecret;
	}

	public void setCodeSecret(String codeSecret) {
		this.codeSecret = codeSecret;
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
		try {
			//SQL
			Connection conn=TheConnection.getInstance();
			Statement requete;
			
			//Sql commande
			String sqlCommad = "SELECT * FROM Abonne NATURAL JOIN Client WHERE (nom = '"+nomAbonne+"' and codeSecret =" +codeSecretAbonne+")";
		
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			
			while (resultat.next()) {
				
				//JAVA
				this.idAbonne = resultat.getInt("idAbonne");
				
				this.idClient = resultat.getInt("idClient");
				
				this.nom = resultat.getString("nom");
				
				this.prenom = resultat.getString("prenom");
				
				String sexeVal = resultat.getString("sexe");
				System.out.println("->"+sexeVal);
				if (sexeVal.charAt(0) == 'h') this.sexe = Sexe.H; else this.sexe = Sexe.F;
				
				this.numeroCarteBancaire = resultat.getString("numCB");
				
				String naissanceStr = resultat.getString("dateNaissance");
				this.dateDeNaissance = inter.convDateSQLToJAVA(naissanceStr);
				
				String abonnementStr = resultat.getString("dateAbonnement");
				this.dateDAbonnement = inter.convDateSQLToJAVA(abonnementStr);
		
				this.codeSecret= resultat.getString("codeSecret");
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* 
	 * [Java]
	 * Demande les valeurs de chaque attribut à l'uttilisateur et met à jour l'objet courant
	 * [Sql]
	 * Enregistre dans la base de donnè de nouvelle abonne en utilisant les valeurs de l'objet courant
	 */
	public void SaveNewAbonne() {
		System.out.println( "Création d'un abonnée");
		System.out.println( "Veuillez entrer votre: ");
		
		System.out.println( "nom: ");
		this.nom = inter.demandeString();
		
		System.out.println( "prénom: ");
		this.prenom = inter.demandeString();
		
		System.out.println( "N° de CB: ");
		this.numeroCarteBancaire = inter.demandeCarteBancaire();
		
		System.out.println( "Date de naissance: ");
		this.dateDeNaissance = inter.demandeDate();
		String dateDeNaissanceSQL = inter.convDateJAVAToSQL(this.dateDeNaissance);
		
		System.out.println( "Sexe [F,H]: ");
		this.sexe = inter.demandeSexe();
		String sexeVal;
		if (this.sexe == Sexe.H) sexeVal = "h"; else sexeVal = "f";
		
		System.out.println( "Définir un code secret: ");
		
		this.codeSecret = inter.demandeCodeSecret();
		System.out.println( "");
		
		this.dateDAbonnement = Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());;
		System.out.print(dateDAbonnement);
		String dateDAbonnementSQL = inter.convDateJAVAToSQL(this.dateDAbonnement);
		
		System.out.println( "Félicitaions vous êtes abonnèes");
		System.out.println( "");
		
		//[SQL]
		try {
			
			String sqlCommad = "INSERT INTO Client (numCB) VALUES ('"+this.numeroCarteBancaire+"')";
			Connection conn=TheConnection.getInstance();
			
			Statement stmt = conn.createStatement();
			stmt.executeUpdate(sqlCommad, Statement.RETURN_GENERATED_KEYS);
			
			
			//retourne l' id client
			sqlCommad = "SELECT MAX(idClient) AS id FROM Client;";
			Statement requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			
			while (resultat.next()) {
				this.idClient = resultat.getInt("id");
			}
			
			//Sql commande new abonne
			sqlCommad = "INSERT INTO Abonne (idClient,nom,prenom,dateNaissance,sexe,dateAbonnement,codeSecret) VALUES ("
			+idClient+",'"+this.nom+"','"+this.prenom+"','"+dateDeNaissanceSQL+"','"+sexeVal+"','"+dateDAbonnementSQL+"','"+this.codeSecret+"')";
			stmt = conn.createStatement();
			//Statement stmt = conn.prepareStatement(sqlCommad, Statement.RETURN_GENERATED_KEYS);
			stmt.executeUpdate(sqlCommad);
			
			//retourne l' id de l'abonne
			sqlCommad = "SELECT MAX(idAbonne) AS id FROM Abonne;";
			requete = conn.createStatement();
			resultat = requete.executeQuery(sqlCommad);
			
			while (resultat.next()) {
				this.idAbonne = resultat.getInt("id");
			}
			
			//System.out.println("-<"+this.idAbonne+"/"+this.idClient);
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/* NON PRIORITAIRE
	 * [Java]
	 * Affiche toutes les informations de l'objet courant
	 * Travailler l'affichage si possible
	 * 	exemple:
	 * 		nom: XX prénom : XX
	 * 		age: XX ans
	 * 
	 */
	public void showProfil() {
		System.out.println("--------PROFIL ABONNE: -------");
		System.out.println("Nom: "+this.nom);
		System.out.println("Prénom:"+this.prenom);
		System.out.println("Date de naissance: "+this.dateDeNaissance);
		System.out.println("Sexe: "+this.sexe);
		System.out.println("Numéro de CB: "+this.numeroCarteBancaire);
		System.out.println("Date d'abonnement: "+this.dateDAbonnement);
	}
	
	/* NON PRIORITAIRE
	 * [Java]
	 * Modifie les informations de l'objet courant
	 * [Sql]
	 * Met à jour dans la base de donnè l' abonne en utilisant les valeurs de l'objet courant
	 * Note: version bourain on supprime l'abonneCourant et en recrée un nouveau
	 * 
	 */
	public void editProfil() {
		// TODO
		
	}
	
	/*[Sql]
	 * Intteroge la base de donnèe pour rècupèrer toutes les locations "EN COURS" de l'abonné.
	 *Affiche les résultat sous la forme:
		 * 	(1)-> location n°1 /dateDébut/
		 *  (2)-> location n°2 /dateDébut/
	 */
	public void showLocation() {
		//SQL
		Connection conn=TheConnection.getInstance();
		java.sql.Statement requete;
		
		//Sql commande
		String sqlCommad = "SELECT * FROM Locations NATURAL JOIN Client LEFT JOIN Abonne USING (idClient) WHERE (fini = 0 and idAbonne = "+this.idAbonne+");";
		try {
			requete = conn.createStatement();
			ResultSet resultat = requete.executeQuery(sqlCommad);
			
			Location location;
			
			while (resultat.next()) {
				System.out.println("Location N° "+resultat.getInt("IdLocations")+":");
				location = new Location();
				location.shownLocationIdLocations();
			}
			
		}
		catch (SQLException e){
			System.out.println("SQL Erreur");
		}
		
	}


}
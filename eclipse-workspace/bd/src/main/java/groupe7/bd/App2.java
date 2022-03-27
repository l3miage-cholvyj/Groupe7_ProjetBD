package groupe7.bd;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Persistence;


/*
 * COVENTION DE NOMAGE DES FONCTIONS
 * 
 * set_NOMATTRIBUT() -> fixe la valeur d'un attribut de l'objet courant
 * get_NOMATTRIBUT() -> retourne la valeur d'un attribut de l'objet courant
 * get_CLASS_CRITAIRES() -> retourne une instance de type CLASS associée à l'objet courant qui respecte les CRITAIRES
 * get_List_CLASS_CRITAIRES() -> retourne une liste instances de type CLASS associées à l'objet courant qui respectent les CRITAIRES
 * calcul_TEXT() -> calcul et retourne quelquechose associé à l'objet courant 
 * Save_TEXT() -> Met à jou la base de donnèe avec les valeurs de l'objet (java) courant.
 * Load_TEXT() -> Met à jour un objet (java) courant en chargeant les valeurs depuis la base de donnée
 * Edit_TEXT() -> Moddifie l'objet (java) courant et met à jour la base de donnée. (Edit = Save + Load)
 * Show_TEXT() -> Recherche quelque choses dans la base de donnèe et affiche les résultat [ne retourne et crée RIEN]
 *
 *
 */

/*
Test commande
java.sql.Statement testeSql = con.createStatement();
java.sql.ResultSet resultatTestSql = testeSql.executeQuery("SELECT * FROM utilisateur");
          	  	
while (resultatTestSql.next()) {
System.out.println("id: " + resultatTestSql.getInt("id"));
System.out.println("nom: " + resultatTestSql.getString("nom"));
System.out.println("prenom: " + resultatTestSql.getString("prenom"));
}
*/

public class App2 {

	static Interface inter;//Permet d'accer au fonction de l'interface
	/*
	 * Etablie une connextion vers une base de donnée local
	 */
	public static Connection ConnectionBD(String url,String user,String password) {
		try {
	    	Connection con = DriverManager.getConnection(url,user,password);
	    	System.out.println( "Connexion Succes" );
	    	return con;
		}
	    catch (SQLException e) {
	    	System.out.println( "Connexion Fail" );
	    	e.printStackTrace();
	    	return null;
	    }
	}
	
	//--MAIN--
	public static void main( String[] args ) throws SQLException
    {
        //Variable
    	Connection con;
    	
    	System.out.println( "Launcher groupe 7 database" );
        
        //----Etabli la connexion avec la base de données----
    	
    	//Lance la connexion vers la base de données
    	con =  ConnectionBD("jdbc:mysql://localhost:3306/veli","root",""); //Configuration Jordan
    	
    	//Connexion BD avec d'autres identifiants
    	if (con == null) {
    		con = ConnectionBD("jdbc:mysql://localhost:3306/veli","root","Nenany15"); // Configuration Thierno
    	}
    	
    	if (con != null) {
    		
    		//--- Essais de commande sql
    		/*
    		java.sql.Statement testeSql = con.createStatement();
      	  	java.sql.ResultSet resultatTestSql = testeSql.executeQuery("SELECT * FROM utilisateur WHERE (nom='Khoi')");
      	  	
        	while (resultatTestSql.next()) {
        		System.out.println("N°: " + resultatTestSql.getInt("id"));
        		System.out.println("nom: " + resultatTestSql.getString("nom"));
        		System.out.println("prenom: " + resultatTestSql.getString("prenom"));
        	}
        	*/
        	
        	//--- Lance l'interface Textuelle ---
        	inter.Interface(0);
        	//---
        	
    	}
    	else {
    		System.out.println( "---FIN PROGRAMME---" ); // Si echec de la connexion à la BD
    	}
    	
    }
}

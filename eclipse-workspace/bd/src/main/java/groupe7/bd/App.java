package groupe7.bd;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.persistence.Persistence;

import groupe7.bd.utils.TheConnection;


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

public class App {

	
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

		System.out.println("START vePick ");
		Connection conn=TheConnection.getInstance();

		Interface.Interface(0);

			// traitement d'exception
		 
		/*
		catch (SQLException e) {
			TheConnection.close();
			System.err.println("failed");
			System.out.println("Affichage de la pile d'erreur");
			e.printStackTrace(System.err);
			System.out.println("Affichage du message d'erreur");
			System.out.println(e.getMessage());
			System.out.println("Affichage du code d'erreur");
			System.out.println(e.getErrorCode());	    
		}*/

    }
	
	
}

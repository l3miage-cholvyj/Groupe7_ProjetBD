package groupe7.bd;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Persistence;


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
        	
        	//--- Interface Textuelle ---
        	Interface.Interface(0);
        	//---
        	
    	}
    	else {
    		System.out.println( "---FIN PROGRAMME---" ); // Si echec de la connexion à la BD
    	}
    	
    }
}

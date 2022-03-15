package groupe7.bd;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.Persistence;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Luncher groupe 7 data base" );
    
        String url = "jdbc:mysql://localhost:3306/veli";
        String userName = "root";
        String password = "";
        
        try {
        	Connection con = DriverManager.getConnection(url,userName,password);
        	System.out.println( "Connextion Succes" );
        	/*Teste commande*/
        	java.sql.Statement testeSql = con.createStatement();
      	  	java.sql.ResultSet resultatTestSql = testeSql.executeQuery("SELECT * FROM utilisateur");
      	  	
        	while (resultatTestSql.next()) {
        		System.out.println("id: " + resultatTestSql.getInt("id"));
        		System.out.println("nom: " + resultatTestSql.getString("nom"));
        		System.out.println("prenom: " + resultatTestSql.getString("prenom"));
        	}
        }
        catch (SQLException e) {
        	System.out.println( "Connextion Fail" );
        	e.printStackTrace();
        }
    }
}

package groupe7.bd;

import groupe7.bd.model.*;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Luncher groupe 7 data base" );
        
        Station s1 = new Station();
        s1.nom = "Test";
        System.out.println(s1.nom);
    }
}

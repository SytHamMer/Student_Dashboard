import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BDD {
    /*
    PATTERN : Singleton : On utilise la methode getInstance pour avoir tout le temps l'instance de la BDD pour
                ne pas en créer une nouvelle
     */

    final String SERVER = "localhost:3306";
    final String NAMEBDD = "theo";
    final String USERNAME = "root";
    final String PWD = "";

    private static BDD instance;

    private BDD() {
    }

    public static BDD getInstance() {
        if (instance == null) {
            instance = new BDD();
        }
        return instance;
    }

    public void connexion() {

        try
        {
            //étape 1: charger la classe de driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //étape 2: créer l'objet de connexion
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://" + SERVER + "/" + NAMEBDD, USERNAME, PWD);
//                    "jdbc:mysql://localhost:3306/theo", "root", "");

            //étape 3: créer l'objet statement
            Statement stmt = conn.createStatement();
            ResultSet res = stmt.executeQuery("SELECT titre FROM DVD");

            //étape 4: exécuter la requête
            while(res.next())
                System.out.println(res.getString(1));

            //étape 5: fermez l'objet de connexion
            conn.close();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }


}

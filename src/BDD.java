import java.sql.*;

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
    private Connection conn;

    private BDD() {
        // -- Faire la connexion dans le conctructeur
        // A chaque fois que l'on instancie un objet BDD, on etabli directement la
        // connexion

        this.conn = this.connexion();
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }


    public static BDD getInstance() {
        if (instance == null) {
            instance = new BDD();
        }
        return instance;
    }

    public Connection connexion() {
        Connection conn = null;
        try
        {
            //étape 1: charger la classe de driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //étape 2: créer l'objet de connexion
            conn = DriverManager.getConnection(
                    "jdbc:mysql://" + SERVER + "/" + NAMEBDD, USERNAME, PWD);
//                    "jdbc:mysql://localhost:3306/theo", "root", "");

        }
        catch(Exception e){
            System.out.println(e);
        }

        return conn;

    }

    public ResultSet select(String request) throws SQLException {
        /*
        GOAL : Effectuer une requete dans la BDD et retourner le resultat
         */

        Statement stmt = this.getConn().createStatement();
        ResultSet res = stmt.executeQuery(request);

        return res;
    }


}

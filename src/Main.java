import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws SQLException {
        // -- Creattion matiere
        Matiere math = new Matiere(1, "PROBA STATS", "MATH741");

        // -- Creation de 3 etudiants
        Etudiant arthur = new Etudiant(1, "RATA", "Arthur");
        Etudiant mathys = new Etudiant(2, "LEBON", "Mathys");
        Etudiant mathieu = new Etudiant(3, "FERREIRA", "Mathieu");

        // -- Ajouter les étudiants à la matière
        math.addStudent(arthur);
        math.addStudent(mathys);
        math.addStudent(mathieu);

        // -- Créer un nouveau travail en math
        System.out.println("----------------------------- Pattern OBSERVATEUR \n");
        math.generateNewTravail(1, "TD2 : Exercice 1", new Date(2023, 10, 28));


        // -- Test Connexion BDD
        System.out.println("----------------------------- Pattern SINGLETON \n");
        BDD db = BDD.getInstance();
        ResultSet res = db.select("SELECT * FROM DVD");
        ResultSet res2 = db.select("SELECT * FROM PERSONNES");
//
//        while(res.next())
//            System.out.println(res.getString(1));
//
//        System.out.println(res);
    }
}
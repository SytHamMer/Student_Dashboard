import java.util.Date;

public class Main {
    public static void main(String[] args) {
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
//        math.generateNewTravail(1, "TD2 : Exercice 1", new Date(2023, 10, 28));

        // -- Test Connexion BDD
        BDD.getInstance().connexion();
    }
}
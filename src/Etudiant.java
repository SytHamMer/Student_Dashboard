import java.security.PublicKey;
import java.util.ArrayList;

public class Etudiant implements TravailListener{
    private int id;
    private String nom;
    private String prenom;

    private ArrayList<Note> listNote;

    public Etudiant(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.listNote = new ArrayList<Note>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    // TODO newTravail
    @Override
    public void newTravail(TravailEvent te) {
        System.out.println("NAME/SURNAME : " + this.getNom() + "/" + this.getPrenom());
        System.out.println("[NEW TRAVAIL]");
        System.out.println("\t Matiere : " + te.getSource().toString());
        System.out.println("\t\t " + te.getTitre());
    }

    // TODO getAllNotes
//    public ArrayList<Note> getAllNotes() {
//
//    }

    // TODO getNoteByMatiere
//    public ArrayList<Note> updateNote() {
//
//    }

    // TODO getNoteByMatiere
//    public ArrayList<Note> getNoteByMatiere () {
//
//    }

    // TODO getAllNotesOfAllStudents
//    public ArrayList<Note> getAllNotesOfAllStudents() {
//
//    }

}

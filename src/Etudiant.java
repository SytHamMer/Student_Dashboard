import java.security.PublicKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public ArrayList<Note> getListNote() {
        return listNote;
    }

    public void setListNote(ArrayList<Note> listNote) {
        this.listNote = listNote;
    }

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

    public ArrayList<Note> getNotesSuperiorDate(Date dateLastNote) throws SQLException {
        /*
         GOAL : Récupérer toutes les notes  ajoutées après une certaine date
         */

        // -- Récupérer l'instance de la base de donnée active
        BDD db = BDD.getInstance();

        ArrayList<Note> listNewNotes = new ArrayList<Note>();

        ResultSet res = null;
        // -- Si dateLastNote est null : on récupère toutes les notes
        if (dateLastNote == null) {
            res = db.select("SELECT * FROM Note");
        }
        // -- Sinon : On récupère celles qui ont une date supérieur à dateLastNote
        else {
            res = db.select("SELECT * FROM Note WHERE dateAjout > " + dateLastNote.toString());
        }

        // -- Tant qu'il y a des notes : on les ajoute à la liste listNewNotes en créant une nouvelle note
        while(res.next()) {
            listNewNotes.add(
                    new Note(
                            res.getInt(1),
                            res.getInt(2),
                            res.getDate(3)
                    )
            );
        }

        // -- Ajouter toutes les notes récupérées à la liste
        return listNewNotes;

    }

    public void updateNote() throws SQLException {
        /*
        GOAL : Ajouter à l'étudiant toutes les notes de la BDD qu'il n'a pas encore sur le site
         */

        ArrayList<Note> listNewNote = new ArrayList<Note>();

        // -- SI l'etudiant n'a pas de note : On récupère toutes les notes
        if (this.getListNote().size() == 0) {
            listNewNote = this.getNotesSuperiorDate(null);
        }
        // -- SINON : On récupère la date de la dernière note que l'étudiant a
        // et on prend toutes les notes ajoutées ultérieures
        else {

            Note lastNote = this.getListNote().get( this.getListNote().size() - 1 );
            Date dateLastNote = lastNote.getDateAjout();

            listNewNote = this.getNotesSuperiorDate(dateLastNote);
        }

        // -- Concaténer la liste de Note de l'étudiant existante et la listNewNote
        this.getListNote().addAll(listNewNote);
    }

    // TODO getNoteByMatiere
//    public ArrayList<Note> getNoteByMatiere () {
//
//    }

    // TODO getAllNotesOfAllStudents
//    public ArrayList<Note> getAllNotesOfAllStudents() {
//
//    }

}

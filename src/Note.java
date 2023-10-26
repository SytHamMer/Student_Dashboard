import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class Note {
    private int idNote;
    private int valeur;
    private Date dateAjout;
    private Matiere matiere;

    public Note(int idNote, int valeur, Date dateAjout) throws SQLException {
        this.idNote = idNote;
        this.valeur = valeur;
        this.dateAjout = dateAjout;
        this.matiere = this.getTheMatiere();
    }

    public int getIdNote() {
        return idNote;
    }

    public void setIdNote(int idNote) {
        this.idNote = idNote;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void setDateAjout(Date dateAjout) {
        this.dateAjout = dateAjout;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Matiere getTheMatiere() throws SQLException {
        /*
        GOAL : Récupérer la matière de la note dans laquelle elle a été ajoutée
         */

        // -- Récupérer l'instance de la BDD
        BDD db = BDD.getInstance();

        // -- Effectuer la requête
        ResultSet res = db.select("SELECT * FROM Matiere m JOIN Note n ON m.idMatiere = m.idMatiere WHERE n.idNote = " + this.getIdNote() );

        // -- Build l'objet Matiere avec le resultat de la requete
        Matiere theMatiere = new Matiere();

        while(res.next()) {
            theMatiere.setIdMatiere(res.getInt(1));
            theMatiere.setLabel(res.getString(2));
            theMatiere.setCode(res.getString(3));
        }

        return theMatiere;
    }

}

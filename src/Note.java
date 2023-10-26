import java.util.Date;

public class Note {
    private int idNote;
    private int valeur;
    private Date dateAjout;

    private Matiere matiere;

    public Note(int valeur, Date dateAjout) {
        this.valeur = valeur;
        this.dateAjout = dateAjout;
//        this.matiere = this.getTheMatiere();
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

//    public Matiere getTheMatiere() {
//        // TODO -- Requete BDD pour avoir la matiere avec l'id de la note
//    }

}

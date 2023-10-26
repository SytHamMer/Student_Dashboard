import java.util.ArrayList;
import java.util.Date;

public class Matiere {
    private int idMatiere;
    private String label;
    private String code;
    private ArrayList<TravailListener> listStudent;

    public Matiere(int idMatiere, String label, String code) {
        this.idMatiere = idMatiere;
        this.label = label;
        this.code = code;
        this.listStudent = new ArrayList<TravailListener>();
    }

    public Matiere() {
    }

    public int getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(int idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ArrayList<TravailListener> getListStudent() {
        return listStudent;
    }

    public void setListStudent(ArrayList<TravailListener> listStudent) {
        this.listStudent = listStudent;
    }

    public void addStudent(TravailListener tl) {
        this.getListStudent().add(tl);
    }

    public void removeStudent(TravailListener tl) {
        this.getListStudent().remove(tl);
    }

    public void generateNewTravail(int idTravail, String titre, Date dateRendu) {
        /*
        GOAL : Envoyer une notification à chaque student dans la listStudent
         */

        TravailEvent te = new TravailEvent(this, idTravail, titre,  dateRendu);

        for (TravailListener tl : listStudent) {
            tl.newTravail(te);
            System.out.println("\n");
        }
    }

    @Override
    public String toString() {
        return this.getCode() + " [" + this.getLabel() + "]";
    }
}

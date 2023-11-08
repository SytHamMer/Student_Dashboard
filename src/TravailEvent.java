import java.util.Date;
import java.util.EventObject;
import java.util.Objects;

public class TravailEvent extends EventObject {
    private int idTravail;
    private String titre;
    private boolean rendu;
    private Date dateLmite;
    private Date dateRendu;

    public TravailEvent(Object source, int idTravail, String titre, Date dateLmite) {
        super(source);
        this.idTravail = idTravail;
        this.titre = titre;
        this.rendu = false;
        this.dateLmite = dateLmite;
        this.dateRendu = null;
    }

    public int getIdTravail() {
        return idTravail;
    }

    public void setIdTravail(int idTravail) {
        this.idTravail = idTravail;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public boolean isRendu() {
        return rendu;
    }

    public void setRendu(boolean rendu) {
        this.rendu = rendu;
    }

    public Date getDateLmite() {
        return dateLmite;
    }

    public void setDateLmite(Date dateLmite) {
        this.dateLmite = dateLmite;
    }

    public Date getDateRendu() {
        return dateRendu;
    }

    public void setDateRendu(Date dateRendu) {
        this.dateRendu = dateRendu;
    }


}

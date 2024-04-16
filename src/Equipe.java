import java.util.List;
import java.util.ArrayList;

public class Equipe {
    private String nomEq;
    private Pays lePays;
    private List<Athlete> lesAthletes;

    public Equipe(String nomEq, Pays lePays , List<Athlete> lesAthletes) {
        this.nomEq = nomEq;
        this.lePays = lePays;
        this.lesAthletes = new ArrayList<>();
    }
    public Equipe(String nomEq, Pays lePays) {
        this.nomEq = nomEq;
        this.lePays = lePays;

    }

    public List<Athlete> getLesAthletes() {
        return lesAthletes;
    }
    public void setLesAthletes(List<Athlete> lesAthletes) {
        this.lesAthletes = lesAthletes;
    }

    public Pays getLePays() {
        return lePays;
    }
    public void setLePays(Pays lePays) {
        this.lePays = lePays;
    }

    public String getNomEq() {
        return nomEq;
    }
    public void setNomEq(String nomEq) {
        this.nomEq = nomEq;
    }

    public void ajouterMembre(Athlete nvAthlete){
        this.lesAthletes.add(nvAthlete);
    }

    public void retirerMembre(Athlete athlete){
        this.lesAthletes.remove(this.lesAthletes.indexOf(athlete));
    }
    
}

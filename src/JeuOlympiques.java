import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class JeuOlympiques {
    private List<Pays> lesPays;
    private List<Sport> lesSports;
    private Map<Epreuve, Set<Participer>> lesParticipations; //! Redefinir les equals et hashcode

    public JeuOlympiques(List<Pays> lesPays, List<Sport> lesSports, Map<Epreuve, Set<Participer>> lesParticipations) {
        this.lesPays = new ArrayList<>(lesPays);
        this.lesSports = new ArrayList<>(lesSports);
        this.lesParticipations = new HashMap<>(lesParticipations);
    }

    public JeuOlympiques() {
        this.lesPays = new ArrayList<>();
        this.lesSports = new ArrayList<>();
        this.lesParticipations = new HashMap<>();
    }

    public List<Pays> getLesPays() {
        return lesPays;
    }

    public List<Sport> getLesSports() {
        return lesSports;
    }

    public Map<Epreuve, Set<Participer>> getLesParticipations() {
        return lesParticipations;
    }

    public void ajouterPays(String nom) {
        Pays tmp = new Pays(nom);
        if (!(this.getLesPays().contains(tmp))) {
            this.getLesPays().add(tmp);
        }
    }

    public void ajouterSport(Sport s) {
        this.getLesSports().add(s);
    }

    public void enregistrerEpreuve(Epreuve e) {
        this.lesParticipations.put(e, new HashSet<Participer>());
    }

    public Map<Participer, Integer> lancerEpreuve(Epreuve e) {
        Map<Participer, Integer> resultatEpreuve = new HashMap<>();
        for (Participer p : this.getLesParticipations().get(e)) {
            resultatEpreuve.put(p, p.participer(e));
        }

        return resultatEpreuve;
    }

    public void inscrire(Participer participants, Epreuve epreuve) {
        this.lesParticipations.get(epreuve).add(participants);
    }

}

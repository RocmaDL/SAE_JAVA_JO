import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
public class JeuOlympiques {
    private List<Pays> lesPays;
    private List<Sport> lesSports;
    private Map<Epreuve, Set<Participer>> lesParticipations;

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
        if(!(this.getLesPays().contains(tmp))){
            this.getLesPays().add(tmp);
        }
    }

    /*
     * Cette méthode est ambigue, est ce que je rajoute un sport lambda ou un enfant de sport
     * 
     */
    public void ajouterSport() {
        //TODO
    }

    public void enregistrerEpreuve() {
        // TODO
    }

    public void lancerEpreuve() {
        // TODO
    }


    /*
     * Pour pouvoir utiliser un ensemble, il faut définir les méthodes hashcode() et equals() des participants et des epreuves 
     */
    public void inscrire(Participer participants, Epreuve epreuve) {
        // TODO
    }

}

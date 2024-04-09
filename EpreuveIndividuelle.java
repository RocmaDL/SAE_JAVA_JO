import java.util.List;
import java.util.ArrayList;

public class EpreuveIndividuelle extends Epreuves {
    /** La liste des athlètes participant à l'épreuve */
    private List<Athlete> lesAthletes;

    /** Constructeur qui met à jour les attributs de la classe EpreuveIndividuelle */
    public EpreuveIndividuelle(String nom, int scoreMax, String sexe) {
        super(nom, scoreMax, sexe);
        this.lesAthletes = new ArrayList<>();
    }

    /** Ajoute un athlete dans la liste des participants de l'épreuve */
    public void ajouteAthlete(Athlete athlete) {
        this.lesEquipes.add(athlete);
    }
    
    /** Enlève un participant de l'épreuve */
    public void enleveAthlete(Athlete athlete) {
        // Mettre une exception pour liste vide
        for (int i=0; i<this.lesAthletes.length();i++) {
            if (this.lesAthletes.get(i) == athlete) {
                this.lesAthletes.remove(i);
            }

        }
            
        
    }
}
import java.util.List;
import java.util.ArrayList;

public class EpreuveCollective extends Epreuves {
    /** La liste des équipes participant à l'épreuve */
    private List<Equipe> lesEquipes;

    /** Constructeur qui met à jour les attributs de la classe EpreuveIndividuelle */
    public EpreuveCollective(String nom, int scoreMax, String sexe) {
        super(nom, scoreMax, sexe);
        this.lesEquipes = new ArrayList<>();
        
    }

    /** Ajoute une équipe dans la liste des participants de l'épreuve */
    public void ajouteEquipe(Equipe equipe) {
        this.lesEquipes.add(equipe);
    }
}
import java.util.List;

public class EpreuveCollective extends Epreuves{
    private List<Participer> equipes;

    public EpreuveCollective(List<Participer> equipes, String nom, int scoreMax, String sexe) {
        super(nom,scoreMax, sexe);
        this.equipes = equipes;
    }

    
}

import java.util.ArrayList;
import java.util.List;

public class EpreuveIndividuelle extends Epreuves{
    private List<Participer> equipes;
    private List<Athlete> lesAthletes;

    public EpreuveIndividuelle(List<Participer> athletes , String nom , int scoreMax , char sexe) {
        super(nom,scoreMax,sexe);
        this.lesAthletes = new ArrayList<>();
    }

    
}


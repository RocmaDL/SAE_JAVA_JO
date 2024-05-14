import java.util.HashMap;
import java.util.Map;

public class VolleyBall extends Sport {


    private String nom;
    private Map<Caracteristique , Double> LesCoefficients;

    public VolleyBall(String nom){

        this.nom=nom;
        this.LesCoefficients = new HashMap<>();

        this.LesCoefficients.put(Caracteristique.FORCE , 1.9 );
        this.LesCoefficients.put(Caracteristique.AGILITE , 3.4);
        this.LesCoefficients.put(Caracteristique.ENDURANCE, 3.3);
    }


    @Override
    public Map<Caracteristique,Double> coeffcient(){     
        return this.LesCoefficients;
    }
}

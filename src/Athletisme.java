import java.util.HashMap;
import java.util.Map;

public class Athletisme extends Sport {

    private String nom;
    private Map<Caracteristique , Double > LesCoefficients;

    public Athletisme(String nom){
        this.nom=nom;
        this.LesCoefficients = new HashMap<>();

        this.LesCoefficients.put(Caracteristique.FORCE , 2.6 );
        this.LesCoefficients.put(Caracteristique.AGILITE , 3.3);
        this.LesCoefficients.put(Caracteristique.ENDURANCE, 4.8);
    }



    @Override
    public Map<Caracteristique,Double> coeffcient(){     
        return this.LesCoefficients;
    }
    
}

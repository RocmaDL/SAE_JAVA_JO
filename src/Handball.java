import java.util.HashMap;
import java.util.Map;

public class Handball extends Sport{

    private String nom;
    private Map<Caracteristique , Double> LesCoefficients;
    private Unite unite=Unite.TEMPS;


    

    public Handball(String nom){
        this.nom=nom;

        this.LesCoefficients = new HashMap<>();

        this.LesCoefficients.put(Caracteristique.FORCE , 2.4 );
        this.LesCoefficients.put(Caracteristique.AGILITE , 3.1);
        this.LesCoefficients.put(Caracteristique.ENDURANCE, 3.7);
    }



    @Override
    public Map<Caracteristique,Double> coeffcient(){     
        return this.LesCoefficients;
    }
}

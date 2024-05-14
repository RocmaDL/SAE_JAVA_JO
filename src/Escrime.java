import java.util.HashMap;
import java.util.Map;

public class Escrime extends Sport{
    
    private String nom;
    private Map<Caracteristique , Double > LesCoefficients;

    public Escrime(String nom){
        this.nom=nom;
        this.LesCoefficients = new HashMap<>();

        this.LesCoefficients.put(Caracteristique.FORCE , 2.2 );
        this.LesCoefficients.put(Caracteristique.AGILITE , 3.8);
        this.LesCoefficients.put(Caracteristique.ENDURANCE, 4.1);
    }



    @Override
    public Map<Caracteristique,Double> coeffcient(){     
        return this.LesCoefficients;
    }

}

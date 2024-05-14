import java.util.HashMap;
import java.util.Map;

public class Natation extends Sport {

    private String nom;
    private Map<Caracteristique , Double> LesCoefficients;
    private Unite unite=Unite.TEMPS;


    public Natation(String nom){
        this.nom=nom;

        this.LesCoefficients = new HashMap<>();

        this.LesCoefficients.put(Caracteristique.FORCE , 4.3 );
        this.LesCoefficients.put(Caracteristique.AGILITE , 3.0);
        this.LesCoefficients.put(Caracteristique.ENDURANCE, 4.5);
    }

    public Unite getUnite(){
        return this.unite;
    }
    //Conversion perf de participer to score en lien avec une idée

    @Override
    public Map<Caracteristique,Double> coeffcient(){     
        return this.LesCoefficients;
    }
    

}

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Sport {
    private List<Epreuve> lesEpreuves;
    private String nom;
    private Map<Caracteristique , Double> LesCoefficients;
    private String unite;



    public Sport(String nom , double force , double agilite , double endurance , String unite) {
        this.nom = nom;
        this.lesEpreuves = new ArrayList<>();

        this.LesCoefficients = new HashMap<>();

        this.LesCoefficients.put(Caracteristique.FORCE , force );
        this.LesCoefficients.put(Caracteristique.AGILITE , agilite);
        this.LesCoefficients.put(Caracteristique.ENDURANCE, endurance);

        this.unite = unite;
    }

    public Sport(String nom, List<Epreuve> lesEpreuves) {
        this.nom = nom;
        this.lesEpreuves = new ArrayList<>(lesEpreuves);
    }

    public void enregistrerEpreuve(Epreuve Epreuve) {
        this.lesEpreuves.add(Epreuve);
    }

    public void supprimerEpreuve(Epreuve Epreuve) {
        this.lesEpreuves.remove(Epreuve);
    }

    public List<Epreuve> getlesEpreuves() {
        return lesEpreuves;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Map<Caracteristique,Double> coeffcient(){     
        return this.LesCoefficients;
    }

}

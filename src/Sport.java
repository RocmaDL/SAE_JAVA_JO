import java.util.ArrayList;
import java.util.List;

public class Sport {
    private List<Epreuve> lesEpreuves;
    private String nom;

    public Sport(String nom) {
        this.nom = nom;
        this.lesEpreuves = new ArrayList<>();
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
}

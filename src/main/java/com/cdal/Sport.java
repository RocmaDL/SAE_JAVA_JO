package main.java.com.cdal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sport {
    private List<Epreuve> lesEpreuves;
    private String nom;
    private Map<Caracteristique, Double> LesCoefficients;
    private Unite unite;

    public Sport(String nom, double force, double agilite, double endurance, Unite unite) {
        this.nom = nom;
        this.lesEpreuves = new ArrayList<>();

        this.LesCoefficients = new HashMap<>();

        this.LesCoefficients.put(Caracteristique.FORCE, force);
        this.LesCoefficients.put(Caracteristique.AGILITE, agilite);
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

    public Map<Caracteristique, Double> getCoefficient() {
        return this.LesCoefficients;
    }

    public void setCoefficient(Map<Caracteristique, Double> nvCoefficients) {
        this.LesCoefficients = nvCoefficients;
    }

    public Unite getUnite() {
        return unite;
    }

    public void setUnite(Unite unite) {
        this.unite = unite;
    }

    @Override
    public String toString() {
        return "Sport [lesEpreuves=" + lesEpreuves + ", nom=" + nom + ", LesCoefficients=" + LesCoefficients
                + ", unite="
                + unite + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Sport))
            return false;
        Sport tmp = (Sport) obj;
        return this.nom.equals(tmp.nom) && this.lesEpreuves.equals(tmp.lesEpreuves)
                && this.LesCoefficients.equals(tmp.LesCoefficients) && this.unite.equals(tmp.unite);
    }

    @Override
    public int hashCode() {
        return this.nom.hashCode() + this.lesEpreuves.hashCode() + this.LesCoefficients.hashCode()
                + this.unite.hashCode();
    }

}

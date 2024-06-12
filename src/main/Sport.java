package main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Sport {
    private List<EpreuveTest> lesEpreuves;
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

    public Sport(String nom, List<EpreuveTest> lesEpreuves) {
        this.nom = nom;
        this.lesEpreuves = new ArrayList<>(lesEpreuves);
    }

    public void enregistrerEpreuve(EpreuveTest Epreuve) {
        this.lesEpreuves.add(Epreuve);
    }

    public void supprimerEpreuve(EpreuveTest Epreuve) {
        this.lesEpreuves.remove(Epreuve);
    }

    public List<EpreuveTest> getlesEpreuves() {
        return lesEpreuves;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Map<Caracteristique,Double> getCoefficient(){     
        return this.LesCoefficients;
    }
    public void testSetCoefficient( Map<Caracteristique,Double> nvCoefficients){
        this.LesCoefficients = nvCoefficients;

    }

}

package main.java.com.cdal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Représente un sport avec ses épreuves, caractéristiques et unité de mesure.
 * Un sport est caractérisé par son nom, une liste d'épreuves associées, un ensemble de coefficients
 * représentant les caractéristiques physiques requises (force, agilité, endurance) et une unité de mesure.
 */
public class Sport {
    /**
     * Liste des épreuves associées à ce sport.
     */
    private List<Epreuve> lesEpreuves;

    /**
     * Nom du sport.
     */
    private String nom;
    private Map<Caracteristique, Double> LesCoefficients;
    private Unite unite;

    /**
     * Constructeur pour créer un sport avec des coefficients spécifiques pour les caractéristiques physiques.
     * 
     * @param nom Nom du sport.
     * @param force Coefficient de force.
     * @param agilite Coefficient d'agilité.
     * @param endurance Coefficient d'endurance.
     * @param unite Unité de mesure pour les résultats des épreuves.
     */
    public Sport(String nom , double force , double agilite , double endurance , Unite unite) {
        this.nom = nom;
        this.lesEpreuves = new ArrayList<>();
        this.LesCoefficients = new HashMap<>();

        this.LesCoefficients.put(Caracteristique.FORCE , force );
        this.LesCoefficients.put(Caracteristique.AGILITE , agilite);
        this.LesCoefficients.put(Caracteristique.ENDURANCE, endurance);
        this.unite = unite;
    }

    /**
     * Constructeur pour créer un sport avec une liste d'épreuves prédéfinies.
     * 
     * @param nom Nom du sport.
     * @param lesEpreuves Liste des épreuves associées au sport.
     */
    public Sport(String nom, List<Epreuve> lesEpreuves) {
        this.nom = nom;
        this.lesEpreuves = new ArrayList<>(lesEpreuves);
    }

    /**
     * Enregistre une nouvelle épreuve dans la liste des épreuves de ce sport.
     * 
     * @param Epreuve L'épreuve à ajouter.
     */
    public void enregistrerEpreuve(Epreuve Epreuve) {
        this.lesEpreuves.add(Epreuve);
    }

    /**
     * Supprime une épreuve de la liste des épreuves de ce sport.
     * 
     * @param Epreuve L'épreuve à supprimer.
     */
    public void supprimerEpreuve(Epreuve Epreuve) {
        this.lesEpreuves.remove(Epreuve);
    }

    /**
     * Retourne la liste des épreuves associées à ce sport.
     * 
     * @return Liste des épreuves.
     */
    public List<Epreuve> getlesEpreuves() {
        return lesEpreuves;
    }

    /**
     * Retourne le nom du sport.
     * 
     * @return Nom du sport.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définit le nom du sport.
     * 
     * @param nom Nouveau nom du sport.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne les coefficients des caractéristiques physiques pour ce sport.
     * 
     * @return Map des coefficients des caractéristiques.
     */
    public Map<Caracteristique,Double> getCoefficient(){     
        return this.LesCoefficients;
    }

    /**
     * Définit les coefficients des caractéristiques physiques pour ce sport.
     * 
     * @param nvCoefficients Nouveaux coefficients des caractéristiques.
     */
    public void setCoefficient( Map<Caracteristique,Double> nvCoefficients){
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

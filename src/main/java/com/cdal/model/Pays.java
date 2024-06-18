package main.java.com.cdal.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import main.java.com.cdal.exception.*;

public class Pays {

    private String nom;
    private List<Equipe> lesEquipes;
    private List<Athlete> lesAthletes;
    private Map<String, Integer> medailles;

    /**
     * Constructeur qui met à jour les attributs de la classe Pays
     * 
     * @param nom
     */
    public Pays(String nom) {
        this.nom = nom;
        this.lesEquipes = new ArrayList<>();
        this.lesAthletes = new ArrayList<>();
        this.medailles = new HashMap<>();
        this.medailles.put("Or", 0);
        this.medailles.put("Argent", 0);
        this.medailles.put("Bronze", 0);

    }

    /**
     * Ajoute une équipe d'athlètes dans la liste des équipes du pays
     * 
     * @param equipe
     */
    public void enregistrerEquipe(Equipe equipe) {
        this.lesEquipes.add(equipe);
    }

    /**
     * Ajoute un athlète à la liste des athlètes du pays
     * 
     * @param athlete
     */
    public void enregistrerAthlete(Athlete athlete) {
        this.lesAthletes.add(athlete);
    }

    /**
     * Supprime une équipe de la liste des équipes du pays
     * 
     * @param equipe
     */
    public void supprimerEquipe(Equipe equipe) throws EquipeInexistanteException {
        if (!this.lesEquipes.contains(equipe)) {
            throw new EquipeInexistanteException();
        }
        this.lesEquipes.remove(equipe);
    }

    /**
     * Supprime un athlète de la liste des athlètes du pays
     * 
     * @param athlete
     */
    public void supprimerAthlete(Athlete athlete) throws AthleteInexistantException {
        if (!this.lesAthletes.contains(athlete)) {
            throw new AthleteInexistantException();
        }
        this.lesAthletes.remove(athlete);
    }

    /**
     * Récupère la liste des équipes d'un pays
     * 
     * @return la liste des équipes
     */
    public List<Equipe> getLesEquipes() {
        return lesEquipes;
    }

    /**
     * Récupère la liste des athlètes d'un pays
     * 
     * @return la liste des athlètes
     */
    public List<Athlete> getLesAthletes() {
        return lesAthletes;
    }

    /**
     * Récupère le nom du pays
     * 
     * @return le nom du pays
     */
    public String getNom() {
        return nom;
    }

    /**
     * Fixe le nom d'un pays
     * 
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getTotalNbMedailles() {
        int res = 0;
        for (Integer med : this.medailles.values()) {
            res += med;

        }
        return res;
    }

    public Integer getNbMedaillesCouleur(String typeMedaille) throws MedailleInexistanteException {
        if (!this.medailles.containsKey(typeMedaille)) {
            throw new MedailleInexistanteException();
        }
        int res = 0;
        for (String med : this.medailles.keySet()) {
            if (typeMedaille.equals(med)) {
                res += 1;
            }

        }
        return res;
    }

    public void addMedailles(String typeMedaille) throws MedailleInexistanteException {
        if (!this.medailles.containsKey(typeMedaille)) {
            throw new MedailleInexistanteException();
        }
        for (String med : this.medailles.keySet()) {
            if (typeMedaille.equals(med)) {
                this.medailles.replace(med, getNbMedaillesCouleur(typeMedaille), this.medailles.get(typeMedaille) + 1);

            } else {
                // Si le type de médaille n'existe pas, on met 0
                this.medailles.put(typeMedaille, 0);
            }

        }
    }

    /**
     * Compte le nombre d'athlètes individuels du pays
     * 
     * @return le nombre d'athlètes
     */
    public int nombreAthletes() {
        return this.lesAthletes.size();
    }

    @Override
    public String toString() {
        return "Pays [nom=" + nom + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Pays))
            return false;
        Pays tmp = (Pays) obj;
        return this.nom.equals(tmp.nom);
    }

    @Override
    public int hashCode() {
        return this.nom.hashCode();
    }

}
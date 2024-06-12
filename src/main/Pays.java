package main;


import java.util.ArrayList;
import java.util.List;

public class Pays {

    private String nom;
    private List<Equipe> lesEquipes;
    private List<Athlete> lesAthletes;

    
    /** Constructeur qui met à jour les attributs de la classe Pays
     * @param nom
     */
    public Pays(String nom) {
        this.nom = nom;
        this.lesEquipes = new ArrayList<>();
        this.lesAthletes = new ArrayList<>();
    }

    
    /** Ajoute une équipe d'athlètes dans la liste des équipes du pays
     * @param equipe
     */
    public void enregistrerEquipe(Equipe equipe) {
        this.lesEquipes.add(equipe);
    }

    
    /** Ajoute un athlète à la liste des athlètes du pays
     * @param athlete
     */
    public void enregistrerAthlete(Athlete athlete) {
        this.lesAthletes.add(athlete);
    }

    
    /** Supprime une équipe de la liste des équipes du pays
     * @param equipe
     */
    public void supprimerEquipe(Equipe equipe) {
        this.lesEquipes.remove(equipe);
    }

    
    /** Supprime un athlète de la liste des athlètes du pays
     * @param athlete
     */
    public void supprimerAthlete(Athlete athlete) {
        this.lesAthletes.remove(athlete);
    }

    
    /** Récupère la liste des équipes d'un pays
     * @return la liste des équipes
     */
    public List<Equipe> getLesEquipes() {
        return lesEquipes;
    }

    
    /** Récupère la liste des athlètes d'un pays
     * @return la liste des athlètes
     */
    public List<Athlete> getLesAthletes() {
        return lesAthletes;
    }

    
    /** Récupère le nom du pays
     * @return le nom du pays
     */
    public String getNom() {
        return nom;
    }


    /** Fixe le nom d'un pays
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    
    /** Compte le nombre d'athlètes individuels du pays
     * @return le nombre d'athlètes
     */
    public int nombreAthletes() {
        return this.lesAthletes.size();
    }
}
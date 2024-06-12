package main.java.com.cdal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
/**
 * Classe représentant les Jeux Olympiques.
 * Cette classe gère les pays participants, les sports disputés, et les participations aux différentes épreuves.
 * Elle permet d'ajouter des pays, des sports, d'enregistrer des épreuves, de lancer des épreuves et d'inscrire des participants.
 */
public class JeuOlympiques {
    private List<Pays> lesPays; // Liste des pays participants.
    private List<Sport> lesSports; // Liste des sports disputés.
    private Map<Epreuve, Set<Participer>> lesParticipations; // Map des participations aux épreuves.

    /**
     * Constructeur avec paramètres pour initialiser les jeux olympiques avec des listes spécifiques de pays, sports et participations.
     * 
     * @param lesPays Liste des pays participants.
     * @param lesSports Liste des sports disputés.
     * @param lesParticipations Map des participations aux épreuves.
     */
    public JeuOlympiques(List<Pays> lesPays, List<Sport> lesSports, Map<Epreuve, Set<Participer>> lesParticipations) {
        this.lesPays = new ArrayList<>(lesPays);
        this.lesSports = new ArrayList<>(lesSports);
        this.lesParticipations = new HashMap<>(lesParticipations);
    }

    /**
     * Constructeur par défaut pour initialiser les jeux olympiques sans pays, sports ou participations pré-définis.
     */
    public JeuOlympiques() {
        this.lesPays = new ArrayList<>();
        this.lesSports = new ArrayList<>();
        this.lesParticipations = new HashMap<>();
    }

    
    /**
     * Retourne la liste des pays participants aux Jeux Olympiques.
     * 
     * @return Une liste de {@link Pays} représentant les pays participants.
     */
    public List<Pays> getLesPays() {
        return lesPays;
    }
    
    /**
     * Retourne la liste des sports disputés aux Jeux Olympiques.
     * 
     * @return Une liste de {@link Sport} représentant les sports disputés.
     */
    public List<Sport> getLesSports() {
        return lesSports;
    }
    
    /**
     * Retourne la map des participations aux épreuves des Jeux Olympiques.
     * 
     * @return Une map avec les épreuves comme clés et un ensemble de {@link Participer} comme valeurs.
     */
    public Map<Epreuve, Set<Participer>> getLesParticipations() {
        return lesParticipations;
    }
    
    /**
     * Ajoute un pays à la liste des pays participants, si ce n'est pas déjà fait.
     * 
     * @param nom Le nom du pays à ajouter.
     */
    public void ajouterPays(String nom) {
        Pays tmp = new Pays(nom);
        if (!(this.getLesPays().contains(tmp))) {
            this.getLesPays().add(tmp);
        }
    }
    
    /**
     * Ajoute un sport à la liste des sports disputés.
     * 
     * @param s Le sport à ajouter.
     */
    public void ajouterSport(Sport s) {
        this.getLesSports().add(s);
    }
    
    /**
     * Enregistre une épreuve dans la map des participations, initialisant un ensemble vide de participants.
     * 
     * @param e L'épreuve à enregistrer.
     */
    public void enregistrerEpreuve(Epreuve e) {
        this.lesParticipations.put(e, new HashSet<Participer>());
    }
    
    /**
     * Lance une épreuve et calcule les résultats pour chaque participant.
     * 
     * @param e L'épreuve à lancer.
     * @return Une map associant chaque participant à son résultat dans l'épreuve.
     */
    public Map<Participer, Double> lancerEpreuve(Epreuve e) {
        Map<Participer, Double> resultatEpreuve = new HashMap<>();
        for (Participer p : this.getLesParticipations().get(e)) {
            resultatEpreuve.put(p, p.participer(e));
        }
    
        return resultatEpreuve;
    }
    
    /**
     * Inscrit un participant à une épreuve spécifique.
     * 
     * @param participants Le participant à inscrire.
     * @param epreuve L'épreuve à laquelle inscrire le participant.
     */
    public void inscrire(Participer participants, Epreuve epreuve) {
        this.lesParticipations.get(epreuve).add(participants);
    }

}

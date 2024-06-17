package main.java.com.cdal;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import main.java.com.cdal.util.*;

/**
 * Classe représentant les Jeux Olympiques.
 * Cette classe gère les pays participants, les sports disputés, et les
 * participations aux différentes épreuves.
 * Elle permet d'ajouter des pays, des sports, d'enregistrer des épreuves, de
 * lancer des épreuves et d'inscrire des participants.
 */
public class JeuxOlympiques {
    private List<Pays> lesPays; // Liste des pays participants.
    private List<Sport> lesSports; // Liste des sports disputés.
    private Map<Epreuve, Set<Participer>> lesParticipations; // Map des participations aux épreuves.
    private Map<Epreuve, Map<Participer, Double>> resultats; // Map des résultats des épreuves.

    /**
     * Constructeur avec paramètres pour initialiser les jeux olympiques avec des
     * listes spécifiques de pays, sports et participations.
     * 
     * @param lesPays           Liste des pays participants.
     * @param lesSports         Liste des sports disputés.
     * @param lesParticipations Map des participations aux épreuves.
     * @param resultats         Map des résultats des épreuves.
     */
    public JeuxOlympiques(List<Pays> lesPays, List<Sport> lesSports, Map<Epreuve, Set<Participer>> lesParticipations,
            Map<Epreuve, Map<Participer, Double>> resultats) {
        this.lesPays = new ArrayList<>(lesPays);
        this.lesSports = new ArrayList<>(lesSports);
        this.lesParticipations = new HashMap<>(lesParticipations);
        this.resultats = new HashMap<>(resultats);
    }

    /**
     * Constructeur par défaut pour initialiser les jeux olympiques sans pays,
     * sports ou participations pré-définis.
     */
    public JeuxOlympiques() {
        this.lesPays = new ArrayList<>();
        this.lesSports = new ArrayList<>();
        this.lesParticipations = new HashMap<>();
        this.resultats = new HashMap<>();
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
     * @return Une map avec les épreuves comme clés et un ensemble de
     *         {@link Participer} comme valeurs.
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
     * Enregistre une épreuve dans la map des participations, initialisant un
     * ensemble vide de participants.
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
     * Enregistre le résultat d'une épreuve donnée.
     * Cette méthode lance l'épreuve spécifiée, récupère les résultats sous forme
     * d'une Map où chaque participant
     * est associé à son score, puis stocke ces résultats dans la Map des résultats
     * de l'instance.
     *
     * @param e L'épreuve dont le résultat doit être enregistré.
     */
    public void enregistrerResultat(Epreuve e) {
        Map<Participer, Double> resultatEpreuve = lancerEpreuve(e);
        this.resultats.put(e, resultatEpreuve);
    }

    public ArrayList<Couple<Participer, Double>> trierResultats(Epreuve e) {
        ArrayList<Couple<Participer, Double>> resultatEpreuve = new ArrayList<>();
        if (this.resultats.keySet().contains(e)) {
            for (Map.Entry<Participer, Double> entry : this.resultats.get(e).entrySet()) {
                resultatEpreuve.add(new Couple<>(entry.getKey(), entry.getValue()));
            }
            Collections.sort(resultatEpreuve, new Comparator<Couple<Participer, Double>>() {
                @Override
                public int compare(Couple<Participer, Double> o1, Couple<Participer, Double> o2) {
                    return o1.getSecond().compareTo(o2.getSecond());
                }

            });
            return resultatEpreuve;
        }
        return new ArrayList<>();
    }

    public void attribuerMedailles(Epreuve e) {
        ArrayList<Couple<Participer, Double>> resultatEpreuve = trierResultats(e);
        for (int i = 0; i < 3 && i < resultatEpreuve.size(); i++) {
            switch (i) {
                case 0:
                    resultatEpreuve.get(i).getPremier().getPays().addMedailles("Or");
                    ;
                    break;
                case 1:
                    resultatEpreuve.get(i).getPremier().getPays().addMedailles("Argent");
                    ;
                    break;
                case 2:
                    resultatEpreuve.get(i).getPremier().getPays().addMedailles("Bronze");
                    break;
            }
        }
    }

    public Map<Epreuve, Map<Participer, Double>> getResultats() {
        return this.resultats;
    }

    public Pays getPays(String nom) {
        for (Pays p : this.getLesPays()) {
            if (p.getNom().equals(nom)) {
                return p;
            }
        }
        return null;
    }

    public Sport getSport(String nom) {
        for (Sport s : this.getLesSports()) {
            if (s.getNom().equals(nom)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Inscrit un participant à une épreuve spécifique.
     * 
     * @param participants Le participant à inscrire.
     * @param epreuve      L'épreuve à laquelle inscrire le participant.
     */
    public void inscrire(Participer participants, Epreuve epreuve) {
        this.lesParticipations.get(epreuve).add(participants);
    }

    public void chargerDonneeCSV(String chemin) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(chemin));
        String ligne = br.readLine();
        // Nom,Prénom,Sexe,Pays,Épreuve,Force,Endurance,agilite
        while ((ligne = br.readLine()) != null) {
            String[] donnees = ligne.split(",");
            Athlete a = new Athlete(donnees[0], donnees[1], donnees[2].charAt(0), Double.parseDouble(donnees[5]),
                    Double.parseDouble(donnees[6]), Double.parseDouble(donnees[7]), new Pays(donnees[3]));
            String[] sport = donnees[4].split(" ");

            Map<Caracteristique, Double> LesCoefficients = new HashMap<>();

            Unite uniteBis;

            switch (sport[0]) {
                case "Natation": {
                    LesCoefficients.put(Caracteristique.ENDURANCE, 7.0);
                    LesCoefficients.put(Caracteristique.FORCE, 5.0);
                    LesCoefficients.put(Caracteristique.AGILITE, 4.0);
                    uniteBis = Unite.TEMPS;
                    break;
                }
                // double force, double agilite, double endurance, Unite unite
                case "Athlétisme": {
                    LesCoefficients.put(Caracteristique.ENDURANCE, 4.0);
                    LesCoefficients.put(Caracteristique.FORCE, 6.0);
                    LesCoefficients.put(Caracteristique.AGILITE, 8.0);
                    uniteBis = Unite.TEMPS;
                    break;
                }
                case "Handball": {
                    LesCoefficients.put(Caracteristique.ENDURANCE, 8.0);
                    LesCoefficients.put(Caracteristique.FORCE, 7.0);
                    LesCoefficients.put(Caracteristique.AGILITE, 5.0);
                    uniteBis = Unite.POINT;
                    break;
                }
                case "Volley-Ball": {
                    LesCoefficients.put(Caracteristique.ENDURANCE, 8.0);
                    LesCoefficients.put(Caracteristique.FORCE, 6.0);
                    LesCoefficients.put(Caracteristique.AGILITE, 4.0);
                    uniteBis = Unite.POINT;
                    break;
                }
                case "Escrime": {
                    LesCoefficients.put(Caracteristique.ENDURANCE, 7.0);
                    LesCoefficients.put(Caracteristique.FORCE, 3.0);
                    LesCoefficients.put(Caracteristique.AGILITE, 6.0);
                    uniteBis = Unite.POINT;
                    break;
                }
                default: {
                    uniteBis = Unite.POINT;
                    break;
                }
            }

            Sport s = new Sport(sport[0], LesCoefficients.get(Caracteristique.FORCE),
                    LesCoefficients.get(Caracteristique.ENDURANCE), LesCoefficients.get(Caracteristique.AGILITE),
                    uniteBis);

            String nomEpreuve = "";
            if (sport.length == 1) {
                nomEpreuve = sport[0];
            } else {
                for (int i = 1; i < sport.length; i++) {
                    nomEpreuve += sport[i] + " ";
                }
            }
            Epreuve e = new Epreuve(nomEpreuve, 100, donnees[2].charAt(0), s);
            Pays p = new Pays(donnees[3]);

            if (!this.getLesPays().contains(p)) {
                this.getLesPays().add(p);
            } else {
                p = this.getLesPays().get(this.getLesPays().indexOf(p));
            }
            p.enregistrerAthlete(a);

            this.lesParticipations.computeIfAbsent(e, k -> new HashSet<>());

            if (Arrays.asList("Handball", "Volley-Ball").contains(sport[0])
                    || Arrays.asList(sport).contains("relais")) {
                Equipe eq = new Equipe(s.getNom(), p);
                if (!p.getLesEquipes().contains(eq)) {
                    p.enregistrerEquipe(eq);
                } else {
                    eq = p.getLesEquipes().get(p.getLesEquipes().indexOf(eq));
                }
                eq.ajouterMembre(a);
            }

            if (!this.getLesSports().contains(s)) {
                this.getLesSports().add(s);
            } else {
                s = this.getLesSports().get(this.getLesSports().indexOf(s));
            }
            s.enregistrerEpreuve(e);
        }
        br.close();
    }

}

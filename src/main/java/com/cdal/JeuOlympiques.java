package main.java.com.cdal;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Classe représentant les Jeux Olympiques.
 * Cette classe gère les pays participants, les sports disputés, et les
 * participations aux différentes épreuves.
 * Elle permet d'ajouter des pays, des sports, d'enregistrer des épreuves, de
 * lancer des épreuves et d'inscrire des participants.
 */
public class JeuOlympiques {
    private List<Pays> lesPays; // Liste des pays participants.
    private List<Sport> lesSports; // Liste des sports disputés.
    private Map<Epreuve, Set<Participer>> lesParticipations; // Map des participations aux épreuves.
    private <Epreuve,  Map<Participer, Double>> resultats;

    /**
     * Constructeur avec paramètres pour initialiser les jeux olympiques avec des
     * listes spécifiques de pays, sports et participations.
     * 
     * @param lesPays           Liste des pays participants.
     * @param lesSports         Liste des sports disputés.
     * @param lesParticipations Map des participations aux épreuves.
     */
    public JeuOlympiques(List<Pays> lesPays, List<Sport> lesSports, Map<Epreuve, Set<Participer>> lesParticipations) {
        this.lesPays = new ArrayList<>(lesPays);
        this.lesSports = new ArrayList<>(lesSports);
        this.lesParticipations = new HashMap<>(lesParticipations);
    }

    /**
     * Constructeur par défaut pour initialiser les jeux olympiques sans pays,
     * sports ou participations pré-définis.
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
                    Double.parseDouble(donnees[6]), Double.parseDouble(donnees[7]));
            String[] sport = donnees[4].split(" ");
            Sport s = new Sport(sport[0], 1.0, 1.0, 1.0, Unite.TEMPS); // ! Les coefficients et les unites sont
                                                                       // arbitraires
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
                p.enregistrerAthlete(a);
                this.getLesPays().add(p);
            } else {
                p = this.getLesPays().get(this.getLesPays().indexOf(p));
                p.enregistrerAthlete(a);
            }

            if (!(this.lesParticipations.keySet().contains(e))) {
                this.lesParticipations.put(e, new HashSet<Participer>());
            }

            List<String> lesNomsDesSportsCollective = new ArrayList<>(Arrays.asList("Handball", "Volley-Ball"));
            if (lesNomsDesSportsCollective.contains(sport[0])) {
                Equipe eq = new Equipe(s.getNom(), p);
                if (p.getLesEquipes().contains(eq)) {
                    eq = p.getLesEquipes().get(p.getLesEquipes().indexOf(eq));
                    eq.ajouterMembre(a);
                } else {
                    eq.ajouterMembre(a);
                    p.enregistrerEquipe(eq);
                }
            }

            if (!this.getLesSports().contains(s)) {
                s.enregistrerEpreuve(e);
                this.getLesSports().add(s);
            } else {
                this.getLesSports().get(this.getLesSports().indexOf(s)).enregistrerEpreuve(e);
            }
        }
        br.close();
    }

}

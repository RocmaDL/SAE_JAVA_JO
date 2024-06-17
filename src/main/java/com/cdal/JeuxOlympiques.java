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
import java.util.LinkedList;

/**
 * Classe représentant les Jeux Olympiques.
 * Cette classe gère les pays participants, les sports disputés, et les
 * participations aux différentes épreuves.
 * Elle permet d'ajouter des pays, des sports, d'enregistrer des épreuves, de
 * lancer des épreuves et d'inscrire des participants.
 */
public class JeuxOlympiques  {
    private List<Pays> lesPays; // Liste des pays participants.
    private List<Sport> lesSports; // Liste des sports disputés.
    private Map<Epreuve, Set<Participer>> lesParticipations; // Map des participations aux épreuves.
    private Map<Epreuve,  Map<Participer, Double>> resultats; // Map des résultats des épreuves.

    /**
     * Constructeur avec paramètres pour initialiser les jeux olympiques avec des
     * listes spécifiques de pays, sports et participations.
     * 
     * @param lesPays           Liste des pays participants.
     * @param lesSports         Liste des sports disputés.
     * @param lesParticipations Map des participations aux épreuves.
     * @param resultats         Map des résultats des épreuves.
     */
    public JeuxOlympiques(List<Pays> lesPays, List<Sport> lesSports, Map<Epreuve, Set<Participer>> lesParticipations, Map<Epreuve,  Map<Participer, Double>> resultats) {
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
     * Cette méthode lance l'épreuve spécifiée, récupère les résultats sous forme d'une Map où chaque participant
     * est associé à son score, puis stocke ces résultats dans la Map des résultats de l'instance.
     *
     * @param e L'épreuve dont le résultat doit être enregistré.
     */
    public void enregistrerResultat(Epreuve e ) {
        Map<Participer, Double> resultatEpreuve = lancerEpreuve(e);
        this.resultats.put(e, resultatEpreuve);
    }


    public Map<Participer, Double> trierResultatsParSexe(Epreuve e, char sexe){
        Map<Participer, Double> resultatEpreuve = lancerEpreuve(e);
        List<Double> lesResultats = new ArrayList<>(resultatEpreuve.values());
        Collections.sort(lesResultats);


        LinkedList liste = new LinkedList<>(resultatEpreuve.entrySet() );
        Collections.sort(liste, new Comparator<>());

        Map<Participer, Double> resultatEpreuveTriee = new HashMap<>();
        for (Participer p : this.getLesParticipations().get(e)) {
            if (p instanceof Athlete && ((Athlete) p).getSexe() == sexe) { 
                resultatEpreuve.remove(p);



            }

    
        }
    }

    

    
    
    
   


    
    public void attribuerMedailles (Epreuve e ){
        Map<Participer, Double> resEpreuve = this.resultats.get(e);   // !!! Prendre les résultats triées de l'épreuve e
        for (int i = 0; i < 3 ; i++) {
            Participer p = (Participer) resEpreuve.keySet().toArray()[i];
            Pays pays = p.getPays();

            switch(i){
                case 0 :
                    {
                    pays.addMedailles("Or"); 

                    }
                case 1 :
                    {
                    pays.addMedailles("Argent");
                }
                case 2 :
                    {
                    pays.addMedailles("Bronze");

                    }
            }
           
            
        }



        // On récupère le pays du premier, du dueuxième et du troisième d'une Epreuve
        // Puis on leur ajoute une médaille
        // Une en Or, une en Argent et une en Bronze

        

    }



    public Map<Epreuve,  Map<Participer, Double>> getResultats() {
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
                    Double.parseDouble(donnees[6]), Double.parseDouble(donnees[7]),new Pays(donnees[3]));  // !!! Changement du constructeur car besoin dans fonction AttribuerMedailles
            String[] sport = donnees[4].split(" ");

            Map<Caracteristique, Double> LesCoefficients = new HashMap<>();

            
            
            switch (sport[0]) {
                case "Natation":
                    {
                        LesCoefficients.put(Caracteristique.ENDURANCE, 7.0);
                        LesCoefficients.put(Caracteristique.FORCE, 5.0);
                        LesCoefficients.put(Caracteristique.AGILITE, 4.0);
                        Unite uniteBis = Unite.TEMPS;
                        break;
                    }
            // double force, double agilite, double endurance, Unite unite
                case "Athlétisme":
                    {
                        LesCoefficients.put(Caracteristique.ENDURANCE, 4.0);
                        LesCoefficients.put(Caracteristique.FORCE, 6.0);
                        LesCoefficients.put(Caracteristique.AGILITE, 8.0);
                        Unite uniteBis = Unite.TEMPS;
                        break;
                    }
                case "Handball":
                    {
                        LesCoefficients.put(Caracteristique.ENDURANCE, 8.0);
                        LesCoefficients.put(Caracteristique.FORCE, 7.0);
                        LesCoefficients.put(Caracteristique.AGILITE, 5.0);
                        Unite uniteBis = Unite.POINT;
                        break;
                    }
                case "Volley-Ball":
                    {
                        LesCoefficients.put(Caracteristique.ENDURANCE, 8.0);
                        LesCoefficients.put(Caracteristique.FORCE, 6.0);
                        LesCoefficients.put(Caracteristique.AGILITE, 4.0);
                        Unite uniteBis = Unite.POINT;
                        break;
                    }
                case "Escrime":
                    {
                        LesCoefficients.put(Caracteristique.ENDURANCE, 7.0);
                        LesCoefficients.put(Caracteristique.FORCE, 3.0);
                        LesCoefficients.put(Caracteristique.AGILITE, 6.0);
                        Unite uniteBis = Unite.POINT;
                        break;
                    }
                case "Athlétisme relais 400m":
                    {
                        LesCoefficients.put(Caracteristique.ENDURANCE, 9.0);
                        LesCoefficients.put(Caracteristique.FORCE, 7.0);
                        LesCoefficients.put(Caracteristique.AGILITE, 5.0);
                        Unite uniteBis = Unite.TEMPS;
                        break;
                    }
                case "Natation relais libre":
                    {
                        LesCoefficients.put(Caracteristique.ENDURANCE, 7.0);
                        LesCoefficients.put(Caracteristique.FORCE, 5.0);
                        LesCoefficients.put(Caracteristique.AGILITE, 4.0);
                        Unite uniteBis = Unite.TEMPS;
                        break;
                    }
                default:
                    {
                        Unite uniteBis = Unite.POINT;
                        break;
                    }
            }
            
            
            Sport s = new Sport(sport[0], LesCoefficients.get(Caracteristique.FORCE), LesCoefficients.get(Caracteristique.ENDURANCE), LesCoefficients.get(Caracteristique.AGILITE), uniteBis); // ! Les coefficients et les unites sont arbitraires

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

            List<String> lesNomsDesSportsCollectifs = new ArrayList<>(Arrays.asList("Handball", "Volley-Ball","Athlétisme relais 400m","Natation relais libre"));
            if (lesNomsDesSportsCollectifs.contains(sport[0])) {
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
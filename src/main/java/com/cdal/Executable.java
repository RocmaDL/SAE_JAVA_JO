package main.java.com.cdal;

import java.util.ArrayList;

import main.java.com.cdal.model.JeuxOlympiques;
import main.java.com.cdal.model.Pays;

public class Executable {
    public static void main(String[] args) {
        JeuxOlympiques jo = new JeuxOlympiques();
        try {
            jo.chargerDonneeCSV("donnees.csv");
            System.out.println("Données chargées avec succès" + "\n");
            System.out.println("Nombre de pays : " + jo.getLesPays().size() + "\n");
            System.out.println("Liste des pays : ");
            jo.getLesPays().forEach(p -> {
                System.out.println(p.getNom());
            });

            System.out.println("\n" + "Nombre de sports : " + jo.getLesSports().size() + "\n");
            System.out.println("Liste des sports : ");
            jo.getLesSports().forEach(s -> {
                System.out.println(s.getNom());
            });

            System.out.println("\n" + "Nombre d'épreuves : " + jo.getLesParticipations().size() + "\n");
            System.out.println("Liste des épreuves : ");
            jo.getLesParticipations().keySet().forEach(ep -> {
                System.out.println(ep);
            });

        } catch (Exception e) {
            System.out.println("Erreur lors du chargement des données");
        }
        Pays france;
        try {
            france = jo.getPays("France");
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération du pays");
            france = new Pays("France");
        }
        System.out.println(france);
        System.out.println("\n" + "Nombre d'athlètes : " + france.getLesAthletes().size() + "\n");
        System.out.println("\n" + "Liste des athlètes français : ");
        france.getLesAthletes().forEach(a -> {
            System.out.println(a.getNomAt() + " " + a.getPrenomAt());
        });

        System.out.println("\n" + "Nombre d'équipes : " + france.getLesEquipes().size() + "\n");
        System.out.println("\n" + "Liste des équipes" + "\n");
        france.getLesEquipes().forEach(e -> {
            System.out.println(e.getNomEq());
        });
        System.out.println("");
    }
}

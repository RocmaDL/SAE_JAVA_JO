package main.java.com.cdal.model.bd;

import java.sql.*;
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

import main.java.com.cdal.model.*;

public class JOJeuxOlympiquesBD { // ! Implémenter les requetes pour trouver les autres attributs

    private ConnexionMySQL laConnexionMySQL;
    private Statement st;

    public JOJeuxOlympiquesBD(ConnexionMySQL laConnexionMySQL) {
        this.laConnexionMySQL = laConnexionMySQL;
    }

    public JeuxOlympiques sqlToJO() throws SQLException {
        ArrayList<Pays> lesPays = new JOPaysBD(this.laConnexionMySQL).AllJOPays();
        ArrayList<Sport> lesSports = new JOSportBD(this.laConnexionMySQL).AllJOSport();
        ArrayList<Epreuve> lesEpreuves = new JOEpreuveBD(this.laConnexionMySQL).AllJOEpreuve();
        ArrayList<Equipe> lesEquipes = new JOEquipeBD(this.laConnexionMySQL).AllJOEquipe();
        ArrayList<Athlete> lesAthletes = new JOAthleteBD(this.laConnexionMySQL).AllJOAthlete();
        Map<Epreuve, Set<Participer>> lesInscriptions = new JOSinscrireBD(this.laConnexionMySQL).getLesParticipations();
        Map<Epreuve, Map<Participer, Double>> resultats = new JOParticiperResultat(this.laConnexionMySQL)
                .getLesResultats();

        for (Epreuve e : lesEpreuves) {
            e.getSport().enregistrerEpreuve(e);
        }

        for (Equipe eq : lesEquipes) {
            eq.getPays().enregistrerEquipe(eq);
        }

        for (Athlete a : lesAthletes) {
            a.getPays().enregistrerAthlete(a);
        }

        return new JeuxOlympiques(lesPays, lesSports, lesInscriptions, resultats);
    }

    public void JOtosql(JeuxOlympiques jo) throws SQLException {
        for (Pays p : jo.getLesPays()) {
            new JOPaysBD(this.laConnexionMySQL).createJOPays(p);
            for (Athlete a : p.getLesAthletes()) {
                new JOAthleteBD(this.laConnexionMySQL).createJOAthlete(a);
            }

            for (Equipe eq : p.getLesEquipes()) {
                new JOEquipeBD(this.laConnexionMySQL).createJOEquipe(eq);
            }
        }

        for (Sport s : jo.getLesSports()) {
            new JOSportBD(this.laConnexionMySQL).createJOSport(s);
            for (Epreuve e : s.getlesEpreuves()) {
                new JOEpreuveBD(this.laConnexionMySQL).createJOEpreuve(e);
            }
        }

        for (Map.Entry<Epreuve, Set<Participer>> entry : jo.getLesParticipations().entrySet()) {
            for (Participer p : entry.getValue()) {
                if (p instanceof Athlete) {
                    new JOSinscrireBD(this.laConnexionMySQL).createJOSinscrire(entry.getKey(), (Athlete) p);
                } else {
                    new JOSinscrireBD(this.laConnexionMySQL).createJOSinscrire(entry.getKey(), (Equipe) p);
                }
            }
        }

        for (Map.Entry<Epreuve, Map<Participer, Double>> entry : jo.getResultats().entrySet()) {
            for (Map.Entry<Participer, Double> entry2 : entry.getValue().entrySet()) {
                if (entry2.getKey() instanceof Athlete) {
                    new JOParticiperResultat(this.laConnexionMySQL).createJOParticiperResultat(entry.getKey(),
                            (Athlete) entry2.getKey(),
                            entry2.getValue());
                } else {
                    new JOParticiperResultat(this.laConnexionMySQL).createJOParticiperResultat(entry.getKey(),
                            (Equipe) entry2.getKey(), entry2.getValue());
                }
            }
        }
    }

    public void csvToSQL(String chemin) throws SQLException, Exception {
        JeuxOlympiques jo = new JeuxOlympiques();
        jo.chargerDonneeCSV(chemin);
        JOtosql(jo);
    }

}

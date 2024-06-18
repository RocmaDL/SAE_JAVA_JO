

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class BD {
    private ConnexionMySQL laConnexion;

    public BD(ConnexionMySQL laConnexion) {
        this.laConnexion = laConnexion;
    }

    public void csvToSQL(String cheminCSV) throws SQLException {
        PreparedStatement athleteStmt = null;
        PreparedStatement epreuveStmt = null;
        BufferedReader reader = null;
        String line = "";
        boolean premiereLigne = true; // Pour ne pas prendre en compte la premiere ligne

        try {
            String requeteAthlete = "INSERT INTO ATHLETE (idAthlete, prenom, nom, sexe, force_, agilite, endurance, pays) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            athleteStmt = this.laConnexion.prepareStatement(requeteAthlete);

            String requeteEpreuve = "INSERT INTO EPREUVE(idEpreuve, nom) VALUES (?, ?)";
            epreuveStmt = this.laConnexion.prepareStatement(requeteEpreuve);

            reader = new BufferedReader(new FileReader(cheminCSV));
            int idAthlete = 1;
            int idEpreuve = 1;

            Set<String> sportsExistants = getExistingSports();



            while ((line = reader.readLine()) != null) {
                if(premiereLigne){
                    premiereLigne=false;
                    continue;
                }
                String[] row = line.split(",");
                String nom = row[0];
                String prenom = row[1];
                char sexe = row[2].charAt(0);
                String pays = row[3];
                String sport = row[4];

                int force = Integer.parseInt(row[5]);
                int endurance = Integer.parseInt(row[6]);
                int agilite = Integer.parseInt(row[7]);

                athleteStmt.setInt(1, idAthlete);
                athleteStmt.setString(2, prenom);
                athleteStmt.setString(3, nom);
                athleteStmt.setString(4, String.valueOf(sexe));
                athleteStmt.setInt(5, force);
                athleteStmt.setInt(6, agilite);
                athleteStmt.setInt(7, endurance);
                athleteStmt.setString(8, pays);
                athleteStmt.executeUpdate();

                if (!sportsExistants.contains(sport)) {
                    epreuveStmt.setInt(1, idEpreuve);
                    epreuveStmt.setString(2, sport);
                    epreuveStmt.executeUpdate();
                    sportsExistants.add(sport);
                    idEpreuve++;
                }

                idAthlete++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Erreur lors du traitement du fichier CSV.");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (athleteStmt != null) athleteStmt.close();
            if (epreuveStmt != null) epreuveStmt.close();
            this.laConnexion.close();
        }
    }

    private Set<String> getExistingSports() throws SQLException {
        Set<String> sports = new HashSet<>();
        Statement stm = this.laConnexion.createStatement();
        ResultSet rs = stm.executeQuery("SELECT nom FROM EPREUVE");
        while (rs.next()) {
            sports.add(rs.getString("nom"));
        }
        rs.close();
        stm.close();
        return sports;
    }
}

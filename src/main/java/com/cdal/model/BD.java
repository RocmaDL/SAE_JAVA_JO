package main.java.com.cdal.model;


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
        PreparedStatement equipeStmt = null;
        PreparedStatement sportStmt = null;
        PreparedStatement paysStmt = null;
        BufferedReader reader = null;
        String line = "";
        boolean premiereLigne = true;

        try {
            String requeteAthlete = "INSERT INTO ATHLETE (idAthlete, prenomAthlete, nomAthlete, idSexe, force_, agilite, endurance, idPays, idEquipe) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            athleteStmt = this.laConnexion.prepareStatement(requeteAthlete);

            String requeteEpreuve = "INSERT INTO EPREUVE(idEpreuve, nomEpreuve, idSport) VALUES (?, ?, ?)";
            epreuveStmt = this.laConnexion.prepareStatement(requeteEpreuve);

            String requeteEquipe = "INSERT INTO EQUIPE(idEquipe, nomEquipe, idPays) VALUES (?, ?, ?)";
            equipeStmt = this.laConnexion.prepareStatement(requeteEquipe);

            String requeteSport = "INSERT INTO SPORT(idSport, nomSport) VALUES (?, ?)";
            sportStmt = this.laConnexion.prepareStatement(requeteSport);

            String requetePays = "INSERT INTO PAYS(idPays, nomPays) VALUES (?, ?)";
            paysStmt = this.laConnexion.prepareStatement(requetePays);

            reader = new BufferedReader(new FileReader(cheminCSV));
            int idAthlete = 1;
            int idEpreuve = 1;
            int idEquipe = 1;
            int idSport = 1;
            int idPays = getMaxId("PAYS") + 1; // Utilisation d'une méthode pour obtenir le prochain id disponible

            Set<String> sportsExistants = getLesSports();
            Set<String> paysExistants = getLesPays();
            Set<String> equipesExistantes = getLesEquipes();

            while ((line = reader.readLine()) != null) {
                if (premiereLigne) {
                    premiereLigne = false;
                    continue;
                }
                String[] row = line.split(",");
                String nom = row[0];
                String prenom = row[1]; // Assurez-vous que cette colonne existe dans votre fichier CSV et est
                                        // correctement indexée
                char sexe = row[2].charAt(0);
                String pays = row[3];
                String nomEpreuve = row[4];
                String sport = getNomSport(nomEpreuve);
                String nomEquipe = pays + " " + sport;

                int force = Integer.parseInt(row[5]);
                int endurance = Integer.parseInt(row[6]);
                int agilite = Integer.parseInt(row[7]);

                // Vérifier si le pays existe déjà
                if (!paysExistants.contains(pays)) {
                    paysStmt.setInt(1, idPays);
                    paysStmt.setString(2, pays);
                    paysStmt.executeUpdate();
                    paysExistants.add(pays);
                    idPays++;
                }

                // Vérifier si le sport existe déjà
                if (!sportsExistants.contains(sport)) {
                    sportStmt.setInt(1, idSport);
                    sportStmt.setString(2, sport);
                    sportStmt.executeUpdate();
                    sportsExistants.add(sport);
                    idSport++;
                }

                // Vérifier si l'équipe existe déjà
                if (!equipesExistantes.contains(nomEquipe)) {
                    equipeStmt.setInt(1, idEquipe);
                    equipeStmt.setString(2, nomEquipe);
                    equipeStmt.setInt(3, getPaysId(pays)); // Obtenir l'id du pays correspondant
                    equipeStmt.executeUpdate();
                    equipesExistantes.add(nomEquipe);
                    idEquipe++;
                }

                // Insertion de l'athlète
                athleteStmt.setInt(1, idAthlete);
                athleteStmt.setString(2, prenom); // Utiliser prenomAthlete
                athleteStmt.setString(3, nom); // Utiliser nomAthlete
                athleteStmt.setString(4, String.valueOf(sexe));
                athleteStmt.setInt(5, force);
                athleteStmt.setInt(6, agilite);
                athleteStmt.setInt(7, endurance);
                athleteStmt.setInt(8, getPaysId(pays)); // Obtenir l'id du pays correspondant
                athleteStmt.setInt(9, getEquipeId(nomEquipe)); // Obtenir l'id de l'équipe correspondante
                athleteStmt.executeUpdate();

                // Insertion de l'épreuve
                epreuveStmt.setInt(1, idEpreuve);
                epreuveStmt.setString(2, nomEpreuve);
                epreuveStmt.setInt(3, getSportId(sport)); // Obtenir l'id du sport correspondant
                epreuveStmt.executeUpdate();
                idEpreuve++;

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
            if (athleteStmt != null)
                athleteStmt.close();
            if (epreuveStmt != null)
                epreuveStmt.close();
            if (equipeStmt != null)
                equipeStmt.close();
            if (sportStmt != null)
                sportStmt.close();
            if (paysStmt != null)
                paysStmt.close();
            this.laConnexion.close();
        }
    }

    private int getMaxId(String tableName) throws SQLException {
        String query = "SELECT MAX(idPays) AS maxId FROM " + tableName;
        Statement stm = this.laConnexion.createStatement();
        ResultSet rs = stm.executeQuery(query);
        int maxId = 0;
        if (rs.next()) {
            maxId = rs.getInt("maxId");
        }
        rs.close();
        stm.close();
        return maxId;
    }

    private int getPaysId(String nomPays) throws SQLException {
        String query = "SELECT idPays FROM PAYS WHERE nomPays = ?";
        PreparedStatement pstmt = this.laConnexion.prepareStatement(query);
        pstmt.setString(1, nomPays);
        ResultSet rs = pstmt.executeQuery();
        int idPays = 0;
        if (rs.next()) {
            idPays = rs.getInt("idPays");
        }
        rs.close();
        pstmt.close();
        return idPays;
    }

    private int getEquipeId(String nomEquipe) throws SQLException {
        String query = "SELECT idEquipe FROM EQUIPE WHERE nomEquipe = ?";
        PreparedStatement pstmt = this.laConnexion.prepareStatement(query);
        pstmt.setString(1, nomEquipe);
        ResultSet rs = pstmt.executeQuery();
        int idEquipe = 0;
        if (rs.next()) {
            idEquipe = rs.getInt("idEquipe");
        }
        rs.close();
        pstmt.close();
        return idEquipe;
    }

    private int getSportId(String nomSport) throws SQLException {
        String query = "SELECT idSport FROM SPORT WHERE nomSport = ?";
        PreparedStatement pstmt = this.laConnexion.prepareStatement(query);
        pstmt.setString(1, nomSport);
        ResultSet rs = pstmt.executeQuery();
        int idSport = 0;
        if (rs.next()) {
            idSport = rs.getInt("idSport");
        }
        rs.close();
        pstmt.close();
        return idSport;
    }

    private Set<String> getLesSports() throws SQLException {
        Set<String> sports = new HashSet<>();
        Statement stm = this.laConnexion.createStatement();
        ResultSet rs = stm.executeQuery("SELECT nomSport FROM SPORT");
        while (rs.next()) {
            sports.add(rs.getString("nomSport"));
        }
        rs.close();
        stm.close();
        return sports;
    }

    private Set<String> getLesEquipes() throws SQLException {
        Set<String> equipes = new HashSet<>();
        Statement stm = this.laConnexion.createStatement();
        ResultSet rs = stm.executeQuery("SELECT nomEquipe FROM EQUIPE");
        while (rs.next()) {
            equipes.add(rs.getString("nomEquipe"));
        }
        rs.close();
        stm.close();
        return equipes;
    }

    private Set<String> getLesPays() throws SQLException {
        Set<String> paysExistants = new HashSet<>();
        Statement stm = this.laConnexion.createStatement();
        ResultSet rs = stm.executeQuery("SELECT nomPays FROM PAYS");
        while (rs.next()) {
            paysExistants.add(rs.getString("nomPays"));
        }
        rs.close();
        stm.close();
        return paysExistants;
    }

    private String getNomSport(String nomEpreuve) {
        // Assumez que le sport est la première partie du nomEpreuve jusqu'au premier
        // espace
        return nomEpreuve.split("\\s+")[0];

    }
}
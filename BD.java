import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class BD {
    private Connection laConnexion;
    private Statement st;

    /**
     * Constructeur de la classe BD.
     * @param laConnexion La connexion MySQL à utiliser.
     */
    public BD(Connection laConnexion) {
        this.laConnexion = laConnexion;
    }

    /**
     * Charge les données d'un fichier CSV et les insère dans les tables ATHLETE et EPREUVE.
     * @param cheminCSV Le chemin vers le fichier CSV contenant les données.
     * @throws SQLException En cas d'erreur SQL.
     */
    public void csvToSQL(String cheminCSV) throws SQLException {
        PreparedStatement athleteStmt = null;
        PreparedStatement epreuveStmt = null;
        BufferedReader reader = null;
        String line = ""; // pour stocker chaque ligne lue du fichier CSV

        try {
            // Prépare les requêtes SQL pour insérer les données
            String requeteAthlete = "INSERT INTO ATHLETE(idAthlete, prenom, nom, sexe, force_, agilite, endurance, pays) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            athleteStmt = this.laConnexion.prepareStatement(requeteAthlete);

            String requeteEpreuve = "INSERT INTO EPREUVE(idEpreuve, nom) VALUES (?, ?)";
            epreuveStmt = this.laConnexion.prepareStatement(requeteEpreuve);

            // Pour lire le fichier CSV
            reader = new BufferedReader(new FileReader(cheminCSV));
            // Initialise les identifiants des athlètes et des épreuves
            int idAthlete = 1;
            int idEpreuve = 1;

            // Récupère les sports existants dans la base de données
            Set<String> sportsExistants = getExistingSports();

            while ((line = reader.readLine()) != null) {
                String[] row = line.split(",");
                String nom = row[0];
                String prenom = row[1];
                char sexe = row[2].charAt(0);
                String pays = row[3];
                String sport = row[4];
                int force = Integer.parseInt(row[5]);
                int endurance = Integer.parseInt(row[6]);
                int agilite = Integer.parseInt(row[7]);

                // Insère dans la table ATHLETE
                athleteStmt.setInt(1, idAthlete);
                athleteStmt.setString(2, prenom);
                athleteStmt.setString(3, nom);
                athleteStmt.setString(4, String.valueOf(sexe));
                athleteStmt.setInt(5, force);
                athleteStmt.setInt(6, agilite);
                athleteStmt.setInt(7, endurance);
                athleteStmt.setString(8, pays);
                athleteStmt.executeUpdate();

                // Insère dans la table EPREUVE si le sport n'existe pas déjà
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

    /**
     * Récupère les sports existants dans la base de données.
     * @return Un ensemble de noms de sports existants.
     * @throws SQLException En cas d'erreur SQL.
     */
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
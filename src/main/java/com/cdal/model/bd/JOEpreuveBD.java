package main.java.com.cdal.model.bd;

import java.sql.*;
import java.util.ArrayList;
import main.java.com.cdal.model.*;

public class JOEpreuveBD {
    
    /*
     * idEpreuve INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
     * nomEpreuve VARCHAR(50),
     * sexeEpreuve CHAR(1),
     * idSport INT,
     * nombreAthletes INT,
     * FOREIGN KEY (idSport) REFERENCES JOSport(idSport)
     */

    ConnexionMySQL laConnexionMySQL;
    Statement st;

    public JOEpreuveBD(ConnexionMySQL laConnexionMySQL) {
        this.laConnexionMySQL = laConnexionMySQL;
    }

    public void createJOEpreuve(Epreuve e) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "insert into JOEpreuve(idEpreuve, nomEpreuve, sexeEpreuve, idSport, nombreAthletes) values(?,?,?,?,?)");
        ps.setInt(1, e.hashCode());
        ps.setString(2, e.getNomEpreuve());
        ps.setString(3, e.getSexe() + "");
        ps.setInt(4, e.getSport().hashCode());
        ps.setInt(5, e.getNombreAthletes()); // ! Ajout de l'attribut nombreAthletes
        ps.executeUpdate();
    }
    
    public Epreuve readJOEpreuve(int id) throws SQLException {
        Statement st = this.laConnexionMySQL.createStatement();
        ResultSet rs = st.executeQuery("select * from JOEpreuve where idEpreuve = " + id);
        if (rs.next()) {
            Sport s = new JOSportBD(this.laConnexionMySQL).readJOSport(rs.getInt("idSport"));
            return new Epreuve(rs.getString("nomEpreuve"), rs.getString("sexeEpreuve").charAt(0), s); // ! Ajout de l'attribut nombreAthletes
        } else {
            throw new SQLException("Epreuve non trouvée.");
        }
    }

    public void updateJOEpreuve(Epreuve e) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "update JOEpreuve set nomEpreuve = ?, sexeEpreuve = ?, idSport = ?, nombreAthletes = ? where idEpreuve = ?");
        ps.setString(1, e.getNomEpreuve());
        ps.setString(2, e.getSexe() + "");
        ps.setInt(3, e.getSport().hashCode());
        ps.setInt(4, e.getNombreAthletes()); // ! Ajout de l'attribut nombreAthletes
        ps.setInt(5, e.hashCode());
        ps.executeUpdate();
    }

    public void deleteJOEpreuve(int e) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement("delete from JOEpreuve where idEpreuve = ?");
        ps.setInt(1, e);
        ps.executeUpdate();
    }

    public ArrayList<Epreuve> AllJOEpreuve() throws SQLException {
        ArrayList<Epreuve> listeEpreuve = new ArrayList<Epreuve>();
        Statement st = this.laConnexionMySQL.createStatement();
        ResultSet rs = st.executeQuery("select * from JOEpreuve");
        while (rs.next()) {
            Sport s = new JOSportBD(this.laConnexionMySQL).readJOSport(rs.getInt("idSport"));
            Epreuve e = new Epreuve(rs.getString("nomEpreuve"), rs.getString("sexeEpreuve").charAt(0), s); // ! Ajout de l'attribut nombreAthletes
            listeEpreuve.add(e);
        }
        return listeEpreuve;
    }
}

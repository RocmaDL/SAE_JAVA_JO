package main.java.com.cdal.model.bd;

import java.sql.*;
import java.util.ArrayList;
import main.java.com.cdal.model.*;

public class JOAthleteBD {

    /*
     * idAthlete INT PRIMARY KEY,
     * prenomAthlete VARCHAR(50),
     * nomAthlete VARCHAR(50),
     * sexeAthlete CHAR(1),
     * forceAthlete INT,
     * agiliteAthlete INT,
     * enduranceAthlete INT,
     * idPays INT,
     * FOREIGN KEY (idPays) REFERENCES JOPays(idPays),
     */

    ConnexionMySQL laConnexionMySQL;
    Statement st;

    public JOAthleteBD(ConnexionMySQL laConnexionMySQL) {
        this.laConnexionMySQL = laConnexionMySQL;
    }

    public void createJOAthlete(Athlete a) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "insert into JOAthlete(idAthlete, prenomAthlete, nomAthlete, sexeAthlete, forceAthlete, agiliteAthlete, enduranceAthlete, idPays) values(?,?,?,?,?,?,?,?)");
        ps.setInt(1, a.hashCode());
        ps.setString(2, a.getPrenomAt());
        ps.setString(3, a.getNomAt());
        ps.setString(4, a.getSexe() + "");
        ps.setDouble(5, a.getForce());
        ps.setDouble(6, a.getAgilite());
        ps.setDouble(7, a.getEndurance());
        ps.setInt(8, a.getPays().hashCode());
        ps.executeUpdate();
    }

    public Athlete readJOAthlete(int id) throws SQLException {
        Statement st = this.laConnexionMySQL.createStatement();
        ResultSet rs = st.executeQuery("select * from JOAthlete where idAthlete = " + id);
        if (rs.next()) {
            Pays p = new JOPaysBD(this.laConnexionMySQL).readJOPays(rs.getInt("idPays"));
            return new Athlete(rs.getString("prenomAthlete"), rs.getString("nomAthlete"),
                    rs.getString("sexeAthlete").charAt(0), rs.getDouble("forceAthlete"), rs.getDouble("agiliteAthlete"),
                    rs.getDouble("enduranceAthlete"), p);
        } else {
            throw new SQLException("Athlete non trouvé.");
        }
    }

    public void updateJOAthlete(Athlete a) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "update JOAthlete set prenomAthlete = ?, nomAthlete = ?, sexeAthlete = ?, forceAthlete = ?, agiliteAthlete = ?, enduranceAthlete = ?, idPays = ? where idAthlete = ?");
        ps.setString(1, a.getPrenomAt());
        ps.setString(2, a.getNomAt());
        ps.setString(3, a.getSexe() + "");
        ps.setDouble(4, a.getForce());
        ps.setDouble(5, a.getAgilite());
        ps.setDouble(6, a.getEndurance());
        ps.setInt(7, a.getPays().hashCode());
        ps.setInt(8, a.hashCode());
        ps.executeUpdate();
    }

    public void deleteJOAthlete(int a) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement("delete from JOAthlete where idAthlete = ?");
        ps.setInt(1, a);
        ps.executeUpdate();
    }

    public ArrayList<Athlete> AllJOAthlete() throws SQLException {
        ArrayList<Athlete> lesAthletes = new ArrayList<Athlete>();
        Statement st = this.laConnexionMySQL.createStatement();
        ResultSet rs = st.executeQuery("select * from JOAthlete");
        while (rs.next()) {
            Pays p = new JOPaysBD(this.laConnexionMySQL).readJOPays(rs.getInt("idPays"));
            lesAthletes.add(new Athlete(rs.getString("prenomAthlete"), rs.getString("nomAthlete"),
                    rs.getString("sexeAthlete").charAt(0), rs.getDouble("forceAthlete"), rs.getDouble("agiliteAthlete"),
                    rs.getDouble("enduranceAthlete"), p));
        }
        return lesAthletes;
    }
}

package main.java.com.cdal.model.bd;

import java.sql.*;
import java.util.ArrayList;
import main.java.com.cdal.model.*;

public class JOSportBD {
    /*
     * idSport INT,
     * nomSport VARCHAR(50),
     * unite VARCHAR(20),
     * coefForce FLOAT,
     * coefAgilite FLOAT,
     * coefEndurance FLOAT
     */
    ConnexionMySQL laConnexionMySQL;
    Statement st;

    public JOSportBD(ConnexionMySQL laConnexionMySQL) {
        this.laConnexionMySQL = laConnexionMySQL;
    }

    public void createJOSport(Sport s) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "insert into JOSport(idSport, nomSport, unite, coefForce, coefAgilite, coefEndurance) values(?,?,?,?,?,?)");
        ps.setInt(1, s.hashCode());
        ps.setString(2, s.getNom());
        ps.setString(3, s.getUnite().getNom());
        ps.setDouble(4, s.getCoefForce());
        ps.setDouble(5, s.getCoefAgilite());
        ps.setDouble(6, s.getCoefEndurance());
        ps.executeUpdate();
    }

    public Sport readJOSport(int id) throws SQLException {
        Statement st = this.laConnexionMySQL.createStatement();
        ResultSet rs = st.executeQuery("select * from JOSport where idSport = " + id);
        if (rs.next()) {
            return new Sport(rs.getString("nomSport"), rs.getDouble("coefForce"),
                    rs.getDouble("coefAgilite"), rs.getDouble("coefEndurance"), Unite.fromNom(rs.getString("unite")));
        } else {
            throw new SQLException("Sport non trouvé.");
        }
    }

    public void updateJOSport(Sport s) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "update JOSport set nomSport = ?, unite = ?, coefForce = ?, coefAgilite = ?, coefEndurance = ? where idSport = ?");
        ps.setString(1, s.getNom());
        ps.setString(2, s.getUnite().getNom());
        ps.setDouble(3, s.getCoefForce());
        ps.setDouble(4, s.getCoefAgilite());
        ps.setDouble(5, s.getCoefEndurance());
        ps.setInt(6, s.hashCode());
        ps.executeUpdate();
    }

    public void deleteJOSport(int s) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement("delete from JOSport where idSport = ?");
        ps.setInt(1, s);
        ps.executeUpdate();
    }

    public ArrayList<Sport> AllJOSport() throws SQLException {
        ArrayList<Sport> listeSport = new ArrayList<Sport>();
        Statement st = this.laConnexionMySQL.createStatement();
        ResultSet rs = st.executeQuery("select * from JOSport");
        while (rs.next()) {
            Unite unite = Unite.fromNom(rs.getString("unite"));
            Sport s = new Sport(rs.getString("nomSport"), rs.getDouble("coefForce"),
                    rs.getDouble("coefAgilite"), rs.getDouble("coefEndurance"), unite);
            listeSport.add(s);
        }
        return listeSport;
    }
}

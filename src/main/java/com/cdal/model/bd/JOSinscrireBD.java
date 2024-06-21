package main.java.com.cdal.model.bd;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
import java.util.HashSet;

import main.java.com.cdal.model.*;

public class JOSinscrireBD {

    /*
     * idInscription INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
     * idAthlete INT,
     * idEq INT,
     * idEpreuve INT,
     * FOREIGN KEY (idAthlete) REFERENCES JOAthlete(idAthlete),
     * FOREIGN KEY (idEq) REFERENCES JOEquipe(idEq),
     * FOREIGN KEY (idEpreuve) REFERENCES JOEpreuve(idEpreuve),
     * CHECK ((idAthlete IS NOT NULL AND idEq IS NULL) OR (idAthlete IS NULL AND
     * idEq IS NOT NULL))
     */

    ConnexionMySQL laConnexionMySQL;
    Statement st;

    public JOSinscrireBD(ConnexionMySQL laConnexionMySQL) {
        this.laConnexionMySQL = laConnexionMySQL;
    }

    public void createJOSinscrire(Epreuve e, Athlete a) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "insert into JOSinscrire(idAthlete, idEpreuve, idEq) values(?,?,?)");
        ps.setInt(1, a.hashCode());
        ps.setInt(2, e.hashCode());
        ps.setNull(3, java.sql.Types.INTEGER);
        System.out.println(ps.toString());
        ps.executeUpdate();
    }

    public void createJOSinscrire(Epreuve e, Equipe eq) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "insert into JOSinscrire(idEq, idEpreuve, idAthlete) values(?,?,?)");
        ps.setInt(1, eq.hashCode());
        ps.setInt(2, e.hashCode());
        ps.setNull(3, java.sql.Types.INTEGER);
        System.out.println(ps.toString());
        ps.executeUpdate();
    }

    public void deleteJOSinscrire(Epreuve e, Athlete a) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "delete from JOSinscrire where idAthlete = ? and idEpreuve = ?");
        ps.setInt(1, a.hashCode());
        ps.setInt(2, e.hashCode());
        ps.executeUpdate();
    }

    public void deleteJOSinscrire(Epreuve e, Equipe eq) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "delete from JOSinscrire where idEq = ? and idEpreuve = ?");
        ps.setInt(1, eq.hashCode());
        ps.setInt(2, e.hashCode());
        ps.executeUpdate();
    }

    public ArrayList<Epreuve> readJOSinscrireAthlete(int a) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL
                .prepareStatement("select * from JOSinscrire where idAthlete = ?");
        ps.setInt(1, a);
        ResultSet rs = ps.executeQuery();
        ArrayList<Epreuve> lesEpreuves = new ArrayList<Epreuve>();
        while (rs.next()) {
            lesEpreuves.add(new JOEpreuveBD(this.laConnexionMySQL).readJOEpreuve(rs.getInt("idEpreuve")));
        }
        return lesEpreuves;
    }

    public ArrayList<Epreuve> readJOSinscrireEquipe(int e) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL
                .prepareStatement("select * from JOSinscrire where idEq = ?");
        ps.setInt(1, e);
        ResultSet rs = ps.executeQuery();
        ArrayList<Epreuve> lesEpreuves = new ArrayList<Epreuve>();
        while (rs.next()) {
            lesEpreuves.add(new JOEpreuveBD(this.laConnexionMySQL).readJOEpreuve(rs.getInt("idEpreuve")));
        }
        return lesEpreuves;
    }

    public Map<Epreuve, Set<Participer>> getLesParticipations() throws SQLException {
        Map<Epreuve, Set<Participer>> lesParticipations = new HashMap<>();
        Statement st = this.laConnexionMySQL.createStatement();
        ResultSet rs = st.executeQuery("select * from JOSinscrire");
        while (rs.next()) {
            Epreuve e = new JOEpreuveBD(this.laConnexionMySQL).readJOEpreuve(rs.getInt("idEpreuve"));
            if (!lesParticipations.containsKey(e)) {
                lesParticipations.put(e, new HashSet<Participer>());
            }
            if (rs.getInt("idAthlete") != 0) {
                Athlete a = new JOAthleteBD(this.laConnexionMySQL).readJOAthlete(rs.getInt("idAthlete"));
                lesParticipations.get(e).add(a);
            } else {
                Equipe eq = new JOEquipeBD(this.laConnexionMySQL).readJOEquipe(rs.getInt("idEq"));
                lesParticipations.get(e).add(eq);
            }
        }
        return lesParticipations;
    }
}

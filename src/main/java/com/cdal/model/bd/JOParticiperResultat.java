package main.java.com.cdal.model.bd;

import java.sql.*;
import java.util.ArrayList;
import main.java.com.cdal.model.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class JOParticiperResultat {

    /*
     * idResultat INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
     * resultat double,
     * idAthlete INT,
     * idEq INT,
     * idEpreuve INT,
     * PRIMARY KEY (idResultat),
     * UNIQUE (idAthlete, idEq, idEpreuve),
     * FOREIGN KEY (idAthlete) REFERENCES JOAthlete(idAthlete),
     * FOREIGN KEY (idEq) REFERENCES JOEquipe(idEq),
     * FOREIGN KEY (idEpreuve) REFERENCES JOEpreuve(idEpreuve)
     * CHECK ((idAthlete IS NOT NULL AND idEq IS NULL) OR (idAthlete IS NULL AND
     * idEq IS NOT NULL))
     */

    ConnexionMySQL laConnexionMySQL;
    Statement st;

    public JOParticiperResultat(ConnexionMySQL laConnexionMySQL) {
        this.laConnexionMySQL = laConnexionMySQL;
    }

    public void createJOParticiperResultat(Epreuve e, Athlete a, double resultat) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "insert into JOParticiperResultat(resultat, idAthlete, idEpreuve) values(?,?,?)");
        ps.setDouble(1, resultat);
        ps.setInt(2, a.hashCode());
        ps.setInt(3, e.hashCode());
        ps.executeUpdate();
    }

    public void createJOParticiperResultat(Epreuve e, Equipe eq, double resultat) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "insert into JOParticiperResultat(resultat, idEq, idEpreuve) values(?,?,?)");
        ps.setDouble(1, resultat);
        ps.setInt(2, eq.hashCode());
        ps.setInt(3, e.hashCode());
        ps.executeUpdate();
    }

    public void deleteJOParticiperResultat(Epreuve e, Athlete a) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "delete from JOParticiperResultat where idAthlete = ? and idEpreuve = ?");
        ps.setInt(1, a.hashCode());
        ps.setInt(2, e.hashCode());
        ps.executeUpdate();
    }

    public void deleteJOParticiperResultat(Epreuve e, Equipe eq) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "delete from JOParticiperResultat where idEq = ? and idEpreuve = ?");
        ps.setInt(1, eq.hashCode());
        ps.setInt(2, e.hashCode());
        ps.executeUpdate();
    }

    public double readJOParticiperResultat(Epreuve e, Athlete a) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL
                .prepareStatement("select * from JOParticiperResultat where idAthlete = ? and idEpreuve = ?");
        ps.setInt(1, a.hashCode());
        ps.setInt(2, e.hashCode());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getDouble("resultat");
        } else {
            throw new SQLException("Résultat non trouvé.");
        }
    }

    public double readJOParticiperResultat(Epreuve e, Equipe eq) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL
                .prepareStatement("select * from JOParticiperResultat where idEq = ? and idEpreuve = ?");
        ps.setInt(1, eq.hashCode());
        ps.setInt(2, e.hashCode());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getDouble("resultat");
        } else {
            throw new SQLException("Résultat non trouvé.");
        }
    }

    public void updateJOParticiperResultat(Epreuve e, Athlete a, double resultat) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "update JOParticiperResultat set resultat = ? where idAthlete = ? and idEpreuve = ?");
        ps.setDouble(1, resultat);
        ps.setInt(2, a.hashCode());
        ps.setInt(3, e.hashCode());
        ps.executeUpdate();
    }

    public void updateJOParticiperResultat(Epreuve e, Equipe eq, double resultat) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "update JOParticiperResultat set resultat = ? where idEq = ? and idEpreuve = ?");
        ps.setDouble(1, resultat);
        ps.setInt(2, eq.hashCode());
        ps.setInt(3, e.hashCode());
        ps.executeUpdate();
    }

    public void deleteJOParticiperResultat(Epreuve e) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL
                .prepareStatement("delete from JOParticiperResultat where idEpreuve = ?");
        ps.setInt(1, e.hashCode());
        ps.executeUpdate();
    }

    public void deleteJOParticiperResultat(Athlete a) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL
                .prepareStatement("delete from JOParticiperResultat where idAthlete = ?");
        ps.setInt(1, a.hashCode());
        ps.executeUpdate();
    }

    public void deleteJOParticiperResultat(Equipe eq) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL
                .prepareStatement("delete from JOParticiperResultat where idEq = ?");
        ps.setInt(1, eq.hashCode());
        ps.executeUpdate();
    }

    public void deleteJOParticiperResultat(Equipe eq, Epreuve e) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL
                .prepareStatement("delete from JOParticiperResultat where idEq = ? and idEpreuve = ?");
        ps.setInt(1, eq.hashCode());
        ps.setInt(2, e.hashCode());
        ps.executeUpdate();
    }

    public void deleteJOParticiperResultat(Athlete a, Epreuve e) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL
                .prepareStatement("delete from JOParticiperResultat where idAthlete = ? and idEpreuve = ?");
        ps.setInt(1, a.hashCode());
        ps.setInt(2, e.hashCode());
        ps.executeUpdate();
    }

    public Map<Epreuve, Map<Participer, Double>> getLesResultats() throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement("select * from JOParticiperResultat");
        ResultSet rs = ps.executeQuery();
        Map<Epreuve, Map<Participer, Double>> lesResultats = new HashMap<Epreuve, Map<Participer, Double>>();
        while (rs.next()) {
            Epreuve e = new JOEpreuveBD(this.laConnexionMySQL).readJOEpreuve(rs.getInt("idEpreuve"));
            if (rs.getInt("idAthlete") != 0) {
                Map<Participer, Double> lesParticipations = new HashMap<Participer, Double>();
                Athlete a = new JOAthleteBD(this.laConnexionMySQL).readJOAthlete(rs.getInt("idAthlete"));
                lesParticipations.put(a, rs.getDouble("resultat"));
                lesResultats.put(e, lesParticipations);
                
            } else {
                Equipe eq = new JOEquipeBD(this.laConnexionMySQL).readJOEquipe(rs.getInt("idEq"));
                Map<Participer, Double> lesParticipations = new HashMap<Participer, Double>();
                lesParticipations.put(eq, rs.getDouble("resultat"));
                lesResultats.put(e, lesParticipations);
            }
        }
        return lesResultats;
    }
}

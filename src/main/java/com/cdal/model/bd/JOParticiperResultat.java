package main.java.com.cdal.model.bd;

import java.sql.*;
import java.util.ArrayList;
import main.java.com.cdal.model.*;

public class JOParticiperResultat {

    /*
     * idResultat INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
     * resultat FLOAT,
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

    public void createJOParticiperResultat(Epreuve e, Athlete a, float resultat) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "insert into JOParticiperResultat(resultat, idAthlete, idEpreuve) values(?,?,?)");
        ps.setFloat(1, resultat);
        ps.setInt(2, a.hashCode());
        ps.setInt(3, e.hashCode());
        ps.executeUpdate();
    }

    public void createJOParticiperResultat(Epreuve e, Equipe eq, float resultat) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "insert into JOParticiperResultat(resultat, idEq, idEpreuve) values(?,?,?)");
        ps.setFloat(1, resultat);
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

    public float readJOParticiperResultat(Epreuve e, Athlete a) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL
                .prepareStatement("select * from JOParticiperResultat where idAthlete = ? and idEpreuve = ?");
        ps.setInt(1, a.hashCode());
        ps.setInt(2, e.hashCode());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getFloat("resultat");
        } else {
            throw new SQLException("Résultat non trouvé.");
        }
    }

    public float readJOParticiperResultat(Epreuve e, Equipe eq) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL
                .prepareStatement("select * from JOParticiperResultat where idEq = ? and idEpreuve = ?");
        ps.setInt(1, eq.hashCode());
        ps.setInt(2, e.hashCode());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getFloat("resultat");
        } else {
            throw new SQLException("Résultat non trouvé.");
        }
    }

    public void updateJOParticiperResultat(Epreuve e, Athlete a, float resultat) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "update JOParticiperResultat set resultat = ? where idAthlete = ? and idEpreuve = ?");
        ps.setFloat(1, resultat);
        ps.setInt(2, a.hashCode());
        ps.setInt(3, e.hashCode());
        ps.executeUpdate();
    }

    public void updateJOParticiperResultat(Epreuve e, Equipe eq, float resultat) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "update JOParticiperResultat set resultat = ? where idEq = ? and idEpreuve = ?");
        ps.setFloat(1, resultat);
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
}

package main.java.com.cdal.model.bd;

import java.sql.*;
import main.java.com.cdal.model.*;
import main.java.com.cdal.util.Couple;

import java.util.ArrayList;

public class JOSintegrerBD {
    
    /*
     * idAthlete INT,
     * idEq INT,
     * PRIMARY KEY (idAthlete, idEq),
     * FOREIGN KEY (idAthlete) REFERENCES JOAthlete(idAthlete),
     * FOREIGN KEY (idEq) REFERENCES JOEquipe(idEq)
     */

    ConnexionMySQL laConnexionMySQL;
    Statement st;

    public JOSintegrerBD(ConnexionMySQL laConnexionMySQL) {
        this.laConnexionMySQL = laConnexionMySQL;
    }

    public void createJOSintegrer(Equipe e, Athlete a) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "insert into JOSintegrer(idAthlete, idEq) values(?,?)");
        ps.setInt(1, a.hashCode());
        ps.setInt(2, e.hashCode());
        ps.executeUpdate();
    }

    public void deleteJOSintegrer(Equipe e, Athlete a) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "delete from JOSintegrer where idAthlete = ? and idEq = ?");
        ps.setInt(1, a.hashCode());
        ps.setInt(2, e.hashCode());
        ps.executeUpdate();
    }

    public Couple<Athlete,Equipe> readJOSintegrer(int e, int a) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL
                .prepareStatement("select * from JOSintegrer where idEq = ? and idAthlete = ?");
        ps.setInt(1, e);
        ps.setInt(2, a);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return new Couple<Athlete,Equipe>(new JOAthleteBD(this.laConnexionMySQL).readJOAthlete(rs.getInt("idAthlete")), new JOEquipeBD(this.laConnexionMySQL).readJOEquipe(rs.getInt("idEq")));
        } else {
            throw new SQLException("Couple non trouvé.");
        }
    }

    public void updateJOSintegrer(Equipe e, Athlete a) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "update JOSintegrer set idAthlete = ?, idEq = ? where idAthlete = ? and idEq = ?");
        ps.setInt(1, a.hashCode());
        ps.setInt(2, e.hashCode());
        ps.setInt(3, a.hashCode());
        ps.setInt(4, e.hashCode());
        ps.executeUpdate();
    }

    public void deleteJOSintegrer(int e, int a) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL
                .prepareStatement("delete from JOSintegrer where idEq = ? and idAthlete = ?");
        ps.setInt(1, e);
        ps.setInt(2, a);
        ps.executeUpdate();
    }
    
    public ArrayList<Couple<Athlete,Equipe>> allJOSintegrer() throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement("select * from JOSintegrer");
        ResultSet rs = ps.executeQuery();
        ArrayList<Couple<Athlete, Equipe>> lesCouples = new ArrayList<Couple<Athlete, Equipe>>();
        while (rs.next()) {
            lesCouples.add(new Couple<Athlete, Equipe>(
                    new JOAthleteBD(this.laConnexionMySQL).readJOAthlete(rs.getInt("idAthlete")),
                    new JOEquipeBD(this.laConnexionMySQL).readJOEquipe(rs.getInt("idEq"))));
        }
        return lesCouples;
    }
}

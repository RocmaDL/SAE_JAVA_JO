package main.java.com.cdal.model.bd;

import java.sql.*;
import java.util.ArrayList;
import main.java.com.cdal.model.*;

public class JOEquipeBD {
    
    /*
     * idEq INT PRIMARY KEY,
     * nomEq VARCHAR(50),
     * idPays INT,
     * FOREIGN KEY (idPays) REFERENCES JOPays(idPays)
     */

    ConnexionMySQL laConnexionMySQL;
    Statement st;

    public JOEquipeBD(ConnexionMySQL laConnexionMySQL) {
        this.laConnexionMySQL = laConnexionMySQL;
    }

    public void createJOEquipe(Equipe e) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "insert into JOEquipe(idEq, nomEq, idPays) values(?,?,?)");
        ps.setInt(1, e.hashCode());
        ps.setString(2, e.getNomEq());
        ps.setInt(3, e.getPays().hashCode());
        ps.executeUpdate();
    }

    public Equipe readJOEquipe(int id) throws SQLException {
        Statement st = this.laConnexionMySQL.createStatement();
        ResultSet rs = st.executeQuery("select * from JOEquipe where idEq = " + id);
        if (rs.next()) {
            Pays p = new JOPaysBD(this.laConnexionMySQL).readJOPays(rs.getInt("idPays"));
            return new Equipe(rs.getString("nomEq"), p);
        } else {
            throw new SQLException("Equipe non trouvée.");
        }
    }

    public void updateJOEquipe(Equipe e) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "update JOEquipe set nomEq = ?, idPays = ? where idEq = ?");
        ps.setString(1, e.getNomEq());
        ps.setInt(2, e.getPays().hashCode());
        ps.setInt(3, e.hashCode());
        ps.executeUpdate();
    }

    public void deleteJOEquipe(int e) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement("delete from JOEquipe where idEq = ?");
        ps.setInt(1, e);
        ps.executeUpdate();
    }

    public ArrayList<Equipe> AllJOEquipe() throws SQLException {
        ArrayList<Equipe> lesEquipes = new ArrayList<Equipe>();
        Statement st = this.laConnexionMySQL.createStatement();
        ResultSet rs = st.executeQuery("select * from JOEquipe");
        while (rs.next()) {
            Pays p = new JOPaysBD(this.laConnexionMySQL).readJOPays(rs.getInt("idPays"));
            lesEquipes.add(new Equipe(rs.getString("nomEq"), p));
        }
        return lesEquipes;
    }
}

package main.java.com.cdal.model.bd;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.plaf.nimbus.State;
import main.java.com.cdal.model.Utilisateur;
import main.java.com.cdal.model.ConnexionMySQL;
import main.java.com.cdal.model.Pays;

public class JOPaysBD {

    ConnexionMySQL laConnexionMySQL;
    Statement st;

    public JOPaysBD(ConnexionMySQL laConnexionMySQL) {
        this.laConnexionMySQL = laConnexionMySQL;
    }

    public void createJOPays(Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "insert into JOPays(idPays, nomPays) values(?,?)");
        ps.setInt(1, p.hashCode());
        ps.setString(2, p.getNom());
        ps.executeUpdate();
    }

    public Pays readJOPays(int id) throws SQLException {
        Statement st = this.laConnexionMySQL.createStatement();
        ResultSet rs = st.executeQuery("select * from JOPays where idPays = " + id);
        if (rs.next()) {
            return new Pays(rs.getString("nomPays"));
        } else {
            throw new SQLException("Pays non trouvé.");
        }
    }

    public void updateJOPays(Pays p) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "update JOPays set nomPays = ? where idPays = ?");
        ps.setString(1, p.getNom());
        ps.setInt(2, p.hashCode());
        ps.executeUpdate();
    }

    public void deleteJOPays(int p) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement("delete from JOPays where idPays = ?");
        ps.setInt(1, p);
        ps.executeUpdate();
    }

    public ArrayList<Pays> AllJOPays() throws SQLException {
        ArrayList<Pays> listePays = new ArrayList<Pays>();
        Statement st = this.laConnexionMySQL.createStatement();
        ResultSet rs = st.executeQuery("select * from JOPays");
        while (rs.next()) {
            Pays p = new Pays(rs.getString("nomPays"));
            listePays.add(p);
        }
        return listePays;
    }
}

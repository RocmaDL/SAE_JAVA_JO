package main.java.com.cdal.model.bd;

import java.sql.*;
import java.util.ArrayList;
import main.java.com.cdal.model.*;

public class JOJeuxOlympiquesBD { // ! Implémenter les requetes pour trouver les autres attributs
    /*
     * idJO INT PRIMARY KEY,
    */
    ConnexionMySQL laConnexionMySQL;
    Statement st;

    public JOJeuxOlympiquesBD(ConnexionMySQL laConnexionMySQL) {
        this.laConnexionMySQL = laConnexionMySQL;
    }

    public void createJOJeuxOlympique(JeuxOlympiques jo) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "insert into JOJeuxOlympique(idJO) values(?)");
        ps.setInt(1, jo.hashCode());
        ps.executeUpdate();
    }

    public JeuxOlympiques readJOJeuxOlympique(int id) throws SQLException { // ! A remplir des données
        Statement st = this.laConnexionMySQL.createStatement();
        ResultSet rs = st.executeQuery("select * from JOJeuxOlympique where idJO = " + id);
        if (rs.next()) {
            return new JeuxOlympiques();
        } else {
            throw new SQLException("Jeux Olympique non trouvé.");
        }
    }

    public void updateJOJeuxOlympique(JeuxOlympiques jo) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement(
                "update JOJeuxOlympique set idJO = ? where idJO = ?");
        ps.setInt(1, jo.hashCode());
        ps.setInt(2, jo.hashCode());
        ps.executeUpdate();
    }

    public void deleteJOJeuxOlympique(int jo) throws SQLException {
        PreparedStatement ps = this.laConnexionMySQL.prepareStatement("delete from JOJeuxOlympique where idJO = ?");
        ps.setInt(1, jo);
        ps.executeUpdate();
    }

    public ArrayList<JeuxOlympiques> getAllJeuxOlympique() throws SQLException {
        ArrayList<JeuxOlympiques> listeJeuxOlympique = new ArrayList<JeuxOlympiques>();
        Statement st = this.laConnexionMySQL.createStatement();
        ResultSet rs = st.executeQuery("select * from JOJeuxOlympique");
        while (rs.next()) {
            JeuxOlympiques jo = new JeuxOlympiques();
            listeJeuxOlympique.add(jo);
        }
        return listeJeuxOlympique;
    }
}

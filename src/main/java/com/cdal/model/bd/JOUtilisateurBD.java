package main.java.com.cdal.model.bd;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.plaf.nimbus.State;
import main.java.com.cdal.model.Utilisateur;
import main.java.com.cdal.model.ConnexionMySQL;

public class JOUtilisateurBD {
    ConnexionMySQL laConnexion;
    Statement st;

    public JOUtilisateurBD(ConnexionMySQL laConnexion) {
        this.laConnexion = laConnexion;
    }

    public void createJOUtilisateurBD(Utilisateur u) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement(
                "insert into JOUtilisateur(emailUser, nomUser, mdpUser, roleUser) values(?,?,?,?)");
        ps.setString(1, u.getEmail());
        ps.setString(2, u.getNom());
        ps.setString(3, u.getMdp());
        ps.setString(4, u.getRole());
        ps.executeUpdate();
    }

    public Utilisateur readJOUtilisateurBD(String email) throws SQLException {
        Statement st = this.laConnexion.createStatement();
        ResultSet rs = st.executeQuery("select * from JOUtilisateur where emailUser = " + email);
        if (rs.next()) {
            return new Utilisateur(rs.getString("nomUser"), rs.getString("emailUser"), rs.getString("mdpUser"),
                    rs.getString("roleUser"));
        } else {
            throw new SQLException("Utilisateur non trouvé.");
        }
    }

    public void updateJOUtilisateurBD(Utilisateur u) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement(
                "update JOUtilisateur set nomUser = ?, mdpUser = ?, roleUser = ? where emailUser = ?");
        ps.setString(1, u.getNom());
        ps.setString(2, u.getMdp());
        ps.setString(3, u.getRole());
        ps.setString(4, u.getEmail());
        ps.executeUpdate();
    }

    public void deleteJOUtilisateurBD(String email) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("delete from JOUtilisateur where emailUser = ?");
        ps.setString(1, email);
        ps.executeUpdate();
    }

    public ArrayList<Utilisateur> readAllJOUtilisateurBD() throws SQLException {
        ArrayList<Utilisateur> listeUtilisateur = new ArrayList<Utilisateur>();
        Statement st = this.laConnexion.createStatement();
        ResultSet rs = st.executeQuery("select * from JOUtilisateur");
        while (rs.next()) {
            listeUtilisateur
                    .add(new Utilisateur(rs.getString("nomUser"), rs.getString("emailUser"), rs.getString("mdpUser"),
                            rs.getString("roleUser")));
        }
        return listeUtilisateur;
    }
}

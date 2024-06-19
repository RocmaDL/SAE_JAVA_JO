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

    public void createJOUtilisateur(Utilisateur u) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement(
                "insert into JOUtilisateur(nomUser, prenomUser, mdpUser, roleUser) values(?, ?, ?, ?)");
        ps.setString(1, u.getNom());
        ps.setString(2, u.getPrenom());
        ps.setString(3, u.getMdp());
        ps.setString(4, u.getRole());
        ps.executeUpdate();
    }

    public Utilisateur readJOUtilisateur(String id) throws SQLException {
        Statement st = this.laConnexion.createStatement();
        ResultSet rs = st.executeQuery("select * from JOUtilisateur where idUser = " + id);
        if (rs.next()) {
            Utilisateur u = new Utilisateur();
            u.setId(rs.getString("idUser"));
            u.setNom(rs.getString("nomUser"));
            u.setPrenom(rs.getString("prenomUser"));
            u.setMdp(rs.getString("mdpUser"));
            u.setRole(rs.getString("roleUser"));
            return u;
        } else {
            throw new SQLException("Utilisateur non trouvé.");
        }
    }

    public void updateJOUtilisateur(Utilisateur u) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement(
                "update JOUtilisateur set nomUser = ?, prenomUser = ?, mdpUser = ?, roleUser = ? where idUser = ?");
        ps.setString(1, u.getNom());
        ps.setString(2, u.getPrenom());
        ps.setString(3, u.getMdp());
        ps.setString(4, u.getRole());
        ps.setString(5, u.getId());
        ps.executeUpdate();
    }

    public void deleteJOUtilisateur(Utilisateur u) throws SQLException {
        PreparedStatement ps = this.laConnexion.prepareStatement("delete from JOUtilisateur where idUser = ?");
        ps.setString(1, u.getId());
        ps.executeUpdate();
    }

    public ArrayList<Utilisateur> listeJOUtilisateurs() throws SQLException {
        ArrayList<Utilisateur> liste = new ArrayList<Utilisateur>();
        Statement st = this.laConnexion.createStatement();
        ResultSet rs = st.executeQuery("select * from JOUtilisateur");
        while (rs.next()) {
            Utilisateur u = new Utilisateur();
            u.setId(rs.getString("idUser"));
            u.setNom(rs.getString("nomUser"));
            u.setPrenom(rs.getString("prenomUser"));
            u.setMdp(rs.getString("mdpUser"));
            u.setRole(rs.getString("roleUser"));
            liste.add(u);
        }
        if (liste.size() == 0) {
            throw new SQLException("Aucun utilisateur trouvé.");
        }
        return liste;
    }
}

package main.java.com.cdal.model;

public class Utilisateur {
    /*
     * idUser VARCHAR(50) PRIMARY KEY NOT NULL AUTO_INCREMENT,
     * nomUser VARCHAR(50),
     * prenomUser VARCHAR(50),
     * mdpUser VARCHAR(50),
     * roleUser VARCHAR(50)
     */

    private String id;
    private String nom;
    private String prenom;
    private String mdp;
    private String role;

    public Utilisateur(String id, String nom, String prenom, String mdp, String role) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
        this.role = role;
    }

    public Utilisateur() {
        this.id = "";
        this.nom = "";
        this.prenom = "";
        this.mdp = "";
        this.role = "";
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getMdp() {
        return this.mdp;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

}

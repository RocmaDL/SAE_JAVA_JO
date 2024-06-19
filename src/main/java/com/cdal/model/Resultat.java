package main.java.com.cdal.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Resultat {
    private final StringProperty pays = new SimpleStringProperty();
    private final StringProperty nom = new SimpleStringProperty();
    private final StringProperty prenom = new SimpleStringProperty();
    private final StringProperty resultat = new SimpleStringProperty();

    public Resultat(String pays, String nom, String prenom, String resultat) {
        setPays(pays);
        setNom(nom);
        setPrenom(prenom);
        setResultat(resultat);
    }

    public String getPays() {
        return pays.get();
    }

    public void setPays(String pays) {
        this.pays.set(pays);
    }

    public StringProperty paysProperty() {
        return pays;
    }

    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom.set(nom);
    }

    public StringProperty nomProperty() {
        return nom;
    }

    public String getPrenom() {
        return prenom.get();
    }

    public void setPrenom(String prenom) {
        this.prenom.set(prenom);
    }

    public StringProperty prenomProperty() {
        return prenom;
    }

    public String getResultat() {
        return resultat.get();
    }

    public void setResultat(String resultat) {
        this.resultat.set(resultat);
    }

    public StringProperty resultatProperty() {
        return resultat;
    }
}

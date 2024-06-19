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

}
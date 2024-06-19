package main.java.com.cdal;
import main.java.com.cdal.model.*;

import java.sql.*;
public class ExecutableBD {
    public static void main(String[] args) {
        try {
            ConnexionMySQL connexion = new ConnexionMySQL();

            connexion.connecter("servinfo-maria", "DBkhadjou", "khadjou", "khadjou");

            if (connexion.isConnecte()) {
                BD bd = new BD(connexion);
                bd.csvToSQL("donnees.csv");
            } else {
                System.err.println("Erreur: Connection non établie.");
            }
        } catch (Exception e) {
            System.err.println("Erreur: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

package main.java.com.cdal.controler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;


public class ControlerEpreuveResultat {
    @FXML private Button lancer_epreuve;
    @FXML private Button enregistrerRes;


    
    public void lancerEpreuve(ActionEvent event) {
        //--- Lancer l'épreuve
        System.out.println("L'épreuve est lancée");
    }

    public void enregistrerRes(ActionEvent event) {
        //--- Enregistrer le résultat
        System.out.println("Le résultat est enregistré");
    }
    





    
}

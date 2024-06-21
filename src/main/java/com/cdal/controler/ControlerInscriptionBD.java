package main.java.com.cdal.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import main.java.com.cdal.model.bd.*;

import main.java.com.cdal.view.AppPrincipale;

public class ControlerInscriptionBD implements EventHandler<ActionEvent> {

    private AppPrincipale vue; // AppPrincipale
    private JOUtilisateurBD modele;

    public ControlerInscriptionBD(AppPrincipale vue, JOUtilisateurBD modele) {
        this.vue = vue;
        this.modele = modele;
    }

    @Override
    public void handle(ActionEvent event) {
        // --- Inscription
        System.out.println("Inscription");
        // --- Récupération des champs
    }

}
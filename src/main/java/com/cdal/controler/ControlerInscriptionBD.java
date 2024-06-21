package main.java.com.cdal.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import main.java.com.cdal.model.Utilisateur;
import main.java.com.cdal.model.bd.*;
import main.java.com.cdal.view.AppPrincipale;
import main.java.com.cdal.view.VueInscription;

public class ControlerInscriptionBD implements EventHandler<ActionEvent> {

    private VueInscription vue; // VueInscription
    private JOUtilisateurBD modele;
    private AppPrincipale app;

    public ControlerInscriptionBD(VueInscription vue, JOUtilisateurBD modele, AppPrincipale app) {
        this.vue = vue;
        this.modele = modele;
        this.app = app;
    }

    @Override
    public void handle(ActionEvent event) {
        // --- Inscription
        System.out.println("Inscription");
        // --- Récupération des champs
        Utilisateur utilisateur = new Utilisateur(this.vue.getNom(), this.vue.getEmail(), this.vue.getMotDePasse(),
                this.vue.getRole());
        app.setUser(utilisateur);
        switch (utilisateur.getRole()) {
            case "Journaliste":
                this.app.afficherPageJournaliste();
                break;
            case "admin":
                try {
                    this.app.afficherPageAdminBis();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            case "organisateur":
                try {
                    this.app.afficherPageAjouterEpreuve();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            default:
                break;
        }
        // --- Ajout de l'utilisateur
        try {
            this.modele.createJOUtilisateurBD(utilisateur);
        } catch (Exception e) {
            this.vue.erreurEmail();
        }
    }

}
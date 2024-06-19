package main.java.com.cdal.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;

public class ControleurConnexion {

    private VueConnexion vue;

    public ControleurConnexion(VueConnexion vue) {
        this.vue = vue;
    }

    public void initialiserActions() {
        vue.getBoutonValider().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                validerConnexion();
            }
        });

        vue.getBoutonAnnuler().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                annulerConnexion();
            }
        });

        vue.getBoutonAfficherMasquerMotDePasse().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                afficherMasquerMotDePasse();
            }
        });
    }

    private void validerConnexion() {
        String nomUtilisateur = vue.getNomUtilisateur();
        String motDePasse = vue.getMotDePasse();

        // Simuler une validation de connexion
        if (nomUtilisateur.equals("admin") && motDePasse.equals("password")) {
            vue.setMessageAction("Connexion réussie !", Color.GREEN);
        } else {
            vue.setMessageAction("Échec de la connexion. Veuillez réessayer.", Color.RED);
        }
    }

    private void annulerConnexion() {
        vue.clearFields();
    }

    private void afficherMasquerMotDePasse() {
        vue.afficherMasquerMotDePasse();
    }
}


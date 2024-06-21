package main.java.com.cdal.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.paint.Color;
import main.java.com.cdal.model.Utilisateur;
import main.java.com.cdal.model.bd.JOUtilisateurBD;
import main.java.com.cdal.view.AppPrincipale;
import main.java.com.cdal.view.VueConnexion;

public class ControleurConnexion implements EventHandler<ActionEvent> {

    private VueConnexion vue;
    private JOUtilisateurBD modele;
    private AppPrincipale appPrincipale;

    public ControleurConnexion(VueConnexion vue, AppPrincipale appPrincipale, JOUtilisateurBD modele) {
        this.vue = vue;
        this.appPrincipale = appPrincipale;
        this.modele = modele;
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
        try {
            Utilisateur utilisateur = modele.readJOUtilisateurBD(nomUtilisateur);
            if (utilisateur == null || !utilisateur.getMdp().equals(motDePasse)) {
                throw new Exception();
            }
            appPrincipale.setUser(utilisateur);
            switch (utilisateur.getRole()) {
                case "Journaliste":
                    this.appPrincipale.afficherPageJournaliste();
                    break;
                case "Administrateur":
                    try {
                        this.appPrincipale.afficherPageAdminBis();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case "Organisateur":
                    try {
                        this.appPrincipale.afficherPageAjouterEpreuve();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                default:
                    break;
            }
        } catch (Exception e) {
            System.out.println(e);
            vue.setMessageAction("Échec de la connexion. Veuillez réessayer. L'email ou le mot de passe est invalide",
                    Color.RED);
        }
    }

    private void annulerConnexion() {
        vue.clearFields();
    }

    private void afficherMasquerMotDePasse() {
        vue.afficherMasquerMotDePasse();
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.vue.popUpRegleConnexion().showAndWait();
    }
}

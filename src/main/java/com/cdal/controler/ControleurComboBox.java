package main.java.com.cdal.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.java.com.cdal.model.JeuxOlympiques;
import main.java.com.cdal.view.AppPrincipale;

public class ControleurComboBox implements EventHandler<ActionEvent> {

    private JeuxOlympiques modeleJO;

    private AppPrincipale vueJO;

    private String valeur;

    public ControleurComboBox(JeuxOlympiques modele, AppPrincipale vue, String valeur) {
        this.modeleJO = modele;
        this.vueJO = vue;
        this.valeur = valeur;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        System.out.println("ComboBox modifié");
        this.vueJO.afficherPageAjoutResultat();
    }
}
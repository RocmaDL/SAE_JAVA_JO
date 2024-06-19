package main.java.com.cdal.controler;

import javax.swing.Action;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.java.com.cdal.view.AppliJournaliste;


public class ControleurRechercherBis implements EventHandler<ActionEvent> {

    private AppliJournaliste vueJO;
    private String mot;

    public ControleurRechercherBis(AppliJournaliste vueJo, String value) {
        this.vueJO = vueJo;
        this.mot = value;
    }
    
    @Override
    public void handle(ActionEvent actionEvent) {
        // Recherche le mot sur la page.
        System.out.println("Recherche du mot : " + this.mot);
    }
}
package main.java.com.cdal.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.java.com.cdal.view.AppPrincipale;


public class ControleurRechercherBis implements EventHandler<ActionEvent> {

    private AppPrincipale vueJO;
    private String mot;

    public ControleurRechercherBis(AppPrincipale appPrincipale, String value) {
        this.vueJO = appPrincipale;
        this.mot = value;
    }
    
    @Override
    public void handle(ActionEvent actionEvent) {
        // Recherche le mot sur la page.
        System.out.println("Recherche du mot : " + this.mot);
    }
}
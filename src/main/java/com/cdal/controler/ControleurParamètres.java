package main.java.com.cdal.controler;

import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.java.com.cdal.view.AppliJournaliste;


public class ControleurParamètres implements EventHandler<ActionEvent> {
    
    private AppliJournaliste vueJO;

    public ControleurParamètres(AppliJournaliste vueJO) {
        this.vueJO = vueJO;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        // Ajouter des paramètres à modifier, ex : taille fenêtre / couleur de fond...
        System.out.println("Paramètres modifiés");
    }
}
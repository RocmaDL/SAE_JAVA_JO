package main.java.com.cdal.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.java.com.cdal.view.AppPrincipale;


public class ControleurParametres implements EventHandler<ActionEvent> {
    
    private AppPrincipale vueJO;

    public ControleurParametres(AppPrincipale vueJO) {
        this.vueJO = vueJO;
    }


    public ControleurParametres(AppPrincipale appPrincipale) {
        //TODO Auto-generated constructor stub
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        // Ajouter des paramètres à modifier, ex : taille fenêtre / couleur de fond...
        System.out.println("Paramètres modifiés");
    }
}
package main.java.com.cdal.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.java.com.cdal.view.AppPrincipale;


public class ControleurCouleur implements EventHandler<ActionEvent> {
    
    private AppPrincipale vueJO;

    private String valeur;

    public ControleurCouleur(AppPrincipale vueJO, String valeur) {
        this.vueJO = vueJO;
        this.valeur = valeur;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        // Ajouter des paramètres à modifier, ex : taille fenêtre / couleur de fond...
        this.vueJO.popUpParametres().show();
        
    }

}
package main.java.com.cdal.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import main.java.com.cdal.view.AppPrincipale;

public class ControlerDeconnexion implements EventHandler<ActionEvent>{

    private AppPrincipale vue; // AppPrincipale       

    public ControlerDeconnexion(AppPrincipale vue) {
        this.vue = vue;
    }

    @Override
    public void handle(ActionEvent event) {
        //--- Déconnexion
        System.out.println("Déconnexion");
        this.vue.afficherPageConnexion();
    }
    
}

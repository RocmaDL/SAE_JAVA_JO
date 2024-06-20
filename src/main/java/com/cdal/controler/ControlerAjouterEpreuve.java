package main.java.com.cdal.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import main.java.com.cdal.view.AppPrincipale;



public class ControlerAjouterEpreuve implements EventHandler<ActionEvent>{
    private AppPrincipale vueJO;


    public ControlerAjouterEpreuve(AppPrincipale vueJO) {
        this.vueJO = vueJO;

    }   

    @Override
    public void handle( ActionEvent event) {
        //--- Lancer l'épreuve
        Button test = (Button) event.getSource();
        if (test.getText().contains("Ajouter")){
                System.out.println("Ajouter une épreuve");
                try {
                    this.vueJO.afficherPageAjouterEpreuve();
                } catch (Exception e) {
                    System.out.println("Erreur lors de l'affichage de la page d'ajout d'épreuve");
                    e.printStackTrace();
                }
        }
        
        
    }

}
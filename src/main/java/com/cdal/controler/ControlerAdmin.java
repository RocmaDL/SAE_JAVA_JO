package main.java.com.cdal.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import main.java.com.cdal.view.AppPrincipale;



public class ControlerAdmin implements EventHandler<ActionEvent>{
    private AppPrincipale vueJO;

    public ControlerAdmin(AppPrincipale vueJO) {
        this.vueJO = vueJO;

    }   

    @Override
    public void handle( ActionEvent event) {
        //--- Lancer l'épreuve
        Button test = (Button) event.getSource();
        if (test.getText().contains("Insérer")){
            System.out.println("Insérer un athlète");
            this.vueJO.insertionAthlete().showAndWait();
               
            
        }
        
        
    }
    
    
}

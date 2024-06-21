package main.java.com.cdal.controler;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import main.java.com.cdal.view.AppPrincipale;


public class ControlerConnexionJournaliste implements EventHandler<ActionEvent>{
    private AppPrincipale vueJO;


    public ControlerConnexionJournaliste(AppPrincipale vueJO) {
        this.vueJO = vueJO;

    }   

    @Override
    public void handle( ActionEvent event) {
        //--- Lancer l'épreuve
        Button test = (Button) event.getSource();
        if (test.getText().contains("Lancer")){
            try {
                System.out.println("L'épreuve est lancée");
                this.vueJO.afficherPageAjouterEpreuve();
                
            } catch (Exception e) {
                System.out.println("Erreur lors de l'affichage de la page d'ajout d'épreuve");
                System.out.println("Le message"+ e.toString());
            }
                
        }
        else { 
            System.out.println("Le résultat est enregistré");
            this.vueJO.afficherPageAjoutResultat();
        }
        
    }

}
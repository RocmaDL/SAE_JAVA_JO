import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControleurComboBox implements EventHandler<ActionEvent> {
    
    private JeuxOlympiques modeleJO;

    private AppliJournaliste vueJO;

    private String valeur;


    public ControleurComboBox(JeuxOlympiques modele, AppliJournaliste vue, String valeur) {
        this.modeleJO = modele;
        this.vueJO = vue;
        this.valeur = valeur;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        switch (this.valeur) {

            case "classement par épreuves": {
                //this.vueJO.modeJournalisteEpreuve()
            }

            case "classement par défaut": {
                //this.vueJO.modeJournalisteMédailles()
            }

            case "listes des JO": {
                //this.vueJO.modeJournalisteJO()
            }
        }
    }
}
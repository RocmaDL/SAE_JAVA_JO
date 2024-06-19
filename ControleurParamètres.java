import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControleurParamètres implements EventHandler<ActionEvent> {
    
    private AppliJournaliste vueJO;

    public ControleurParamètres(AppliJournaliste vueJO) {
        this.vueJO = vueJO;
    }


    @Override
    public void handle(ActionEvent actionEvent) {
        // Ajouter des paramètres à modifier, ex : taille fenêtre / couleur de fond...
    }
}
import javax.swing.Action;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class ControleurRechercher implements EventHandler<ActionEvent> {

    private AppliJournaliste vueJO;
    private String mot;

    public ControleurRechercher(AppliJournaliste vueJo, String value) {
        this.vueJO = vueJo;
        this.mot = value;
    }
    
    @Override
    public void handle(ActionEvent actionEvent) {
        // Recherche le mot sur la page.
    }
}
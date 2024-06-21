package main.java.com.cdal.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import main.java.com.cdal.view.AppPrincipale;
import main.java.com.cdal.view.VueConnexion;

public class ControleurLienInscription implements EventHandler<ActionEvent> {

    private AppPrincipale vueConnexion;

    public ControleurLienInscription(AppPrincipale vueConnexion) {
        this.vueConnexion = vueConnexion;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            if (event.getSource() instanceof Button) {
                this.vueConnexion.afficherPageConnexion();
                return;
            }
            if (event.getSource() instanceof Hyperlink) {
                this.vueConnexion.afficherPageInscription();
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

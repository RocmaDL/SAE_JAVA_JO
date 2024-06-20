package main.java.com.cdal.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.java.com.cdal.view.AppPrincipale;
import main.java.com.cdal.view.VueConnexion;

public class ControleurLienInscription implements EventHandler<ActionEvent> {

    private VueConnexion vueConnexion;

    public ControleurLienInscription(VueConnexion vueConnexion) {
        this.vueConnexion = vueConnexion;
    }

    @Override
    public void handle(ActionEvent event) {
        try {
            AppPrincipale app = (AppPrincipale) vueConnexion.getScene().getWindow().getScene().getRoot().getUserData();
            app.afficherPageInscription();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

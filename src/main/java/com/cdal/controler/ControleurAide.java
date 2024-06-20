package main.java.com.cdal.controler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.java.com.cdal.view.VueConnexion;

public class ControleurAide implements EventHandler<ActionEvent>{
        private VueConnexion vue;

    public ControleurAide(VueConnexion vue) {
        this.vue = vue;
    }
    @Override
    public void handle(ActionEvent actionEvent){
        this.vue.popUpRegleConnexion().showAndWait();
    }
}

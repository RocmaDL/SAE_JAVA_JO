package main.java.com.cdal.view;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import main.java.com.cdal.controler.*;

public class AppRechercherJO extends Application{
    Scene mainScene;
    BorderPane root;
    FXMLLoader loader;

    public static void main(String[] args) {
        //--- Lancement de l'application
        launch(args);
    }
    public void init() {
        //--- Initialisation de l'application
      
    }

    @Override
    public void start(Stage stage) throws Exception {
        //--- Chargement du fichier FXML


        URL url = new File("templates/RechercheJO.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        System.out.println("test.fxml chargé");
        Pane root = loader.load();
        Scene mainScene = new Scene(root);
        stage.setTitle("SayHello FXML");
        stage.setScene(mainScene);
        stage.show();
        //--- Récupération du bouton    

        Button btRechercher= (Button) mainScene.lookup("#rechercher_jo");
        btRechercher.setOnAction(new ControlerRechercher()::rechercheJO);

        stage.show();
    }
    
}

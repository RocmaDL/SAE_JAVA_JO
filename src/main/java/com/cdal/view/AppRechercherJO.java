package main.java.com.cdal.view;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javax.swing.text.StyledEditorKit;

import main.java.com.cdal.controler.*;

public class AppRechercherJO extends Application{
    Scene mainScene;
    BorderPane root;
    FXMLLoader loader;

    private ArrayList<Image> lesImages;
    private ImageView ImageJO;
    private int numeroImage;

    public static void main(String[] args) {
        //--- Lancement de l'application
        launch(args);
    }
    public void init() {
        //--- Initialisation de l'application
        this.lesImages = new ArrayList<Image>();
        this.chargerImages("img");
        this.numeroImage = 0;
      
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

    private void chargerImages(String repertoire){
        System.out.println(repertoire);
        File dossier = new File(repertoire);
        File [] fichiers = dossier.listFiles();
        if (fichiers != null){
            for (File fichier: fichiers){
                if (fichier.isFile() && fichier.getName().endsWith(".jpg")){
                    System.out.println(fichier.toString());
                    this.lesImages.add(new Image(fichier.toURI().toString()));
                }
            }

        }

    }
    public void majImageJo(){
        this.ImageJO.setImage(this.lesImages.get(this.numeroImage));
        
    }
    
    
}

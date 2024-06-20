package main.java.com.cdal.view;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import main.java.com.cdal.controler.*;

public class AppRechercherJO extends BorderPane{
    Scene mainScene;
    BorderPane root;
    FXMLLoader loader;
    Button btRechercher;

    private ArrayList<Image> lesImages;
    private ImageView ImageJO;
    private int numeroImage;


    public AppRechercherJO() {
        this.lesImages = new ArrayList<Image>();
        this.chargerImages("img");
        this.numeroImage = 0;
        this.ImageJO = new ImageView(this.lesImages.get(this.numeroImage));
        this.ImageJO.setFitWidth(200);
        this.ImageJO.setFitHeight(200);
        this.ImageJO.setPreserveRatio(true);
        this.ImageJO.setSmooth(true);
        this.ImageJO.setCache(true);
        
        try {
            URL url = new File("templates/PageRechercheJO.fxml").toURI().toURL();
            this.loader = new FXMLLoader(url);
            System.out.println("RechercheJO.fxml chargé");
            this.root = (BorderPane) loader.load();
            System.out.println("Root chargé");
            this.mainScene = new Scene(this.root, 800, 600);
        } catch (Exception e) {
            System.out.println("Erreur de chargement de la page Rechercher");
    
        }

        Button btRechercher = (Button) this.mainScene.lookup("#rechercher_jo");
        btRechercher.setOnAction(new ControlerRechercher()::rechercheJO);

        this.setCenter(this.root);
        
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

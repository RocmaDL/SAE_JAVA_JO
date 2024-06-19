package main.java.com.cdal.view;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javax.swing.border.Border;

import main.java.com.cdal.controler.*;


public class AppPrincipale extends Application{

    Parent root;
    Scene mainScene;
    //BorderPane centre;
    FXMLLoader loader;
    private TextField barreRecherche;
    private Button btnRechercher;
    private Button btnParametres;
    private Button btnDeco;
    private BorderPane panelCentral;
    private ImageView utilisateur;
    
    public void init(){
        //--- Initialisation de l'application
        this.barreRecherche = new TextField("");

    }
    
    public void afficherPageAdmin() throws Exception {
        //--- Chargement du fichier FXML
        try{
            URL url = new File("templates/PageAdmin.fxml").toURI().toURL();
            this.loader = new FXMLLoader(url);
            System.out.println("PageAdmin.fxml chargé"+loader);
            this.root = loader.load();
            this.mainScene = new Scene(root);
        } catch (Exception e) {
            System.out.println("Erreur de chargement de la page Admin");

        }
    }   

    public void afficherPageEnregistrerRes() throws Exception {
        //--- Chargement du fichier FXML
        try{
            URL url = new File("templates/PageEpreuveResultat.fxml").toURI().toURL();
            this.loader = new FXMLLoader(url);
            System.out.println("PageEpreuveResultat.fxml chargé"+loader);
            this.root = loader.load();
            this.mainScene = new Scene(root);
            Button btLancerEpreuve = (Button) mainScene.lookup("#lancer_epreuve");
            btLancerEpreuve.setOnAction(new ControlerEpreuveResultat()::lancerEpreuve);

            Button btEnregistrerResultat = (Button) mainScene.lookup("#enregistrer_res");
            btEnregistrerResultat.setOnAction(new ControlerEpreuveResultat()::enregistrerRes);

        } catch (Exception e) {
            System.out.println("Erreur de chargement de la page EnregistrerRes");

        }
    }

    public void afficherPageRechercher(){
        //--- Chargement du fichier FXML
        try{
            URL url = new File("templates/RechercheJO.fxml").toURI().toURL();
            this.loader = new FXMLLoader(url);
            System.out.println("RechercheJO.fxml chargé");
            this.root = loader.load();
            this.mainScene = new Scene(root);
        } catch (Exception e) {
            System.out.println("Erreur de chargement de la page Rechercher");

        }
    }

    public void afficherPageAdminBis() throws Exception {
        //--- Chargement du fichier FXML
        try{
            URL url = new File("templates/PageClassementEpreuve.fxml").toURI().toURL();
            this.loader = new FXMLLoader(url);
            System.out.println("PageClassementEpreuve.fxml chargé"+loader);
            this.root = loader.load();
            this.panelCentral.setCenter(this.root);
            //this.mainScene.setRoot(root);
        } catch (Exception e) {
            System.out.println("Erreur de chargement de la page PageClassementEpreuve");

        }
    }


    public Pane header() {
        BorderPane banniere = new BorderPane();
        this.barreRecherche.setPromptText("Rechercher une information");
        this.barreRecherche.setPrefWidth(300);
        this.barreRecherche.setPrefHeight(20);

        HBox hbLeft = new HBox();
        hbLeft.getChildren().addAll(this.utilisateur, this.barreRecherche, this.btnRechercher);
        hbLeft.setMargin(this.barreRecherche, new Insets(35,1,0,20));
        hbLeft.setMargin(this.btnRechercher, new Insets(35,0,0,0));
        banniere.setLeft(hbLeft);
        
        //Right
        HBox hbRight = new HBox();
        hbRight.getChildren().addAll(this.btnParametres, this.btnDeco);
        hbRight.setMargin(this.btnParametres, new Insets(20,0,0,0));
        hbRight.setMargin(this.btnDeco, new Insets(20,20,0,10));
        banniere.setRight(hbRight);
        banniere.setStyle("-fx-background-color: #0095B6");
        return banniere;

    }

    public void afficherPageConnexion(){
    


    }

    private Scene laScene(){
        BorderPane fenetre = new BorderPane();
        fenetre.setCenter(this.panelCentral);
        fenetre.setTop(header());
        return new Scene(fenetre, 1000, 800);
        
    }
    @Override
    public void start(Stage stage) throws Exception {
        //--- Chargement du fichier FXML
        stage.setTitle("SayHello FXML");
        this.mainScene = laScene(); 
        stage.setScene(this.mainScene);
        stage.show();
    }


    public static void main(String[] args) {
        //--- Lancement de l'application
        launch(args);
    }








    
}

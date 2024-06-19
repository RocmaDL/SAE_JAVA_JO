package main.java.com.cdal.view;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.Parent;

import main.java.com.cdal.controler.*;


public class AppPrincipale extends Application{

    Parent root;
    Scene mainScene;
    //BorderPane centre;
    FXMLLoader loader;
    
    public void init(){
        //--- Initialisation de l'application

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
            this.mainScene = new Scene(root);
        } catch (Exception e) {
            System.out.println("Erreur de chargement de la page PageClassementEpreuve");

        }
    }

    public void afficherPageConnexion(){
    


    }

    

    @Override
    public void start(Stage stage) throws Exception {
        //--- Chargement du fichier FXML
        afficherPageEnregistrerRes();
        stage.setTitle("SayHello FXML");
        stage.setScene(this.mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        //--- Lancement de l'application
        launch(args);
    }








    
}

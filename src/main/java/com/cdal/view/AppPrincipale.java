package main.java.com.cdal.view;

import java.io.File;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.fxml.*;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import main.java.com.cdal.controler.*;
import main.java.com.cdal.model.JeuxOlympiques;


public class AppPrincipale extends Application{

    Parent root;
    Scene mainScene;
    //BorderPane centre;
    FXMLLoader loader;
    private TextField barreRecherche;
    private Button btnRechercher;
    private Button recherche;
    private Button btnParametres;
    private Button btnDeco;
    private Parent panelCentral;
    private ImageView utilisateur;
    private JeuxOlympiques modeleJO;
    private ComboBox<String> comboBox;
  

    
    @Override
    public void init(){
        //--- Initialisation de l'application
        this.barreRecherche = new TextField();
        //Bouton Paramètres
        ImageView imgP = new ImageView(new Image("file:./img/param.png"));
        imgP.setFitWidth(40);
        imgP.setFitHeight(40);
        this.btnParametres = new Button("", imgP);
        this.btnParametres.setOnAction(new ControleurParametres(this));

         //Bouton Déconnexion
         ImageView imgD = new ImageView(new Image("file:./img/connexion.png"));
         imgD.setFitWidth(40);
         imgD.setFitHeight(40);
         this.btnDeco = new Button("", imgD);
        
        //Icone User
        this.utilisateur = new ImageView(new Image("file:./img/utilisateur.png"));
        this.utilisateur.setFitWidth(100);
        this.utilisateur.setFitHeight(100);

        //Bouton Rechercher
        this.btnRechercher = new Button("Rechercher");
        this.btnRechercher.setOnAction(new ControleurRechercherBis(this, this.barreRecherche.getText()));

        //ComboBox
        List<String> classement = Arrays.asList("classement par défaut", "classement par épreuves", "listes des JO");
        this.comboBox = new ComboBox<String>(FXCollections.observableArrayList(classement));
        this.comboBox.setPromptText("sélection classement");
        //Menu déroulant
        this.recherche = new Button("Rechercher");
        this.recherche.setOnAction(new ControleurComboBox(this.modeleJO, this, this.comboBox.getValue()));
        
        this.modeleJO = new JeuxOlympiques();
        try {
            modeleJO.chargerDonneeCSV("/home/iut45/Etudiants/o22304996/SAE/Java -IHM/src/SAE_JAVA_JO/donnees.csv");
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement des données");
        }
        
        

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
            //this.panelCentral.setCenter(this.root);
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
        // Création d'une nouvelle scène 
        System.out.println("Connexion");
        this.panelCentral = new VueConnexion();

    }

    public void afficherPageJournaliste(){
        


    }

    private Scene laScene(){
        BorderPane fenetre = new BorderPane();
        System.out.println(this.panelCentral);
        fenetre.setCenter(this.panelCentral);
        fenetre.setTop(header());
        return new Scene(fenetre, 1000, 800);
        
    }


    @Override
    public void start(Stage stage) throws Exception {
        //--- Chargement du fichier FXML
        stage.setScene(laScene());
        stage.setTitle("SayHello FXML");
        stage.show();
    }

    public static void main(String[] args) {
        //--- Lancement de l'application
        launch(args);
    }








    
}

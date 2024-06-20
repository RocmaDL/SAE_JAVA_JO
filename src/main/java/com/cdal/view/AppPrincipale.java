package main.java.com.cdal.view;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
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

public class AppPrincipale extends Application {

    Parent root;
    // BorderPane centre;
    FXMLLoader loader;
    private TextField barreRecherche;
    private Button btnRechercher;
    private Button recherche;
    private Button btnParametres;
    private Button btnDeco;
    private BorderPane panelCentral;
    private ImageView utilisateur;
    private JeuxOlympiques modeleJO;
    private ComboBox<String> comboBox;
    private Button btnRetour;
    private Button btnAvant;

    @Override
    public void init() {
        // --- Initialisation de l'application
        this.barreRecherche = new TextField();
        
        // Bouton Rechercher
        this.btnRechercher = new Button("Rechercher");
        this.btnRechercher.setOnAction(new ControleurRechercherBis(this, this.barreRecherche.getText()));

        
        this.modeleJO = new JeuxOlympiques();
        //try {
        //    modeleJO.chargerDonneeCSV("file:donnees.csv");
        //} catch (Exception e) {
        //    System.out.println("Erreur lors du chargement des donnéeshargement des données");
        //}
        this.panelCentral = new BorderPane() ;

            
        

    }

    public void afficherPageAdmin() throws Exception {
        // --- Chargement du fichier FXML
        try {
            URL url = new File("templates/PageAdmin.fxml").toURI().toURL();
            this.loader = new FXMLLoader(url);
            System.out.println("PageAdmin.fxml chargé" + loader);
            this.root = loader.load();
            this.panelCentral.setCenter(this.root);
        } catch (Exception e) {
            System.out.println("Erreur de chargement de la page Admin");

        }
    }

    public void afficherPageAjoutResultat(){
        this.panelCentral.setCenter(new VueAjoutResultat());
    }

    public void afficherPageEnregistrerRes() throws Exception {
        // --- Chargement du fichier FXML
        try {
            URL url = new File("templates/PageEpreuveResultat.fxml").toURI().toURL();
            this.loader = new FXMLLoader(url);
            System.out.println("PageEpreuveResultat.fxml chargé" + loader);
            this.root = loader.load();
            this.panelCentral.setCenter(this.root);
            Button btLancerEpreuve = (Button) this.root.lookup("#lancer_epreuve");
            System.out.println("btLancerEpreuve : " + btLancerEpreuve);
            btLancerEpreuve.setOnAction(new ControlerEpreuveResultat(this));

            Button btEnregistrerResultat = (Button) this.root.lookup("#enregistrer_res");
            btEnregistrerResultat.setOnAction(new ControlerEpreuveResultat(this));

        } catch (Exception e) {
            System.out.println("Erreur de chargement de la page EnregistrerRes");
            System.out.println(e.toString());

        }
    }
    //PageAjouterEpreuve
    public void afficherPageAjouterEpreuve() throws Exception {
        // --- Chargement du fichier FXML
        try {
            URL url = new File("templates/PageAjouterEpreuve.fxml").toURI().toURL();
            this.loader = new FXMLLoader(url);
            System.out.println("PageAjouterEpreuve.fxml chargé" + loader);
            this.root = loader.load();
            this.panelCentral.setCenter(this.root);
            Button btAjouterEpreuve = (Button) this.root.lookup("#ajouter_epreuve");
            btAjouterEpreuve.setOnAction(new ControlerAjouterEpreuve(this));

        } catch (Exception e) {
            System.out.println("Erreur de chargement de la page AjouterEpreuve gthrthrthrthtr");
            System.out.println(e.toString());

        }
    }

    public void afficherPageRechercher() {
        // --- Chargement du fichier FXML
        this.panelCentral.setCenter(new AppRechercherJO());
        
    }

    public void afficherPageAdminBis() throws Exception {
        // --- Chargement du fichier FXML
        try {
            URL url = new File("templates/PageClassementEpreuve.fxml").toURI().toURL();
            this.loader = new FXMLLoader(url);
            System.out.println("PageClassementEpreuve.fxml chargé" + loader);
            this.root = loader.load();
            this.panelCentral.setCenter(this.root);
        } catch (Exception e) {
            System.out.println("Erreur de chargement de la page PageClassementEpreuve");

        }
    }

    public Pane header() {
        BorderPane banniere = new BorderPane();
        this.barreRecherche.setPromptText("Rechercher une information");
        this.barreRecherche.setPrefWidth(300);
        this.barreRecherche.setPrefHeight(20);
        // Bouton Paramètres
        ImageView imgP = new ImageView(new Image("file:./img/param.png"));
        imgP.setFitWidth(40);
        imgP.setFitHeight(40);
        
        // Bouton Déconnexion
        ImageView imgD = new ImageView(new Image("file:./img/connexion.png"));
        imgD.setFitWidth(40);
        imgD.setFitHeight(40);
        this.btnDeco = new Button("", imgD);
        this.btnDeco.setOnAction(new ControlerDeconnexion(this));

        // Icone User
        this.utilisateur = new ImageView(new Image("file:./img/utilisateur.png"));
        this.utilisateur.setFitWidth(100);
        this.utilisateur.setFitHeight(100);

        this.btnParametres = new Button("", imgP);
        this.btnParametres.setOnAction(new ControleurParametres(this));


        HBox hbLeft = new HBox();
        hbLeft.getChildren().addAll(this.utilisateur, this.barreRecherche, this.btnRechercher);
        hbLeft.setMargin(this.barreRecherche, new Insets(35, 1, 0, 20));
        hbLeft.setMargin(this.btnRechercher, new Insets(35, 0, 0, 0));
        banniere.setLeft(hbLeft);

        // Right
        HBox hbRight = new HBox();
        hbRight.getChildren().addAll(this.btnParametres, this.btnDeco);
        hbRight.setMargin(this.btnParametres, new Insets(20, 0, 0, 0));
        hbRight.setMargin(this.btnDeco, new Insets(20, 20, 0, 10));
        banniere.setRight(hbRight);
        banniere.setStyle("-fx-background-color: #0095B6");
        return banniere;

    }

    public Pane footer(){
        BorderPane footer = new BorderPane();
        VBox vb1 = new VBox();
        ImageView imgArriere = new ImageView(new Image("file:./img/en_arriere.png"));
        imgArriere.setFitWidth(40);
        imgArriere.setFitHeight(40);
        this.btnRetour= new Button("", imgArriere);
        this.btnRetour.setOnAction(new ControlerDeconnexion(this));

        ImageView imgAvant = new ImageView(new Image("file:./img/en-avant-Copie"));
        imgAvant.setFitWidth(40);
        imgAvant.setFitHeight(40);
        this.btnAvant = new Button("", imgAvant);
        this.btnAvant.setOnAction(new ControlerDeconnexion(this));
        vb1.getChildren().addAll(this.btnRetour, this.btnAvant);

        footer.setCenter(this.btnDeco);

        return footer;

    }


    public void majAffichage() {


        
    }

    public void afficherPageConnexion() {
        // Création d'une nouvelle scène
        this.panelCentral.setCenter(new VueConnexion());
    
    }

    public void afficherPageJournaliste() {
        this.panelCentral.setCenter(new VueJournaliste());

    }

    public void modeAccueil(){
        this.afficherPageConnexion();
    
    }

    private Scene laScene() {
        BorderPane fenetre = new BorderPane();
        fenetre.setCenter(this.panelCentral);
        fenetre.setTop(this.header());
        fenetre.setBottom(this.footer());
        return new Scene(fenetre, 900,600);

    }

    @Override
    public void start(Stage stage) throws Exception {
        // --- Chargement du fichier FXML
        this.afficherPageConnexion();
        stage.setScene(laScene());
        stage.setTitle("SayHello FXML");
        stage.show();
    }

    public static void main(String[] args) {
        // --- Lancement de l'application
        launch(args);
    }

}

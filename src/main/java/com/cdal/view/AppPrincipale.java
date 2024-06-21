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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import main.java.com.cdal.controler.*;
import main.java.com.cdal.model.JeuxOlympiques;
import main.java.com.cdal.model.Utilisateur;
import main.java.com.cdal.model.ConnexionMySQL;

public class AppPrincipale extends Application {

    Parent root;
    FXMLLoader loader;
    private Button btnParametres;
    private Button btnDeco;
    private BorderPane panelCentral;
    private ImageView utilisateur;
    private JeuxOlympiques modeleJO;
    private ComboBox<String> comboBox;
    private Button btnRetour;
    private Button btnAvant;
    private URL url;
    private ConnexionMySQL laConnexion;
    private Utilisateur user;

    @Override
    public void init() {
        // --- Initialisation de l'application

        this.modeleJO = new JeuxOlympiques();
        // try {
        // modeleJO.chargerDonneeCSV("file:donnees.csv");
        // } catch (Exception e) {
        // System.out.println("Erreur lors du chargement des donnéeshargement des
        // données");
        // }
        this.panelCentral = new BorderPane();
        this.btnDeco = new Button("");
        this.btnParametres = new Button("");
        this.btnRetour = new Button("");
        try {
            this.laConnexion = new ConnexionMySQL();
            this.laConnexion.connecter("servinfo-maria", "DBdimba", "dimba", "dimba");
        } catch (Exception e) {
            System.out.println("Erreur lors de la connexion à la base de données");
            System.out.println(e.toString());
        }
        
    

    }

    public void afficherPageAdmin() throws Exception {
        // --- Chargement du fichier FXML
        try {
            this.url = new File("templates/PageAdminBis.fxml").toURI().toURL();
            this.loader = new FXMLLoader(this.url);
            System.out.println("PageAdmin.fxml chargé" + loader);
            this.root = loader.load();
            this.panelCentral.setCenter(this.root);
        } catch (Exception e) {
            System.out.println("Erreur de chargement de la page Admin");
            System.out.println(e.toString());

        }
    }

    public void afficherPageAjoutResultat() {
        this.panelCentral.setCenter(new VueAjoutResultat());
    }

    public void afficherPageEnregistrerRes() throws Exception {
        // --- Chargement du fichier FXML
        try {
            this.url = new File("templates/PageEpreuveResultat.fxml").toURI().toURL();
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

    // PageAjouterEpreuve
    public void afficherPageAjouterEpreuve() throws Exception {
        // --- Chargement du fichier FXML
        try {
            this.url = new File("templates/PageAjouterEpreuve.fxml").toURI().toURL();
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
            this.url = new File("templates/PageClassementEpreuve.fxml").toURI().toURL();
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
        hbLeft.getChildren().add(this.utilisateur);
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

    public Pane footer() {
        BorderPane footer = new BorderPane();
        VBox vb1 = new VBox();

        Text text = new Text("Retour");

        text.setStyle("-fx-font: 40 arial;");
        text.setStyle("-fx-stroke-width: 1.5;");

        this.btnRetour = new Button("", text);
        this.btnRetour.setStyle("-fx-background-color: #0095B6;");
        this.btnRetour.setOnAction(new ControlerRetour(this));
        this.btnRetour.setPrefWidth(80); // Largeur du bouton
        this.btnRetour.setPrefHeight(50); // Hauteur du bouton
        this.btnRetour.setStyle("-fx-font: 20 arial;"); // Taille de la police

        ImageView imgAvant = new ImageView(new Image("file:./img/en-avant-Copie.png"));
        imgAvant.setFitWidth(40);
        imgAvant.setFitHeight(40);
        this.btnAvant = new Button("", imgAvant);
        this.btnAvant.setOnAction(new ControlerDeconnexion(this));
        vb1.getChildren().addAll(this.btnRetour);

        footer.setCenter(this.btnRetour);

        return footer;

    }

    public void majAffichage() {

    }

    public void afficherPageConnexion() {
        // Création d'une nouvelle scène
        this.panelCentral.setCenter(new VueConnexion(this));
        DesactiverBouton(this.btnRetour);
        DesactiverBouton(this.btnDeco);
        this.btnRetour = null;

    }

    public void afficherPageInscription() {
        this.panelCentral.setCenter(new VueInscription(this));
        this.btnRetour = null;
    }

    public void afficherPageJournaliste() {
        this.panelCentral.setCenter(new VueJournaliste());
        ActiverBouton(this.btnRetour);
        ActiverBouton(this.btnDeco);

    }

    public void modeAccueil() {
        this.afficherPageConnexion();
    }

    public void DesactiverBouton(Button bouton1) {
        bouton1.setDisable(true);
    }

    public void ActiverBouton(Button bouton1) {
        bouton1.setDisable(false);
    }

    public ConnexionMySQL getConnexion() {
        return this.laConnexion;
    }

    public BorderPane getPanelCentral() {
        return this.panelCentral;
    }

    private Scene laScene() {
        BorderPane fenetre = new BorderPane();
        fenetre.setCenter(this.panelCentral);
        fenetre.setTop(this.header());
        if (this.btnRetour != null){
            fenetre.setBottom(this.footer());
        }
        return new Scene(fenetre, 900, 600);
    }

    public void setUser(Utilisateur user) {
        this.user = user;
    }

    @Override
    public void start(Stage stage) throws Exception {
        // --- Chargement du fichier FXML

        stage.setScene(laScene());
        this.afficherPageConnexion();
        stage.setTitle("Jeux IUT'Olympiques");
        stage.show();
    }

    public static void main(String[] args) {
        // --- Lancement de l'application
        launch(args);
    }

}

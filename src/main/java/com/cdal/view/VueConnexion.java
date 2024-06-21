package main.java.com.cdal.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import javafx.stage.Stage;
import javafx.scene.control.Hyperlink;

import main.java.com.cdal.controler.ControleurAide;
import main.java.com.cdal.controler.ControleurConnexion;
import main.java.com.cdal.controler.ControleurLienInscription;

public class VueConnexion extends VBox {

    private ControleurConnexion controleur;

    private TextField champNomUtilisateur;
    private PasswordField champMotDePasse;
    private TextField champMotDePasseVisible;
    private Button boutonValider;
    private Button boutonAnnuler;
    private Button boutonAfficherMasquerMotDePasse;
    private Text messageAction;
    private Hyperlink lienInscription;
    private AppPrincipale appPrincipale;

    private boolean motDePasseVisible = false;

    public VueConnexion(AppPrincipale appPrincipale) {
        // primaryStage.setTitle("Connexion aux Jeux Olympiques");

        Button aideBouton = new Button("Aide");
        ImageView aideImageView = new ImageView(new Image("file:img/aide.png"));
        aideImageView.setFitHeight(16);
        aideImageView.setFitWidth(16);
        aideBouton.setGraphic(aideImageView);

        aideBouton.setOnAction(new ControleurAide(this));
        VBox root = new VBox(20);
        root.setPadding(new Insets(25, 25, 25, 25));
        root.setAlignment(Pos.TOP_CENTER);
        root.setStyle("-fx-background-color: #f0f0f0;");

        HBox imagesPane = new HBox(10);
        imagesPane.setAlignment(Pos.CENTER);
        Image iutImage = new Image("file:img/logo-iut.png");
        ImageView iutImageView = new ImageView(iutImage);
        iutImageView.setFitWidth(100);
        iutImageView.setPreserveRatio(true);
        Image olympicsImage = new Image("file:img/jeu.png");
        ImageView olympicsImageView = new ImageView(olympicsImage);
        olympicsImageView.setFitWidth(100);
        olympicsImageView.setPreserveRatio(true);
        imagesPane.getChildren().addAll(iutImageView, creerPaneTitre(), olympicsImageView);

        root.getChildren().add(imagesPane);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(10));

        Image accueil = new Image("file:img/image_accueil.jpg");
        ImageView imageView = new ImageView(accueil);
        imageView.setFitWidth(950);
        imageView.setPreserveRatio(true);

        VBox loginBox = new VBox(20);
        loginBox.setAlignment(Pos.CENTER);
        loginBox.setPadding(new Insets(20));
        loginBox.setStyle(
                "-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");

        GridPane grille = new GridPane();
        grille.setAlignment(Pos.CENTER);
        grille.setHgap(10);
        grille.setVgap(10);

        Label labelNomUtilisateur = new Label("Nom d'utilisateur:");
        labelNomUtilisateur.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        champNomUtilisateur = new TextField();
        champNomUtilisateur.setPromptText("Votre nom d'utilisateur ");
        grille.add(labelNomUtilisateur, 0, 0);
        grille.add(champNomUtilisateur, 1, 0);

        Label labelMotDePasse = new Label("Mot de passe:");
        labelMotDePasse.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        champMotDePasse = new PasswordField();
        champMotDePasseVisible = new TextField();
        champMotDePasseVisible.setPromptText("Votre mot de passe ");
        champMotDePasseVisible.setManaged(false);
        champMotDePasseVisible.setVisible(false);
        grille.add(labelMotDePasse, 0, 1);
        grille.add(champMotDePasse, 1, 1);
        grille.add(champMotDePasseVisible, 1, 1);

        Image oeilImage = new Image("file:img/eye.png");
        ImageView iconeOeil = new ImageView(oeilImage);
        iconeOeil.setFitHeight(20);
        iconeOeil.setFitWidth(20);
        boutonAfficherMasquerMotDePasse = new Button("", iconeOeil);
        boutonAfficherMasquerMotDePasse.setStyle("-fx-background-color: transparent;");
        grille.add(boutonAfficherMasquerMotDePasse, 2, 1);

        loginBox.getChildren().add(grille);

        HBox paneBoutons = new HBox(10);
        paneBoutons.setAlignment(Pos.CENTER);
        boutonValider = new Button("Valider");
        boutonValider.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        boutonValider.setOnAction(new ControleurConnexion(this));
        boutonAnnuler = new Button("Annuler");
        boutonAnnuler.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-weight: bold;");

        Image imgAnnuler = new Image("file:img/annuler.png");
        ImageView imageAnnuler = new ImageView(imgAnnuler);
        imageAnnuler.setFitHeight(16);
        imageAnnuler.setFitWidth(16);
        boutonAnnuler.setGraphic(imageAnnuler);

        Image imageValider = new Image("file:img/valider.png");
        ImageView imageValiderView = new ImageView(imageValider);
        imageValiderView.setFitHeight(16);
        imageValiderView.setFitWidth(16);
        boutonValider.setGraphic(imageValiderView);

        paneBoutons.getChildren().addAll(boutonAnnuler, aideBouton, boutonValider);

        lienInscription = new Hyperlink("Pas de compte? Inscrivez-vous");
        lienInscription.setOnAction(new ControleurLienInscription(appPrincipale));

        loginBox.getChildren().addAll(paneBoutons, lienInscription);

        messageAction = new Text();
        loginBox.getChildren().add(messageAction);

        root.getChildren().addAll(loginBox, hbox);
        this.getChildren().add(root);

        controleur = new ControleurConnexion(this);
        controleur.initialiserActions();

        boutonAfficherMasquerMotDePasse.setOnAction(e -> afficherMasquerMotDePasse());

    }

    private VBox creerPaneTitre() {
        Text titreScene = new Text("Bienvenue aux IUT'Olympiques");
        titreScene.setFont(Font.font("Tahoma", FontWeight.BOLD, 30));
        titreScene.setFill(Color.rgb(0, 47, 108));
        VBox titrePane = new VBox(titreScene);
        titrePane.setAlignment(Pos.CENTER);
        return titrePane;
    }

    public TextField getChampNomUtilisateur() {
        return champNomUtilisateur;
    }

    public PasswordField getChampMotDePasse() {
        return champMotDePasse;
    }

    public TextField getChampMotDePasseVisible() {
        return champMotDePasseVisible;
    }

    public Button getBoutonValider() {
        return boutonValider;
    }

    public Button getBoutonAnnuler() {
        return boutonAnnuler;
    }

    public Button getBoutonAfficherMasquerMotDePasse() {
        return boutonAfficherMasquerMotDePasse;
    }

    public Text getMessageAction() {
        return messageAction;
    }

    public void afficherMasquerMotDePasse() {
        motDePasseVisible = !motDePasseVisible;
        if (motDePasseVisible) {
            champMotDePasseVisible.setText(champMotDePasse.getText());
            champMotDePasseVisible.setVisible(true);
            champMotDePasseVisible.setManaged(true);
            champMotDePasse.setVisible(false);
            champMotDePasse.setManaged(false);
        } else {
            champMotDePasse.setText(champMotDePasseVisible.getText());
            champMotDePasse.setVisible(true);
            champMotDePasse.setManaged(true);
            champMotDePasseVisible.setVisible(false);
            champMotDePasseVisible.setManaged(false);
        }
    }

    public String getMotDePasse() {
        return motDePasseVisible ? champMotDePasseVisible.getText() : champMotDePasse.getText();
    }

    public String getNomUtilisateur() {
        return champNomUtilisateur.getText();
    }

    public Hyperlink getLienInscription() {
        return lienInscription;
    }

    public void setMessageAction(String message, Color color) {
        messageAction.setText(message);
        messageAction.setFill(color);
    }

    public void clearFields() {
        champNomUtilisateur.clear();
        champMotDePasse.clear();
        champMotDePasseVisible.clear();
        messageAction.setText("");
    }

    public Alert popUpRegleConnexion() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Règles de Connexion");
        alert.setHeaderText("Instructions de Connexion");
        alert.setContentText("Pour vous connecter, veuillez respecter les consignes suivantes :\n"
                + "1. Votre nom d'utilisateur doit inclure votre rôle, suivi d'un espace, puis votre nom et prénom.\n"
                + "2. Votre mot de passe doit être votre date de naissance au format jj/mm/aaaa.");
        alert.getDialogPane().setPrefSize(600, 400);

        return alert;
    }
}
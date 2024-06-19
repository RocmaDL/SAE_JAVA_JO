package main.java.com.cdal.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import main.java.com.cdal.controler.ControleurConnexion;

public class VueConnexion extends Application {

    private ControleurConnexion controleur;

    private TextField champNomUtilisateur;
    private PasswordField champMotDePasse;
    private TextField champMotDePasseVisible;
    private Button boutonValider;
    private Button boutonAnnuler;
    private Button boutonAfficherMasquerMotDePasse;
    private Text messageAction;

    private boolean motDePasseVisible = false;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Connexion aux Jeux Olympiques");

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


        VBox loginBox = new VBox(20);
        loginBox.setAlignment(Pos.CENTER);
        loginBox.setPadding(new Insets(20));
        loginBox.setStyle("-fx-background-color: #ffffff; -fx-border-color: #000000; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");

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
        boutonAnnuler = new Button("Annuler");
        boutonAnnuler.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-weight: bold;");
        paneBoutons.getChildren().addAll(boutonAnnuler, boutonValider);

        loginBox.getChildren().add(paneBoutons);

        messageAction = new Text();
        loginBox.getChildren().add(messageAction);

        root.getChildren().add(loginBox);

        primaryStage.setScene(new Scene(root, 1200, 900));

        controleur = new ControleurConnexion(this);
        controleur.initialiserActions();

        boutonAfficherMasquerMotDePasse.setOnAction(e -> afficherMasquerMotDePasse());

        primaryStage.show();
    }

    private VBox creerPaneTitre() {
        Text titreScene = new Text("Bienvenue aux Jeux Olympiques");
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

    public static void main(String[] args) {
        launch(args);
    }
}

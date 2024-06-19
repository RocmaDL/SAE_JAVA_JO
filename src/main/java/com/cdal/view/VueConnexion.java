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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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

        GridPane grille = new GridPane();
        grille.setAlignment(Pos.CENTER);
        grille.setHgap(10);
        grille.setVgap(10);
        grille.setPadding(new Insets(25, 25, 25, 25));
        grille.setStyle("-fx-background-color: #f0f0f0;");

        Image iutImage = new Image("file:img/logo-iut.png");
        ImageView iutImageView = new ImageView(iutImage);
        iutImageView.setFitWidth(100);
        iutImageView.setPreserveRatio(true);

        Image olympicsImage = new Image("file:img/jeu.png");
        ImageView olympicsImageView = new ImageView(olympicsImage);
        olympicsImageView.setFitWidth(100);
        olympicsImageView.setPreserveRatio(true);

        HBox imagesPane = new HBox(10);
        imagesPane.setAlignment(Pos.CENTER);
        imagesPane.getChildren().addAll(iutImageView, creerPaneTitre(), olympicsImageView);

        grille.add(imagesPane, 0, 0, 3, 1);

        Label labelNomUtilisateur = new Label("Nom d'utilisateur:");
        labelNomUtilisateur.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        grille.add(labelNomUtilisateur, 0, 1);

        champNomUtilisateur = new TextField();
        grille.add(champNomUtilisateur, 1, 1);

        Label labelMotDePasse = new Label("Mot de passe:");
        labelMotDePasse.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
        grille.add(labelMotDePasse, 0, 2);

        champMotDePasse = new PasswordField();
        champMotDePasseVisible = new TextField();
        champMotDePasseVisible.setManaged(false);
        champMotDePasseVisible.setVisible(false);
        grille.add(champMotDePasse, 1, 2);

        Image oeilImage = new Image("file:img/eye.png");
        ImageView iconeOeil = new ImageView(oeilImage);
        iconeOeil.setFitHeight(20);
        iconeOeil.setFitWidth(20);
        boutonAfficherMasquerMotDePasse = new Button("", iconeOeil);
        boutonAfficherMasquerMotDePasse.setStyle("-fx-background-color: transparent;");
        grille.add(boutonAfficherMasquerMotDePasse, 2, 2);

        boutonValider = new Button("Valider");
        boutonValider.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");
        boutonAnnuler = new Button("Annuler");
        boutonAnnuler.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-weight: bold;");

        HBox paneBoutons = new HBox(10);
        paneBoutons.setAlignment(Pos.CENTER);
        paneBoutons.getChildren().addAll(boutonAnnuler, boutonValider);
        grille.add(paneBoutons, 0, 3, 3, 1);

        messageAction = new Text();
        grille.add(messageAction, 0, 4, 3, 1);

        primaryStage.setScene(new Scene(grille, 800, 600));

        // Création du contrôleur et liaison avec la vue
        controleur = new ControleurConnexion(this);
        controleur.initialiserActions();

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

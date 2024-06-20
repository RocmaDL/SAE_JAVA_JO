package main.java.com.cdal.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class VueInscription extends GridPane {

    public VueInscription() {

        GridPane grille = new GridPane();
        grille.setAlignment(Pos.CENTER);
        grille.setHgap(10);
        grille.setVgap(10);
        grille.setPadding(new Insets(25));
        
        Label titreScene = new Label("Inscription");
        titreScene.setAlignment(Pos.CENTER); 
        titreScene.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        grille.add(titreScene, 1, 0, 2, 1);
        

        Label nomLabel = new Label("Nom:");
        grille.add(nomLabel, 0, 1);
        TextField nomChamp = new TextField();
        nomChamp.setPromptText("Entrez votre nom");
        grille.add(nomChamp, 1, 1);

        Label emailLabel = new Label("Email:");
        grille.add(emailLabel, 0, 2);
        TextField emailChamp = new TextField();
        emailChamp.setPromptText("Entrez votre email");
        grille.add(emailChamp, 1, 2);

        Label motDePasseLabel = new Label("Mot de passe:");
        grille.add(motDePasseLabel, 0, 3);
        PasswordField motDePasseChamp = new PasswordField();
        motDePasseChamp.setPromptText("Entrez votre mot de passe");
        grille.add(motDePasseChamp, 1, 3);

        Image oeilImage = new Image("file:img/eye.png");
        ImageView oeilIcon = new ImageView(oeilImage);
        oeilIcon.setFitHeight(20);
        oeilIcon.setFitWidth(20);
        ToggleButton boutonToggleMotDePasse = new ToggleButton("", oeilIcon);
        boutonToggleMotDePasse.setStyle("-fx-background-color: transparent;");
        grille.add(boutonToggleMotDePasse, 2, 3);

        Label roleLabel = new Label("Rôle:");
        grille.add(roleLabel, 0, 4);
        ComboBox<String> roleComboBox = new ComboBox<>();
        roleComboBox.getItems().addAll("Journaliste", "Organisateur", "Administrateur");
        roleComboBox.setPromptText("Sélectionnez votre rôle");
        grille.add(roleComboBox, 1, 4);

        Button boutonInscription = new Button("S'inscrire");
        boutonInscription.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        Tooltip infoBulle = new Tooltip("Cliquez ici pour vous inscrire");
        boutonInscription.setTooltip(infoBulle);
        grille.add(boutonInscription, 1, 5);

        Button boutonRetour = new Button("Retour");
        grille.add(boutonRetour, 0, 5);


    }
}

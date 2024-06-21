package main.java.com.cdal.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class VueInscription extends GridPane {

    public VueInscription() {

     
        this.setAlignment(Pos.CENTER);
        this.setHgap(10);
        this.setVgap(10);
        this.setPadding(new Insets(25));
        
        Label titreScene = new Label("Inscription");
        titreScene.setAlignment(Pos.CENTER); 
        titreScene.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        this.add(titreScene, 1, 0, 2, 1);
        

        Label nomLabel = new Label("Nom:");
        this.add(nomLabel, 0, 1);
        TextField nomChamp = new TextField();
        nomChamp.setPromptText("Entrez votre nom");
        this.add(nomChamp, 1, 1);

        Label emailLabel = new Label("Email:");
        this.add(emailLabel, 0, 2);
        TextField emailChamp = new TextField();
        emailChamp.setPromptText("Entrez votre email");
        this.add(emailChamp, 1, 2);

        Label motDePasseLabel = new Label("Mot de passe:");
        this.add(motDePasseLabel, 0, 3);
        PasswordField motDePasseChamp = new PasswordField();
        motDePasseChamp.setPromptText("Entrez votre mot de passe");
        this.add(motDePasseChamp, 1, 3);

        Image oeilImage = new Image("file:img/eye.png");
        ImageView oeilIcon = new ImageView(oeilImage);
        oeilIcon.setFitHeight(20);
        oeilIcon.setFitWidth(20);
        ToggleButton boutonToggleMotDePasse = new ToggleButton("", oeilIcon);
        boutonToggleMotDePasse.setStyle("-fx-background-color: transparent;");
        this.add(boutonToggleMotDePasse, 2, 3);

        Label roleLabel = new Label("Rôle:");
        this.add(roleLabel, 0, 4);
        ComboBox<String> roleComboBox = new ComboBox<>();
        roleComboBox.getItems().addAll("Journaliste", "Organisateur", "Administrateur");
        roleComboBox.setPromptText("Sélectionnez votre rôle");
        this.add(roleComboBox, 1, 4);

        Button boutonInscription = new Button("S'inscrire");
        boutonInscription.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        Tooltip infoBulle = new Tooltip("Cliquez ici pour vous inscrire");
        boutonInscription.setTooltip(infoBulle);
        this.add(boutonInscription, 1, 5);

        Button boutonRetour = new Button("Retour");
        this.add(boutonRetour, 0, 5);
    


    }
}

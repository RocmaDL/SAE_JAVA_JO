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

public class VueInscription extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Inscription aux Jeux Olympiques");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25));
        
        Label scenetitle = new Label("Inscription");
        scenetitle.setAlignment(Pos.CENTER); 
        scenetitle.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        grid.add(scenetitle, 1, 0, 2, 1);
        

        Label nameLabel = new Label("Nom:");
        grid.add(nameLabel, 0, 1);
        TextField nameField = new TextField();
        nameField.setPromptText("Entrez votre nom");
        grid.add(nameField, 1, 1);

        Label emailLabel = new Label("Email:");
        grid.add(emailLabel, 0, 2);
        TextField emailField = new TextField();
        emailField.setPromptText("Entrez votre email");
        grid.add(emailField, 1, 2);

        Label passwordLabel = new Label("Mot de passe:");
        grid.add(passwordLabel, 0, 3);
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Entrez votre mot de passe");
        grid.add(passwordField, 1, 3);

        // Bouton pour afficher/masquer le mot de passe
        Image eyeImage = new Image("file:img/eye.png");
        ImageView eyeIcon = new ImageView(eyeImage);
        eyeIcon.setFitHeight(20);
        eyeIcon.setFitWidth(20);
        ToggleButton togglePasswordVisibilityBtn = new ToggleButton("", eyeIcon);
        togglePasswordVisibilityBtn.setStyle("-fx-background-color: transparent;");
        grid.add(togglePasswordVisibilityBtn, 2, 3);

        Label roleLabel = new Label("Rôle:");
        grid.add(roleLabel, 0, 4);
        ComboBox<String> roleComboBox = new ComboBox<>();
        roleComboBox.getItems().addAll("Journaliste", "Organisateur", "Administrateur");
        roleComboBox.setPromptText("Sélectionnez votre rôle");
        grid.add(roleComboBox, 1, 4);

        Button registerBtn = new Button("S'inscrire");
        registerBtn.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        Tooltip tooltip = new Tooltip("Cliquez ici pour vous inscrire");
        registerBtn.setTooltip(tooltip);
        grid.add(registerBtn, 1, 5);

        Button backButton = new Button("Retour");
        backButton.setOnAction(e -> {
        });
        grid.add(backButton, 0, 5);


        registerBtn.setOnAction(e -> {
            if (nameField.getText().isEmpty() || emailField.getText().isEmpty() || passwordField.getText().isEmpty() || roleComboBox.getValue() == null) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Champs obligatoires");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez remplir tous les champs.");
                alert.showAndWait();
            } else {
                System.out.println("Inscription réussie !");
            }
        });


        Scene scene = new Scene(grid, 1200, 900);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

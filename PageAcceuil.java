/**
 * Classe PageAcceuil qui étend la classe Application de JavaFX.
 * Cette classe crée et affiche une interface graphique pour une page de connexion.
 */
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;

public class PageAcceuil extends Application {

    /**
     * Point d'entrée principal de l'application JavaFX.
     * Crée et configure les éléments de l'interface graphique, puis les affiche.
     * @param primaryStage la scène principale de l'application
     */
    @Override
    public void start(Stage primaryStage) {
        System.out.println("UWU");
        
        // Création et configuration du label de titre
        Label titleLabel = new Label("Page de connexion");
        titleLabel.setFont(new Font("Arial", 24));

        // Création et configuration du champ de texte pour l'ID
        TextField idField = new TextField();
        idField.setPromptText("Id");
        System.out.println("zzz");

        // Création et configuration du champ de texte pour le mot de passe
        TextField mdpField = new TextField();
        mdpField.setPromptText("mdp");
        System.out.println("Z&a");

        // Création et configuration du bouton de connexion
        Button connexionButton = new Button("Connexion");
        connexionButton.setOnAction(e -> {
            String id = idField.getText();
            String mdp = mdpField.getText();
            if (id.equals("admin") && mdp.equals("admin")) {
                System.out.println("Connexion réussie");
            } else {
                System.out.println("Erreur de connexion");
            }
        });
        System.out.println("ééé");

        // Chargement et configuration de l'image de connexion
        Image image = new Image("imagespconnexion.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        
        System.out.println("OK");

        // Création et configuration d'un label supplémentaire "JO"
        Label joLabel = new Label("JO");
        joLabel.setFont(new Font("Arial", 24));
        
        // Création et configuration du layout GridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        // Ajout des éléments à la grille
        gridPane.add(titleLabel, 0, 0, 2, 1);
        gridPane.add(idField, 0, 2);
        gridPane.add(mdpField, 0, 4);
        gridPane.add(connexionButton, 0, 5);
        gridPane.add(imageView, 5, 3, 1, 4);       
        gridPane.add(joLabel, 3, 1, 1, 4);        
        
        // Création et configuration de la scène
        Scene scene = new Scene(gridPane, 600, 400);
        
        System.out.println("OK2");

        // Configuration de la scène principale
        primaryStage.setTitle("Page de connexion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Méthode main qui lance l'application JavaFX.
     * @param args arguments de ligne de commande
     */
    public static void main(String[] args) {
        launch(args);
    }
}

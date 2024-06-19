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

    @Override
    public void start(Stage primaryStage) {
        System.out.println("UWU");
        Label titleLabel = new Label("Page de connexion");
        titleLabel.setFont(new Font("Arial", 24));
        TextField idField = new TextField();
        idField.setPromptText("Id");
        System.out.println("zzz");
        
        TextField mdpField = new TextField();
        mdpField.setPromptText("mdp");
        System.out.println("Z&a");

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


        Image image = new Image("imagespconnexion.png");
        ImageView imageView = new ImageView(image);
        
        System.out.println("OK");

        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        
        Label joLabel = new Label("JO");
        joLabel.setFont(new Font("Arial", 24));
        
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        
        gridPane.add(titleLabel, 0, 0, 2, 1);
        gridPane.add(idField, 0, 2);
        gridPane.add(mdpField, 0, 4);
        gridPane.add(connexionButton, 0, 5);
        gridPane.add(imageView, 5, 3, 1, 4);       
        gridPane.add(joLabel, 3, 1, 1, 4);        
        
        Scene scene = new Scene(gridPane, 600, 400);
        
        System.out.println("OK2");
        primaryStage.setTitle("Page de connexion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}


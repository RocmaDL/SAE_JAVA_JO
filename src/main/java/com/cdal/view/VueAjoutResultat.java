package main.java.com.cdal.view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VueAjoutResultat extends Application {

    private ComboBox<String> comboEpreuve;
    private TextField champPays;
    private TextField champNom;
    private TextField champPrenom;
    private TextField champResultat;
    private TableView<String> tableResultats; // Tableau simplifié sans classe Resultat
    private Label messageAction;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ajouter un Résultat");

        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

        // Partie supérieure : champs de saisie et bouton Ajouter
        VBox topBox = new VBox(10);
        topBox.setAlignment(Pos.CENTER);

        comboEpreuve = new ComboBox<>();
        comboEpreuve.setPromptText("Choisir une épreuve...");

        champPays = new TextField();
        champPays.setPromptText("Pays");
        

        champNom = new TextField();
        champNom.setPromptText("Nom");

        champPrenom = new TextField();
        champPrenom.setPromptText("Prénom");

        champResultat = new TextField();
        champResultat.setPromptText("Résultat");

        Button boutonAjouter = new Button("Ajouter");

        Tooltip tooltip = new Tooltip("Ajouter un nouveau résultat !");

        boutonAjouter.setTooltip(tooltip);

        HBox champsBox = new HBox(10);
        champsBox.getChildren().addAll(comboEpreuve, champPays, champNom, champPrenom, champResultat, boutonAjouter);
        champsBox.setAlignment(Pos.CENTER);

        topBox.getChildren().add(champsBox);
        root.setTop(topBox);

        // Partie centrale : tableau des résultats
        tableResultats = new TableView<>();
        tableResultats.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<String, String> colonneResultat = new TableColumn<>("Résultat");
        colonneResultat.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue()));

        tableResultats.getColumns().add(colonneResultat);

        VBox centerBox = new VBox(10);
        centerBox.getChildren().add(tableResultats);
        centerBox.setPadding(new Insets(10));
        root.setCenter(centerBox);

        // Partie inférieure : message d'action
        messageAction = new Label();
        messageAction.setTextFill(Color.RED);

        VBox bottomBox = new VBox(10);
        bottomBox.getChildren().add(messageAction);
        bottomBox.setAlignment(Pos.CENTER);
        root.setBottom(bottomBox);

        // Définir la scène principale
        Scene scene = new Scene(root, 1200, 900);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

/**
 * Classe PageAdmin qui étend la classe Application de JavaFX.
 * Cette classe crée une interface graphique pour gérer les informations administratives liées aux sports.
 * Elle inclut des ComboBox pour choisir le sport, la catégorie, le pays, le genre, ainsi que les médailles.
 */
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PageAdmin extends Application {

    /**
     * Méthode principale de l'application JavaFX qui configure et affiche l'interface graphique.
     * @param primaryStage la scène principale de l'application
     */
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));

        // ComboBox pour les sports
        ObservableList<String> sportsList = FXCollections.observableArrayList("Athlétisme", "Escrime", "Handball", "Natation", "Volleyball");
        ComboBox<String> sportComboBox = new ComboBox<>(sportsList);
        sportComboBox.setPromptText("Choisir sport");
        GridPane.setConstraints(sportComboBox, 0, 0);

        // ComboBox pour les catégories
        ObservableList<String> categoriesList = FXCollections.observableArrayList("Seul", "En equipe");
        ComboBox<String> categoryComboBox = new ComboBox<>(categoriesList);
        categoryComboBox.setPromptText("Categorie");
        GridPane.setConstraints(categoryComboBox, 4, 0);

        // ComboBox pour les pays
        ObservableList<String> countriesList = FXCollections.observableArrayList("Etats Unis", "Chine", "Japon", "Grande Bretagne", "ROC", "France");
        ComboBox<String> countryComboBox = new ComboBox<>(countriesList);
        countryComboBox.setPromptText("Pays");
        GridPane.setConstraints(countryComboBox, 0, 2);

        // ComboBox pour les genres
        ObservableList<String> gendersList = FXCollections.observableArrayList("Homme", "Femme");
        ComboBox<String> genderComboBox = new ComboBox<>(gendersList);
        genderComboBox.setPromptText("Genre");
        GridPane.setConstraints(genderComboBox, 4, 2);

        // Liste d'entiers pour les médailles
        ObservableList<Integer> medalList = FXCollections.observableArrayList();
        for (int i = 0; i <= 45; i++) {
            medalList.add(i);
        }

        // ComboBox pour la médaille d'or
        ComboBox<Integer> goldMedalComboBox = new ComboBox<>(medalList);
        goldMedalComboBox.setPromptText("Medaille d'or");
        GridPane.setConstraints(goldMedalComboBox, 0, 4);

        // ComboBox pour la médaille d'argent
        ComboBox<Integer> silverMedalComboBox = new ComboBox<>(medalList);
        silverMedalComboBox.setPromptText("Medaille Argent");
        GridPane.setConstraints(silverMedalComboBox, 4, 4);

        // ComboBox pour la médaille de bronze
        ComboBox<Integer> bronzeMedalComboBox = new ComboBox<>(medalList);
        bronzeMedalComboBox.setPromptText("Medaille de bronze");
        GridPane.setConstraints(bronzeMedalComboBox, 0, 6);

        // Bouton pour sauvegarder
        Button saveButton = new Button("Sauvegarder");
        GridPane.setConstraints(saveButton, 0, 12);

        // Bouton pour réinitialiser les ComboBox
        Button resetButton = new Button("Réinitialiser");
        GridPane.setConstraints(resetButton, 4, 12);
        resetButton.setOnAction(e -> {
            sportComboBox.getSelectionModel().select("Choisir sport");
            categoryComboBox.getSelectionModel().select("Categorie");
            countryComboBox.getSelectionModel().select("Pays");
            genderComboBox.getSelectionModel().select("Genre");
            goldMedalComboBox.getSelectionModel().select(0);
            silverMedalComboBox.getSelectionModel().select(0);
            bronzeMedalComboBox.getSelectionModel().select(0);
        });

        root.getChildren().addAll(sportComboBox, categoryComboBox, countryComboBox, genderComboBox,
                                   goldMedalComboBox, silverMedalComboBox, bronzeMedalComboBox,
                                   saveButton, resetButton);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Page Administrateur");
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

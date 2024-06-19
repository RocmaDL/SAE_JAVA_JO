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

    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();
        root.setAlignment(Pos.CENTER);
        root.setHgap(10);
        root.setVgap(10);
        root.setPadding(new Insets(25, 25, 25, 25));

        // ComboBox for sports
        ObservableList<String> sportsList = FXCollections.observableArrayList("Athlétisme", "Escrime", "Handball", "Natation", "Volleyball");
        ComboBox<String> sportComboBox = new ComboBox<>(sportsList);
        sportComboBox.setPromptText("Choisir sport");
        GridPane.setConstraints(sportComboBox, 0, 0);

        // ComboBox for categories
        ObservableList<String> categoriesList = FXCollections.observableArrayList("Seul", "En equipe");
        ComboBox<String> categoryComboBox = new ComboBox<>(categoriesList);
        categoryComboBox.setPromptText("Categorie");
        GridPane.setConstraints(categoryComboBox, 4, 0);

        // ComboBox for countries
        ObservableList<String> countriesList = FXCollections.observableArrayList("Etats Unis", "Chine", "Japon", "Grande Bretagne", "ROC", "France");
        ComboBox<String> countryComboBox = new ComboBox<>(countriesList);
        countryComboBox.setPromptText("Pays");
        GridPane.setConstraints(countryComboBox, 0, 2);

        // ComboBox for gender
        ObservableList<String> gendersList = FXCollections.observableArrayList("Homme", "Femme");
        ComboBox<String> genderComboBox = new ComboBox<>(gendersList);
        genderComboBox.setPromptText("Genre");
        GridPane.setConstraints(genderComboBox, 4, 2);

        ObservableList<Integer> medalList = FXCollections.observableArrayList();
        for (int i = 0; i <= 45; i++) {
            medalList.add(i);
        }

        // ComboBox for gold medal
        ComboBox<Integer> goldMedalComboBox = new ComboBox<>(medalList);
        goldMedalComboBox.setPromptText("Medaille d'or");
        GridPane.setConstraints(goldMedalComboBox, 0, 4);

        // ComboBox for silver medal
        ComboBox<Integer> silverMedalComboBox = new ComboBox<>(medalList);
        silverMedalComboBox.setPromptText("Medaille Argent");
        GridPane.setConstraints(silverMedalComboBox, 4, 4);

        // ComboBox for bronze medal
        ComboBox<Integer> bronzeMedalComboBox = new ComboBox<>(medalList);
        bronzeMedalComboBox.setPromptText("Medaille de bronze");
        GridPane.setConstraints(bronzeMedalComboBox, 0, 6);

         Button saveButton = new Button("Sauvegarder");
         GridPane.setConstraints(saveButton, 0, 12);
 

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
 

        root.getChildren().addAll(sportComboBox, categoryComboBox, countryComboBox, genderComboBox, goldMedalComboBox, silverMedalComboBox, bronzeMedalComboBox, saveButton, resetButton);

        Scene scene = new Scene(root, 600, 400);
        primaryStage.setTitle("Page Administrateur");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
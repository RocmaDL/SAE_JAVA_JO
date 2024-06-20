package main.java.com.cdal.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import main.java.com.cdal.controler.ControleurAjoutResultat;
import main.java.com.cdal.model.Resultat;

public class VueAjoutResultat extends VBox {

    private ComboBox<String> comboEpreuve;
    private TextField champPays;
    private TextField champNom;
    private TextField champPrenom;
    private TextField champResultat;
    private TableView<Resultat> tableResultats; 
    private Label messageAction;
    private ControleurAjoutResultat controleur;

    public VueAjoutResultat() {
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));


        controleur = new ControleurAjoutResultat(this);


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

    
        Image image = new Image("file:img/valider.png");

        ImageView imageValider = new ImageView(image);


        imageValider.setFitHeight(16);
        imageValider.setFitWidth(16);


        boutonAjouter.setGraphic(imageValider);


        Tooltip tooltip = new Tooltip("Ajouter un nouveau résultat !");
        boutonAjouter.setTooltip(tooltip);
        

        boutonAjouter.setOnAction(e -> controleur.ajouterResultatManuel());

        HBox champsBox = new HBox(10);
        champsBox.getChildren().addAll(comboEpreuve, champPays, champNom, champPrenom, champResultat, boutonAjouter);
        champsBox.setAlignment(Pos.CENTER);

        topBox.getChildren().add(champsBox);
        root.setTop(topBox);

        // Partie centrale : tableau des résultats
        tableResultats = new TableView<>();
        tableResultats.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Resultat, String> colonnePays = new TableColumn<>("Pays");
        colonnePays.setCellValueFactory(new PropertyValueFactory<>("pays"));

        TableColumn<Resultat, String> colonneNom = new TableColumn<>("Nom");
        colonneNom.setCellValueFactory(new PropertyValueFactory<>("nom"));

        TableColumn<Resultat, String> colonnePrenom = new TableColumn<>("Prénom");
        colonnePrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));

        TableColumn<Resultat, String> colonneResultat = new TableColumn<>("Résultat");
        colonneResultat.setCellValueFactory(new PropertyValueFactory<>("resultat"));

        tableResultats.getColumns().addAll(colonnePays, colonneNom, colonnePrenom, colonneResultat);

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
        this.getChildren().add(root);
    }

    public ComboBox<String> getComboEpreuve() {
        return comboEpreuve;
    }

    public TextField getChampPays() {
        return champPays;
    }

    public TextField getChampNom() {
        return champNom;
    }

    public TextField getChampPrenom() {
        return champPrenom;
    }

    public TextField getChampResultat() {
        return champResultat;
    }

    public TableView<Resultat> getTableResultats() {
        return tableResultats;
    }

    public Label getMessageAction() {
        return messageAction;
    }

}

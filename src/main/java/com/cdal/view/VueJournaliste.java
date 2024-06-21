package main.java.com.cdal.view;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import main.java.com.cdal.controler.*;
import main.java.com.cdal.model.*;
import main.java.com.cdal.model.exception.MedailleInexistanteException;

public class VueJournaliste extends VBox {

    private JeuxOlympiques modeleJO;

    private AppPrincipale vueJO;

    private Text jeuxOlympiques;

    private BorderPane panelCentral;

    private List<Sport> listeSport;

    private List<Epreuve> listeEpreuve;

    private TableView<Classement> tableMedailles;

    private ObservableList<Pays> paysData;

    private Button recherche;

    private ComboBox<String> comboBox;

    public VueJournaliste(JeuxOlympiques modeleJO, AppPrincipale vueJO) {
        this.modeleJO = modeleJO;
        this.vueJO = vueJO;
        this.tableMedailles = new TableView<Classement>();

        // ComboBox
        List<String> classement = Arrays.asList("classement par défaut", "classement par épreuves", "listes des JO");
        this.comboBox = new ComboBox<String>(FXCollections.observableArrayList(classement));
        this.comboBox.setPromptText("sélection classement");

        // Bouton Recherche
        this.recherche = new Button("Rechercher");
        this.recherche.setOnAction(new ControleurComboBox(this.modeleJO, this.vueJO, this.comboBox.getValue()));

        // Menu déroulant
        this.recherche = new Button("Rechercher");
        this.recherche.setOnAction(new ControleurComboBox(this.modeleJO, this.vueJO, this.comboBox.getValue()));

        this.panelCentral = new BorderPane();
        this.jeuxOlympiques = new Text("Jeux Olympiques Tokyo 2020");

        BorderPane centreAccueil = new BorderPane();
        HBox hBox = new HBox();

        hBox.getChildren().addAll(this.comboBox, this.recherche);
        hBox.setMargin(this.recherche, new Insets(0, 0, 0, 1));
        centreAccueil.setLeft(hBox);
        centreAccueil.setMargin(hBox, new Insets(10, 0, 0, 20));

        this.tableMedailles.setPrefWidth(1000);
        this.tableMedailles.setPrefHeight(500);

        ObservableList<Classement> listePays = this.tableMedailles.getItems();
        Classement cl1 = new Classement(1, "Etats-Unis", 60, 30, 10, 100);
        Classement cl2 = new Classement(2, "Chine", 40, 30, 10, 80);
        Classement cl3 = new Classement(3, "Japon", 20, 30, 10, 60);
        ArrayList<Pays> listeP = new ArrayList<Pays>(this.modeleJO.getLesPays());
        Collections.sort(listeP, new Comparator<Pays>() {
            @Override
            public int compare(Pays p1, Pays p2) {
                return p2.getTotalNbMedailles() - p1.getTotalNbMedailles();
            }

        });
        int i = 1;
        for (Pays p : listeP) {
            try {
                listePays.add(
                        new Classement(i, p.getNom(), p.getNbMedaillesCouleur("Or"), p.getNbMedaillesCouleur("Argent"),
                                p.getNbMedaillesCouleur("Bronze"), p.getTotalNbMedailles()));
                i++;
            } catch (MedailleInexistanteException e) {
                e.printStackTrace();
            }
        }
        this.tableMedailles.setItems(listePays);

        // Modifier avec base de données
        TableColumn<Classement, Integer> c1 = new TableColumn<Classement, Integer>("Position");
        c1.setCellValueFactory(new PropertyValueFactory<>("position"));
        c1.setPrefWidth(100);
        TableColumn<Classement, String> c2 = new TableColumn<Classement, String>("Pays");
        c2.setCellValueFactory(new PropertyValueFactory<>("nom"));
        c2.setPrefWidth(200);
        TableColumn<Classement, Integer> c3 = new TableColumn<Classement, Integer>("Or");
        c3.setCellValueFactory(new PropertyValueFactory<>("or"));
        // c3.setStyle("-fx-background-color: #fde88e");
        c3.setPrefWidth(100);
        TableColumn<Classement, Integer> c4 = new TableColumn<Classement, Integer>("Argent");
        c4.setCellValueFactory(new PropertyValueFactory<>("argent"));
        // c4.setStyle("-fx-background-color: #cfd8df");
        c4.setPrefWidth(100);
        TableColumn<Classement, Integer> c5 = new TableColumn<Classement, Integer>("Bronze");
        c5.setCellValueFactory(new PropertyValueFactory<>("bronze"));
        // c5.setStyle("-fx-background-color: #dcaf85");
        c5.setPrefWidth(100);
        TableColumn<Classement, Integer> c6 = new TableColumn<Classement, Integer>("Total");
        c6.setCellValueFactory(new PropertyValueFactory<>("total"));
        c6.setPrefWidth(150);

        this.tableMedailles.getColumns().setAll(c1, c2, c3, c4, c5, c6);
        centreAccueil.setMargin(this.tableMedailles, new Insets(80, 50, 0, 0));
        centreAccueil.setCenter(this.tableMedailles);
        this.getChildren().add(centreAccueil);

    }
}

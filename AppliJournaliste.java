
import javafx.collections.ObservableList;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.geometry.Pos;

import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.util.ArrayList;



public class AppliJournaliste extends Application {

    private JeuxOlympiques modeleJO;

    private Text jeuxOlympiques;

    private Button btnParametres;

    private Button btnDeco;

    private Button btnRechercher;

    private BorderPane panelCentral;

    private List<Sport> listeSport;

    private List<Epreuve> listeEpreuve;

    private TextField barreRecherche;

    private ImageView utilisateur;

    private TableView<Classement> tableMedailles;

    private ObservableList<Pays> paysData;

    private Button recherche;

    private ComboBox<String> comboBox;


    @Override
    public void init() {
        this.barreRecherche = new TextField();
        this.tableMedailles = new TableView<Classement>();
        //Bouton Paramètres
        ImageView imgP = new ImageView(new Image("file:./img/parametres.png"));
        imgP.setFitWidth(40);
        imgP.setFitHeight(40);
        this.btnParametres = new Button("", imgP);
        this.btnParametres.setOnAction(new ControleurParamètres(this));
        //Bouton Déconnexion
        ImageView imgD = new ImageView(new Image("file:./img/deconnexion.png"));
        imgD.setFitWidth(40);
        imgD.setFitHeight(40);
        this.btnDeco = new Button("", imgD);

        //Bouton Rechercher
        this.btnRechercher = new Button("Rechercher");
        this.btnRechercher.setOnAction(new ControleurRechercher(this, this.barreRecherche.getText()));

        //ComboBox
        List<String> classement = Arrays.asList("classement par défaut", "classement par épreuves", "listes des JO");
        this.comboBox = new ComboBox<String>(FXCollections.observableArrayList(classement));
        this.comboBox.setPromptText("sélection classement");

        //Bouton Recherche
        this.recherche = new Button("Rechercher");
        this.recherche.setOnAction(new ControleurComboBox(this.modeleJO, this, this.comboBox.getValue()));
        
        this.panelCentral = new BorderPane();
        this.jeuxOlympiques = new Text("Jeux Olympiques Tokyo 2020");

        this.utilisateur = new ImageView(new Image("file:./img/user.png"));
        this.utilisateur.setFitWidth(100);
        this.utilisateur.setFitHeight(100);

        //Modèle Jeux Olympiques
        this.modeleJO = new JeuxOlympiques();
        try {
            modeleJO.chargerDonneeCSV("/home/iut45/Etudiants/o22304996/SAE/Java -IHM/src/SAE_JAVA_JO/donnees.csv");
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement des données");
        }

        
    }
            
        

    private Scene laScene(){
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.header());
        fenetre.setCenter(this.panelCentral);
        return new Scene(fenetre, 1000, 800);
        
    }


    public Pane header() {
        BorderPane banniere = new BorderPane();
        this.barreRecherche.setPromptText("Rechercher une information");
        this.barreRecherche.setPrefWidth(300);
        this.barreRecherche.setPrefHeight(20);

        HBox hbLeft = new HBox();
        hbLeft.getChildren().addAll(this.utilisateur, this.barreRecherche, this.btnRechercher);
        hbLeft.setMargin(this.barreRecherche, new Insets(35,1,0,20));
        hbLeft.setMargin(this.btnRechercher, new Insets(35,0,0,0));
        banniere.setLeft(hbLeft);
        
        //Right
        HBox hbRight = new HBox();
        hbRight.getChildren().addAll(this.btnParametres, this.btnDeco);
        hbRight.setMargin(this.btnParametres, new Insets(20,0,0,0));
        hbRight.setMargin(this.btnDeco, new Insets(20,20,0,10));
        banniere.setRight(hbRight);
        banniere.setStyle("-fx-background-color: #444444");
        return banniere;

    }


    public Pane fenetreClassementParMedailles() {
        BorderPane centreAccueil = new BorderPane();
        HBox hBox = new HBox();
        
        hBox.getChildren().addAll(this.comboBox, this.recherche);
        hBox.setMargin(this.recherche, new Insets(0,0,0,1));
        centreAccueil.setLeft(hBox);
        centreAccueil.setMargin(hBox, new Insets(10, 0, 0, 20));
        
        this.tableMedailles.setPrefWidth(100);
        this.tableMedailles.setPrefHeight(100);

        ObservableList<Classement> listePays = this.tableMedailles.getItems();
        Classement cl1 = new Classement(1, "Etats-Unis", 60, 30, 10, 100);
        Classement cl2 = new Classement(2, "Chine", 40, 30, 10, 80);
        Classement cl3 = new Classement(3, "Japon", 20, 30, 10, 60);
        listePays.addAll(cl1,cl2,cl3);
        this.tableMedailles.setItems(listePays);


        // Modifier avec base de données
        TableColumn<Classement,Integer> c1 = new TableColumn<Classement,Integer>("Position");
        c1.setCellValueFactory(new PropertyValueFactory<>("position"));
        c1.setPrefWidth(100);
        TableColumn<Classement,String> c2 = new TableColumn<Classement,String>("Pays");
        c2.setCellValueFactory(new PropertyValueFactory<>("nom"));
        c2.setPrefWidth(200);
        TableColumn<Classement,Integer> c3 = new TableColumn<Classement,Integer>("Or");
        c3.setCellValueFactory(new PropertyValueFactory<>("or"));
        //c3.setStyle("-fx-background-color: #fde88e");
        c3.setPrefWidth(100);
        TableColumn<Classement,Integer> c4 = new TableColumn<Classement,Integer>("Argent");
        c4.setCellValueFactory(new PropertyValueFactory<>("argent"));
        //c4.setStyle("-fx-background-color: #cfd8df");
        c4.setPrefWidth(100);
        TableColumn<Classement,Integer> c5 = new TableColumn<Classement,Integer>("Bronze");
        c5.setCellValueFactory(new PropertyValueFactory<>("bronze"));
        //c5.setStyle("-fx-background-color: #dcaf85");
        c5.setPrefWidth(100);
        TableColumn<Classement,Integer> c6 = new TableColumn<Classement,Integer>("Total");
        c6.setCellValueFactory(new PropertyValueFactory<>("total"));
        c6.setPrefWidth(150);


        this.tableMedailles.getColumns().setAll(c1,c2,c3,c4,c5,c6);
        centreAccueil.setMargin(this.tableMedailles, new Insets(80, 50, 0, 0));
        centreAccueil.setCenter(this.tableMedailles);
        return centreAccueil;
    }



    public void modeAccueilJournaliste() {
        //this.panelCentral.setCenter(fenetreClassementParEpreuve());
        this.panelCentral.setCenter(this.fenetreClassementParMedailles());
    }




    /**
     * créer le graphe de scène et lance le jeu
     * @param stage la fenêtre principale
     */
    @Override
    public void start(Stage stage) {
        stage.setScene(this.laScene());
        stage.setTitle("IUTEAM'S - La plateforme des résultats JO ");
        this.modeAccueilJournaliste();
        stage.show();
    }

    /**
     * Programme principal
     * @param args inutilisé
     */
    public static void main(String[] args) {
        launch(args);
    }  
}
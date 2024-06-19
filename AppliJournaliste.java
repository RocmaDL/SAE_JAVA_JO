
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

    private List<Pays> listePays;

    private TextField barreRecherche;

    private ImageView utilisateur;

    private TableView<JeuxOlympiques> tableMedailles;

    private ObservableList<Pays> paysData;


    @Override
    public void init() {
        this.barreRecherche = new TextField();
        this.tableMedailles = new TableView<JeuxOlympiques>();
        //Bouton Paramètres
        ImageView imgP = new ImageView(new Image("file:./img/parametres.png"));
        imgP.setFitWidth(40);
        imgP.setFitHeight(40);
        this.btnParametres = new Button("", imgP);
        //Bouton Déconnexion
        ImageView imgD = new ImageView(new Image("file:./img/deconnexion.png"));
        imgD.setFitWidth(40);
        imgD.setFitHeight(40);
        this.btnDeco = new Button("", imgD);

        //Bouton Rechercher
        this.btnRechercher = new Button("Rechercher");
        
        this.panelCentral = new BorderPane();
        this.jeuxOlympiques = new Text("Jeux Olympiques Tokyo 2020");

        this.utilisateur = new ImageView(new Image("file:./img/user.png"));
        this.utilisateur.setFitWidth(100);
        this.utilisateur.setFitHeight(100);

        //Modèle Jeux Olympiques
        this.modeleJO = new JeuxOlympiques();
        try {
            modeleJO.chargerDonneeCSV("donnees.csv");
        } catch (Exception e) {
            System.out.println("Erreur lors du chargement des données");
        }

        this.paysData = FXCollections.observableArrayList();
        List<Pays> listePays = new ArrayList<>(this.modeleJO.getLesPays());
        for (Pays pays : listePays) {
            this.paysData.add(pays);
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

    public Pane fenetreClassementParEpreuve() {
        TilePane center = new TilePane();

        ToggleGroup genre = new ToggleGroup();
        RadioButton rd1 =  new RadioButton("Féminin");
        RadioButton rd2 =  new RadioButton("Masculin");
        rd1.setToggleGroup(genre);
        rd2.setToggleGroup(genre);

        ToggleGroup categorie = new ToggleGroup();
        RadioButton rd3 =  new RadioButton("Collectif");
        RadioButton rd4 =  new RadioButton("Individuel");
        rd3.setToggleGroup(categorie);
        rd4.setToggleGroup(categorie);

        
        center.getChildren().addAll(rd1,rd2,rd3,rd4);

        return center;
    }


    public Pane fenetreClassementParMedailles() {
        BorderPane centreAccueil = new BorderPane();
        List<String> classement = Arrays.asList("classement par épreuves", "listes des JO");
        ComboBox<String> pays = new ComboBox<String>(FXCollections.observableArrayList(classement));
        pays.setPromptText("classement par défaut");
        centreAccueil.setLeft(pays);
        centreAccueil.setMargin(pays, new Insets(10, 0, 0, 20));
        this.tableMedailles.setPrefWidth(550);
        this.tableMedailles.setPrefHeight(500);
        TableColumn<JeuxOlympiques,Integer> c1 = new TableColumn<JeuxOlympiques,Integer>();
        c1.setCellValueFactory(new PropertyValueFactory<>(""));
        tableMedailles.setItems(FXCollections.observableArrayList(this.modeleJO));
        TableColumn<JeuxOlympiques,String> c2 = new TableColumn<JeuxOlympiques,String>("Pays");
        c2.setCellValueFactory(new PropertyValueFactory<>("nom"));
        TableColumn<JeuxOlympiques,Integer> c3 = new TableColumn<JeuxOlympiques,Integer>("Or");
        c3.setCellValueFactory(new PropertyValueFactory<>("or"));
        TableColumn<JeuxOlympiques,Integer> c4 = new TableColumn<JeuxOlympiques,Integer>("Argent");
        c4.setCellValueFactory(new PropertyValueFactory<>("argent"));
        TableColumn<JeuxOlympiques,Integer> c5 = new TableColumn<JeuxOlympiques,Integer>("Bronze");
        c5.setCellValueFactory(new PropertyValueFactory<>("bronze"));
        TableColumn<JeuxOlympiques,Integer> c6 = new TableColumn<JeuxOlympiques,Integer>("Total");
        c6.setCellValueFactory(new PropertyValueFactory<>("total"));


        this.tableMedailles.getColumns().setAll(c1,c2,c3,c4,c5,c6);
        centreAccueil.setMargin(this.tableMedailles, new Insets(50, 0, 0, 10));
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
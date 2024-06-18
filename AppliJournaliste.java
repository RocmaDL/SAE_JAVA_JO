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

import java.util.List;
import java.util.Arrays;
import java.io.File;
import java.util.ArrayList;


public class AppliJournaliste extends Application {

    private Text jeuxOlympiques;

    private Button btnParametres;

    private Button btnDeco;

    private BorderPane panelCentral;

    private List<String> listeSport;

    private List<String> listeEpreuve;

    private TextField barreRecherche;



    @Override
    public void init() {
        this.barreRecherche = new TextField("rechercher information");
        // Bouton Paramètres
        ImageView imgP = new ImageView(new Image("file:../img/parametres.png"));
        imgP.setFitWidth(30);
        imgP.setFitHeight(30);
        this.btnParametres = new Button("", imgP);
        //Bouton Déconnexion
        ImageView imgD = new ImageView(new Image("file:../img/deconnexion.png"));
        imgD.setFitWidth(30);
        imgD.setFitHeight(30);
        this.btnParametres = new Button("", imgD);
        
        this.panelCentral = new BorderPane();
        this.jeuxOlympiques = new Text("Jeux Olympiques Tokyo 2020");

        ImageView imgU = new ImageView(new Image("file:../img/user.png"));
        imgU.setFitWidth(50);
        imgU.setFitHeight(50);


        this.listeSport = Arrays.asList("Natation", "Volley-ball", "Escrime", "Athlétisme", "Handball");
        this.listeEpreuve = Arrays.asList("100m brasse", "4x100m nage libre", "fleuret", "épée", "110m haies", "4x100m relais");


    }

    private Scene laScene(){
        BorderPane fenetre = new BorderPane();
        fenetre.setTop(this.header());
        fenetre.setCenter(this.panelCentral);
        return new Scene(fenetre, 800, 1000);
        
    }


    public Pane header() {
        BorderPane banniere = new BorderPane();
        HBox hbLeft = new HBox();

        hbLeft.getChildren().addAll(this.barreRecherche);
        HBox hbRight = new HBox();
        hbRight.getChildren().addAll(this.btnParametres, this.btnDeco);
        banniere.setRight(hbRight);
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

        ComboBox<String> sport = new ComboBox<String>(FXCollections.observableArrayList(this.listeSport));
        ComboBox<String> epreuve = new ComboBox<String>(FXCollections.observableArrayList(this.listeEpreuve));

        center.getChildren().addAll(rd1,rd2,rd3,rd4);

        return center;
    }



    public void modeAccueilJournaliste() {
        this.panelCentral.setCenter(this.jeuxOlympiques);
    }




    /**
     * créer le graphe de scène et lance le jeu
     * @param stage la fenêtre principale
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("IUTEAM'S - La plateforme des résultats JO ");
        stage.setScene(this.laScene());
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
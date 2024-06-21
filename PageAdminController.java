/**
 * Contrôleur PageAdminController associé au fichier FXML correspondant.
 * Ce contrôleur gère les interactions et initialise les éléments de l'interface graphique pour la page d'administration.
 */
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PageAdminController {
    @FXML
    private ComboBox<String> sportComboBox;

    @FXML
    private ComboBox<String> categorieComboBox;

    @FXML
    private ComboBox<String> paysComboBox;

    @FXML
    private ComboBox<String> genreComboBox;

    @FXML
    private TextField medailleOrTextField;

    @FXML
    private TextField medailleArgentTextField;

    @FXML
    private TextField medailleBronzeTextField;

    @FXML
    private ImageView settingsIcon;

    @FXML
    private ImageView logoutIcon;

    /**
     * Méthode d'initialisation appelée après le chargement du fichier FXML.
     * Initialise les icônes avec des images spécifiques.
     */
    @FXML
    public void initialize() {
        settingsIcon.setImage(new Image(getClass().getResourceAsStream("/images/reglage.png")));
        logoutIcon.setImage(new Image(getClass().getResourceAsStream("/images/exit.png")));
    }
}

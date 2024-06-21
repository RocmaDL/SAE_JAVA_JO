Voici la documentation ajoutée au-dessus du code :

```java
/**
 * Classe PageAcceuilController qui sert de contrôleur pour une interface graphique définie par un fichier FXML.
 * Gère les interactions avec les champs de texte pour l'ID et le mot de passe, ainsi que l'affichage d'une image.
 */
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PageAcceuilController {

    // Champ de texte pour l'ID, injecté par le fichier FXML
    @FXML
    private TextField idField;
    
    // Champ de texte pour le mot de passe, injecté par le fichier FXML
    @FXML
    private TextField mdpField;
    
    // Vue de l'image, injectée par le fichier FXML
    @FXML
    private ImageView imageView;

    /**
     * Méthode d'initialisation appelée automatiquement après le chargement du fichier FXML.
     * Charge et affiche l'image dans l'ImageView.
     */
    @FXML
    public void initialize() {
        Image image = new Image(getClass().getResourceAsStream("/images/imagespconnexion.png"));
        imageView.setImage(image);
    }
}
```Voici la documentation ajoutée au-dessus du code :

```java
/**
 * Classe PageAcceuilController qui sert de contrôleur pour une interface graphique définie par un fichier FXML.
 * Gère les interactions avec les champs de texte pour l'ID et le mot de passe, ainsi que l'affichage d'une image.
 */
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PageAcceuilController {

    // Champ de texte pour l'ID, injecté par le fichier FXML
    @FXML
    private TextField idField;
    
    // Champ de texte pour le mot de passe, injecté par le fichier FXML
    @FXML
    private TextField mdpField;
    
    // Vue de l'image, injectée par le fichier FXML
    @FXML
    private ImageView imageView;

    /**
     * Méthode d'initialisation appelée automatiquement après le chargement du fichier FXML.
     * Charge et affiche l'image dans l'ImageView.
     */
    @FXML
    public void initialize() {
        Image image = new Image(getClass().getResourceAsStream("/images/imagespconnexion.png"));
        imageView.setImage(image);
    }
}
```

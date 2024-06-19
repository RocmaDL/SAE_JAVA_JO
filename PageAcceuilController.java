import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PageAcceuilController {

    @FXML
    private TextField idField;
    
    @FXML
    private TextField mdpField;
    
    @FXML
    private ImageView imageView;

    @FXML
    public void initialize() {
        Image image = new Image(getClass().getResourceAsStream("/images/imagespconnexion.png"));
        imageView.setImage(image);
    }
}


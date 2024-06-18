package main.java.com.cdal;

import java.io.File;
import java.net.URL;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.fxml.FXMLLoader;

public class AppTest extends Application {
    Scene mainScene;
    BorderPane root;
    FXMLLoader loader;

    @Override
    public void init() {

    }

    @Override
    public void start(Stage stage) throws Exception {
        URL url = new File("templates/test.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        BorderPane root = loader.load();
        Scene mainScene = new Scene(root);

        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

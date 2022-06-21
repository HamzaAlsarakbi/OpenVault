package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import main.controllers.main.MainController;


import java.io.IOException;
import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args)  {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
//        LoginController loginController = new LoginController(stage);
        try {
            startMain(stage);
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("Error while loading main view");
        }

    }
    public void startMain(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/main/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setMinWidth(800);
        stage.setMinHeight(750);
        stage.getIcons().add(new Image(Objects.requireNonNull(MainController.class.getResourceAsStream("/icons/openvault/openvault.png"))));
        stage.setTitle("Dashboard - OpenVault");
        stage.setScene(scene);
        stage.show();
    }
}
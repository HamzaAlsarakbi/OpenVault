package main.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController extends Application {
    private Scene scene;
    public LoginController(Stage stage) {
        start(stage);
    }

    @Override
    public void start(Stage stage) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/login-view.fxml"));
        try {
            scene = new Scene(fxmlLoader.load());
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("ERROR while loading login FXML file.");
        }
        stage.setTitle("Login - OpenVault");
        stage.setScene(scene);
        stage.show();
    }
}

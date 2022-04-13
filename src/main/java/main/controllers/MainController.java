package main.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController extends Application {
    private Scene scene;
    public MainController(Stage stage) { start(stage); }

    @Override
    public void start(Stage stage) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/main/main-view.fxml"));
        try {
            scene = new Scene(fxmlLoader.load());
        } catch(IOException e) {
            e.printStackTrace();
            System.out.println("ERROR while loading login FXML file.");
        }

        stage.setMinWidth(500);
        stage.setMinHeight(500);
        stage.setTitle("Dashboard");
        stage.setScene(scene);
        stage.show();

    }
}

package main;

import javafx.application.Application;
import javafx.stage.Stage;
import main.controllers.LoginController;
import main.controllers.MainController;


import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args)  {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
//        LoginController loginController = new LoginController(stage);
        MainController mainController = new MainController(stage);

    }
}
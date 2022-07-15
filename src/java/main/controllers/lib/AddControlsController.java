package main.controllers.lib;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class AddControlsController implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML
    private Label label;
    @FXML
    private Button button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }


    public Label getLabel() { return label; }
    public void setLabel(String text) { setLabel(text); }
    public Button getButton() { return button; }

}

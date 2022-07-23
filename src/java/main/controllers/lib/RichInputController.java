package main.controllers.lib;

import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class RichInputController implements Initializable {
    @FXML
    private AnchorPane root;
    @FXML
    private Label label;
    @FXML
    private TextField textField;

    @FXML
    private ComboBox personalDropdown;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        textField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if(newVal) {
                if(textField.getLength() == 0) root.getStyleClass().add("focus");
            } else {
                if(textField.getLength() == 0) root.getStyleClass().remove("focus");

            }
        });
    }

    public void setVisible(boolean b) { root.setVisible(b); }
    public void setLabel(String text) { label.setText(text); }
    public TextField getTextField() { return textField; }

}

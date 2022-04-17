package main.controllers;


import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    @FXML
    private HBox dashboardButton, loginsButton, pinsButton, authenticationCodesButton,
            securityQuestionsButton, wifiButton, keysButton, creditCardsButton, notesButton, settingsButton,
            lockButton, aboutButton;
    @FXML
    private AnchorPane searchBox;

    private HBox[] getSidePanelButtons() {
        return new HBox[]{ dashboardButton, loginsButton, pinsButton, authenticationCodesButton,
                securityQuestionsButton, wifiButton, keysButton, creditCardsButton, notesButton, settingsButton,
                lockButton, aboutButton };
    }

    private void resetButtons() {
        for(HBox button : getSidePanelButtons()) { button.getStyleClass().remove("active"); }
    }
    private void setActive(HBox button) {
        resetButtons();
        button.getStyleClass().add("active");
    }

    // Handlers
    public void dashboardHandler(MouseEvent mouseEvent) {
        setActive(dashboardButton);
    }
    public void loginsHandler(MouseEvent mouseEvent) {
        setActive(loginsButton);
    }
    public void pinsHandler(MouseEvent mouseEvent) {
        setActive(pinsButton);
    }
    public void authenticationCodesHandler(MouseEvent mouseEvent) {
        setActive(authenticationCodesButton);
    }
    public void securityQuestionsHandler(MouseEvent mouseEvent) {
        setActive(securityQuestionsButton);
    }
    public void wifiHandler(MouseEvent mouseEvent) {
        setActive(wifiButton);
    }
    public void keysHandler(MouseEvent mouseEvent) {
        setActive(keysButton);
    }
    public void creditCardsHandler(MouseEvent mouseEvent) {
        setActive(creditCardsButton);
    }
    public void notesHandler(MouseEvent mouseEvent) {
        setActive(notesButton);
    }
    public void settingsHandler(MouseEvent mouseEvent) {
        setActive(settingsButton);
    }
    public void lockHandler(MouseEvent mouseEvent) {
        setActive(lockButton);
    }
    public void aboutHandler(MouseEvent mouseEvent) {
        setActive(aboutButton);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}

package main.controllers.main;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import main.controllers.lib.RichInputController;
import main.controllers.main.credential_menu.CredentialMenu;
import main.controllers.main.credential_menu.menus.LoginsController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class MainController implements Initializable {
    @FXML
    private HBox dashboardButton, loginsButton, pinsButton, authenticationCodesButton,
            securityQuestionsButton, wifiButton, keysButton, creditCardsButton, notesButton, settingsButton,
            lockButton, aboutButton;
    @FXML
    private AnchorPane searchBox;
    @FXML
    private RichInputController searchBoxController;
    @FXML
    private AnchorPane menuRootAnchor;

    private HBox[] getSidePanelButtons() {
        return new HBox[]{ dashboardButton, loginsButton, pinsButton, authenticationCodesButton,
                securityQuestionsButton, wifiButton, keysButton, creditCardsButton, notesButton, settingsButton,
                lockButton, aboutButton };
    }
    private CredentialMenu activeController;
    private AnchorPane activePane;

    /**
     * Removes active property on all side-panel buttons.
     */
    private void resetButtons() {
        for(HBox button : getSidePanelButtons()) { button.getStyleClass().remove("active"); }
    }

    /**
     * Makes a side-panel button active
     * @param button the button to be set to active
     */
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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/main/credential_menu/logins.fxml"));
            activePane = fxmlLoader.load();
            activeController = fxmlLoader.getController();
            menuRootAnchor.getChildren().add(activePane);
        } catch(IOException e) {
            e.printStackTrace();
        }

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
        searchBoxController.setLabel("Search");
        loginsHandler(null);
    }
}

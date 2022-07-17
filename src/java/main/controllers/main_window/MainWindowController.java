package main.controllers.main_window;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import main.controllers.lib.RichInputController;
import main.controllers.main_window.credential_menu.CredentialMenu;
import main.controllers.main_window.credential_menu.menus.CredentialDetailsController;
import main.controllers.main_window.credential_menu.menus.DetailsController;
import main.controllers.main_window.credential_menu.menus.logins.LoginsController;
import main.model.data.credential.Credential;
import main.model.data.credential.CredentialInvalidException;
import main.model.data.credential.identification.login.Login;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class MainWindowController implements Initializable {
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
    private AnchorPane activePane, detailsPane;
    private DetailsController detailsController;
    private CredentialDetailsController credentialDetailsController;

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
        // Check if the menu isn't already active.
        setActive(loginsButton);
        if(!(activeController instanceof LoginsController)) {
            clearActiveMenu();
            // Load the Logins FXML file.
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/main_window/credential_menus/logins/logins.fxml"));
                activePane = fxmlLoader.load();
                activeController = fxmlLoader.getController();
                activeController.setParentController(this);
                menuRootAnchor.getChildren().add(activePane);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        // Temp
        try {
            activeController.openDetailsPane(new Login("Personal", "Gmaasdasdil", "hamzaasd@gmail.com", "hamza.asdGmail.Com"));
        } catch (CredentialInvalidException e) {
            e.printStackTrace();
        }
    }

    /**
     * Clears the root AnchorPane containing the FXML file (Logins, Authentication codes, etc.) as well as the
     * controller and active pane variables.
     */
    private void clearActiveMenu() {
        activeController = null;
        activePane = null;
        detailsController = null;
        detailsPane = null;
        menuRootAnchor.getChildren().clear();
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

    public void openDetailsPane(Credential credential, FXMLLoader loginDetailsFXML) {
        activePane.setVisible(false);
        FXMLLoader detailsFXML = new FXMLLoader(getClass().getResource("/view/main_window/credential_menus/details.fxml"));
        try {
            detailsPane = detailsFXML.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.detailsController = detailsFXML.getController();
        menuRootAnchor.getChildren().add(detailsPane);

        // setup details pane
        detailsController.addCredentialDetailsPane(loginDetailsFXML);
        detailsController.addCredential(credential);
    }
}

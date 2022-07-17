package main.controllers.main_window.credential_menu.menus;

import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Pair;
import main.model.data.credential.Credential;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class DetailsController implements Initializable {
    @FXML
    private AnchorPane root, detailsRootPane;
    private AnchorPane credentialDetailsPane;
    private FXMLLoader detailsFXML;
    private CredentialDetailsController credentialDetailsController;
    private boolean initializedPane;
    private boolean initializedCredential;
    private Credential credential;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializedPane = false;
        initializedCredential = false;
    }

    /**
     * Initializes the credential details pane. This method only runs once.
     * @param detailsFXML an FXMLLoader object representing the credential details pane
     */
    public void addCredentialDetailsPane(FXMLLoader detailsFXML) {
        if(!initializedPane) {
            // Load FXML file.
            this.detailsFXML = detailsFXML;
            try {
                credentialDetailsPane = this.detailsFXML.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            // Set controller
            credentialDetailsController = this.detailsFXML.getController();
            // Add pane
            detailsRootPane.getChildren().add(credentialDetailsPane);
            // Lock method
            initializedPane = true;
        }
    }

    public void addCredential(Credential credential) {
        if(!initializedCredential) {
            this.credential = credential;

            updateLogList();
            initializedCredential = true;
        }
    }

    private void updateLogList() {
        ArrayList<Pair<Date, String>> list = credential.getChangeLog();


    }
}

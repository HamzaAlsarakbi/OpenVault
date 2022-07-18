package main.controllers.main_window.credential_menu.menus;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import main.controllers.lib.list.CList;
import main.model.data.credential.Credential;
import main.model.data.log.LogEntry;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DetailsController implements Initializable {
    @FXML
    private AnchorPane root, detailsRootPane;
    @FXML
    private VBox historyVBox;
    @FXML
    private ImageView favIcon;
    private AnchorPane credentialDetailsPane;
    private FXMLLoader detailsFXML;
    private CredentialDetailsController credentialDetailsController;
    private boolean initializedPane;
    private boolean initializedCredential;
    private Credential credential;
    private CList logList;

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

            // Initialize fav icon
            if(credential.getFavourite()) setFavourite(true);


            updateLogList();
            initializedCredential = true;
        }
    }

    private void updateLogList() {
        ArrayList<LogEntry> list = credential.getChangeLog();

        // Make a log list if there isn't one
        if(logList == null) {
            logList = new CList(list);
            historyVBox.getChildren().add(logList);
            VBox.setVgrow(logList, Priority.ALWAYS);
        }

    }

    public void favToggleHandler(MouseEvent e) {
        credential.toggleFavourite();
        setFavourite(credential.getFavourite());
    }

    private void setFavourite(boolean favourite) {
        String fileName = favourite ? "filled" : "empty";
        String path = String.format("/icons/common/star/star-%s.png", fileName);
        favIcon.setImage(new Image(getClass().getResourceAsStream(path), 25, 25, true, true));
    }
}

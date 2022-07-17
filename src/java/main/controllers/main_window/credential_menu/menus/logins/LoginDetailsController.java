package main.controllers.main_window.credential_menu.menus.logins;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import main.controllers.main_window.credential_menu.menus.CredentialDetailsController;
import main.controllers.main_window.credential_menu.menus.DetailsController;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginDetailsController extends CredentialDetailsController implements Initializable {

    @FXML
    private Label typeLabel, serviceLabel, aliasLabel, passwordLabel, typeCopy, serviceCopy, aliasCopy, passwordCopy;
    private AnchorPane root;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    // Set fields
    public void setTypeField(String text) { typeLabel.setText(text); }
    public void setServiceField(String text) { serviceLabel.setText(text); }
    public void setAliasField(String text) { aliasLabel.setText(text); }
    public void setPasswordField(String text) { passwordLabel.setText(text); }


    // Copy handlers
    // Proof of concept, will be copying later!
    public void copyType(MouseEvent e) { System.out.println("Copying Type!"); }
    public void copyService(MouseEvent e) { System.out.println("Copying Service!"); }
    public void copyAlias(MouseEvent e) { System.out.println("Copying Alias!"); }
    public void copyPassword(MouseEvent e) { System.out.println("Copying Password!"); }



    private void copyString(String text) {}



}

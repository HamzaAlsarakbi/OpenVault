package main.controllers.main_window.credential_menu.menus.logins;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import main.controllers.lib.PasswordFieldSkin;
import main.controllers.main_window.credential_menu.menus.CredentialDetailsController;
import main.controllers.main_window.credential_menu.menus.DetailsController;
import main.model.data.credential.Credential;
import main.model.data.credential.identification.login.Login;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginDetailsController extends CredentialDetailsController implements Initializable {

    @FXML
    private Label typeCopy, serviceCopy, aliasCopy, passwordCopy;
    @FXML
    private TextField typeField, serviceField, aliasField;
    @FXML
    private HBox passwordHBox;
    private PasswordFieldSkin passwordField;
    private AnchorPane root;
    private Login login;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        passwordField = new PasswordFieldSkin("");
        passwordHBox.getChildren().add(0, passwordField);
    }

    // Set fields
    public void setTypeField(String text) { typeField.setText(text); }
    public void setServiceField(String text) { serviceField.setText(text); }
    public void setAliasField(String text) { aliasField.setText(text); }
    public void setPasswordField(String text) { passwordField.setText(text); }
    public void setFields(Credential newLogin) {

        this.login = (Login) newLogin;
        setTypeField(login.getType());
        setServiceField(login.getService());
        setAliasField(login.getAlias());
        setPasswordField(login.getPassword());
    }
    public void hidePassword() {


    }


    // Copy handlers
    // Proof of concept, will be copying later!
    public void copyType(MouseEvent e) { System.out.println("Copying Type!"); }
    public void copyService(MouseEvent e) { System.out.println("Copying Service!"); }
    public void copyAlias(MouseEvent e) { System.out.println("Copying Alias!"); }
    public void copyPassword(MouseEvent e) { System.out.println("Copying Password!"); }



    private void copyString(String text) {}



}

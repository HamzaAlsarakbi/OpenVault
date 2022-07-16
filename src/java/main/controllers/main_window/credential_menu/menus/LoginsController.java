package main.controllers.main_window.credential_menu.menus;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Pair;
import main.controllers.lib.RichInputController;
import main.controllers.lib.table.CTable;
import main.controllers.main_window.credential_menu.CredentialMenu;
import main.model.data.credential.CredentialInvalidException;
import main.model.data.credential.identification.IdentificationType;
import main.model.data.credential.identification.login.Login;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginsController extends CredentialMenu implements Initializable {
    @FXML
    private AnchorPane root, serviceBox, aliasBox, passwordBox;
    @FXML
    private RichInputController serviceBoxController, aliasBoxController, passwordBoxController;
    @FXML
    private Button addButton;
    @FXML
    private Label errorLabel;
    @FXML
    private ComboBox<String> typeDropdown, columnDropDown;
    @FXML
    private VBox rootVBox;

    private CTable dataTable;

    private TextField serviceField, aliasField, passwordField;
    private TextField[] textFields;

    private final String[] STRING_FIELDS = { "Service", "Username/Email", "Password" };

    public LoginsController() {
        super();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Labels
        serviceBoxController.setLabel("Service");
        aliasBoxController.setLabel("Username/Email");
        passwordBoxController.setLabel("Password");

        // TextFields
        serviceField = serviceBoxController.getTextField();
        aliasField = aliasBoxController.getTextField();
        passwordField = passwordBoxController.getTextField();
        textFields = new TextField[]{ serviceField, aliasField, passwordField };

        // Table
        buildTable();




        // Update
        update(true);
    }

    private void buildTable() {
        dataTable = new CTable<>(new String[] { "Type", "Service", "Email/Username", "Password" });


        rootVBox.getChildren().add(dataTable);

        try {
            // Temporary
            dataTable.addRow(new Login("Personal", "Gmail", "haasdmza@gmail.com", "hamza.Gmaa1il.Com"));
            dataTable.addRow(new Login("Personal", "asd", "hamza@gmasdail.com", "hamzasda.Gmail.Com"));
            dataTable.addRow(new Login("Personal", "Gmasdaail", "hamza@gmail.com", "hamza.Gmail.Com"));
            dataTable.addRow(new Login("Personal", "Gmaasdasdil", "hamzaasd@gmail.com", "hamza.asdGmail.Com"));
        } catch (CredentialInvalidException e) {
            System.out.println("Exception occured!");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    /**
     * Updates all components
     * @param errorPass true if the error label should not show up
     */
    private void update(boolean errorPass) {
        updateTypeDropdown();
        if(!errorPass) updateButton();
    }
    public void update() { update(false); }



    private void updateTypeDropdown() {
        typeDropdown.setItems(FXCollections.observableArrayList(IdentificationType.getIdentificationTypes()));
    }

    /**
     * <p>Updates button.</p>
     * <p>Disables add button if one of the text fields is empty.</p>
     */
    public void updateButton() {
        Pair<Boolean, String> emptyField = areFieldsEmpty();
        if(emptyField.getKey()) {
            errorLabel.setText(String.format("%s field is empty.", emptyField.getValue()));
        } else {
            errorLabel.setText("");
        }
    }

    public void addHandler(MouseEvent mouseEvent) {
        errorLabel.setText("");
        try {
            dataTable.addRow(new Login(typeDropdown.getValue(), serviceField.getText(), aliasField.getText(), passwordField.getText()));
            clearFields();
        } catch(CredentialInvalidException e) {
            errorLabel.setText(String.format("%s is empty.", e.getMessage().split(" ")[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private Pair<Boolean, String> areFieldsEmpty() {
        for(int i = 0; i < textFields.length; i++) {
            if(textFields[i].getLength() == 0) return new Pair<>(true, STRING_FIELDS[i]);
        }
        return new Pair<>(false, "");
    }

    private void clearFields() {
        for(TextField field : textFields) {
            field.clear();
        }
    }
}

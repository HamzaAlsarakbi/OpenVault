package main.controllers.main.components;

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
import main.controllers.lib.table.CTableColumn;
import main.model.data.credential.CredentialInvalidException;
import main.model.data.credential.identification.IdentificationType;
import main.model.data.credential.identification.login.Login;

import java.net.URL;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class LoginsController implements Initializable {

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
        LinkedList<CTableColumn> list = new LinkedList<>(Arrays.asList(
                new CTableColumn("Type"), new CTableColumn("Service"),
                new CTableColumn("Alias"), new CTableColumn("Password")
        ));


        dataTable = new CTable<>(list);
        rootVBox.getChildren().add(dataTable);

//        try {
//            Login testLogin = new Login("Personal", "Gmail", "hamza@gmail.com", "hamza.Gmail.Com");
//            dataTable.addRow(testLogin);
//        } catch (CredentialInvalidException exception) {
//            System.out.println("Exception occured!");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


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

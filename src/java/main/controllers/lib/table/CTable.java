package main.controllers.lib.table;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import main.controllers.lib.table.CTableColumn;
import main.controllers.main_window.credential_menu.CredentialMenu;
import main.model.data.credential.Credential;
import main.model.data.credential.Credentials;

import java.util.ArrayList;
import java.util.LinkedList;

public class CTable<T extends Credential> extends AnchorPane {
    private HBox columnsList;


    // We don't know what type of data the column contains.
    private LinkedList<CTableColumn> columns;
    private Credentials<T> data;

    // The controller that uses this table (LoginsController, etc.)
    private CredentialMenu controller;

    /**
     * Constructs a Table object.
     * @param columnNames a String array of columns names
     * @param controller the controller that uses the table (this). Used for onClick events
     */
    public CTable(String[] columnNames, CredentialMenu controller) {
        buildColumns(columnNames);
        data = new Credentials<>();

        // UI
        // AnchorPane
        setMinWidth(100);
        setMinHeight(20);
        setMaxWidth(1000);

        columnsList = new HBox();
        // Set Constraints.
        setTopAnchor(columnsList, 0.0);
        setRightAnchor(columnsList, 0.0);
        setBottomAnchor(columnsList, 0.0);
        setLeftAnchor(columnsList, 0.0);
        getChildren().add(columnsList);
        columnsList.getChildren().addAll(columns);

        // set controller that uses this table
        this.controller = controller;
    }

    private void buildColumns(String[] columnNames) {
        this.columns = new LinkedList<>();
        for(String columnName : columnNames) {
            this.columns.add(new CTableColumn(columnName, this));
        }
    }


    /**
     * Adds a row to the table
     * @param row an object to add a row to
     */
    public void addRow(T row) throws Exception {
        ArrayList<String> rowData = row.getData();
        if(rowData != null) {
            if(rowData.size() == columns.size()) {
                // Add row data
                data.addCredential(row);
                for(int i = 0; i < columns.size(); i++) {
                    columns.get(i).addCell(new CTableCell(rowData.get(i), columns.get(i), this));
                }
            } else {
                throw new Exception(String.format("Invalid data provided. Expected %d. Provided %d", columns.size(), rowData.size()));
            }
        } else {
            throw new Exception("called addRow() on a credential with no valid data.");
        }

    }

    /**
     * Returns an array of the CTableCells that make up the row
     * @return
     */
    public ArrayList<CTableCell> getRowElement(CTableCell queryCell) {
        ArrayList<CTableCell> row = new ArrayList<>();
        int indexOfQueryCell = 0;
        // Find in which column queryCell is in
        for(CTableColumn col : columns) {
            if(col.getCellsList().indexOf(queryCell) != -1) {
                indexOfQueryCell = col.getCellsList().indexOf(queryCell);
            }
        }
        // Add the neighboring row cells into the arraylist
        for(CTableColumn col : columns) {
            row.add(col.getCellsList().get(indexOfQueryCell));
        }
        return row;
    }

    /**
     * Returns data entry from a given row.
     * @param rowElement an ArrayList of row table cells
     * @return the data entry related to the row table cells
     */
    public T getDataEntryFromRowElement(ArrayList<CTableCell> rowElement) {
        int indexOfCell = columns.get(0).getCellsList().indexOf(rowElement.get(0));
        return data.getList().get(indexOfCell);
    }

    /**
     * Returns a list of the credentials.
     * @return a Credentials object representing the credentials the Table holds
     */
    public Credentials getData() { return data; }

    /***
     * Gets the columns
     * @return a LinkedList of table columns
     */
    public LinkedList<CTableColumn> getColumns() { return columns; }

    /**
     * Calls controller to open the details pane for this row
     * @param rowElement
     */
    public void openDetailsPane(ArrayList rowElement) {
        controller.openDetailsPane(getDataEntryFromRowElement(rowElement));
    }
}

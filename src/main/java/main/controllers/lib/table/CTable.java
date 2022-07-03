package main.controllers.lib.table;

import javafx.geometry.Insets;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import main.controllers.lib.table.CTableColumn;
import main.model.data.credential.Credential;
import main.model.data.credential.Credentials;

import java.util.ArrayList;
import java.util.LinkedList;

public class CTable<T extends Credential> extends AnchorPane {


    // FXML
    private HBox columnsList;


    // We don't know what type of data the column contains.
    private LinkedList<CTableColumn> columns;
    private Credentials<T> data;

    /**
     * Constructs a Table object.
     * @param columns a LinkedList of columns
     */
    public CTable(LinkedList<CTableColumn> columns) {
        this.columns = columns;
        data = new Credentials<>();

        // UI
        // AnchorPane
        setMinWidth(100);
        setMinHeight(20);

        columnsList = new HBox();
        // Set Constraints.
        setTopAnchor(columnsList, 0.0);
        setRightAnchor(columnsList, 0.0);
        setBottomAnchor(columnsList, 0.0);
        setLeftAnchor(columnsList, 0.0);
        getChildren().add(columnsList);
        columnsList.getChildren().addAll(columns);

        // Debug
        setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    /**
     * Adds a table column to the table.
     * @param CTableColumn the table column
     */
    private void addColumn(CTableColumn CTableColumn) {
        columns.add(CTableColumn);
        columnsList.getChildren().add(CTableColumn);
    }


    /**
     * Adds a row to the table
     * @param row an object to add a row to
     */
    public void addRow(T row) throws Exception {
        ArrayList<String> rowData = row.getData();
        if(rowData != null) {
            if(rowData.size() == columns.size()) {
                System.out.println(rowData);
                // Add row data
                data.addCredential(row);
                for(int i = 0; i < columns.size(); i++) {
                    columns.get(i).addCell(new CTableCell(rowData.get(i)));
                }
            } else {
                throw new Exception(String.format("Invalid data provided. Expected %d. Provided %d", columns.size(), rowData.size()));
            }
        } else {
            throw new Exception("called addRow() on a credential with no valid data.");
        }

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
}

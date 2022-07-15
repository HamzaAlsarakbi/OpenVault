package main.controllers.lib.table;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.LinkedList;

public class CTableColumn extends AnchorPane {
    private LinkedList<CTableCell> cellsList;

    private VBox cellsVBox;
    private Label headerLabel;
    private CTable table;



    /***
     * Constructs a table column object.
     * @param header a string representing the header of the column.
     * @param cells the cells
     */
    public CTableColumn(String header, LinkedList<CTableCell> cells, CTable table) {
        cellsList = new LinkedList<>();
        setCellsList(cells);

        // UI
        setMinWidth(100);
        setMinHeight(40);
        HBox.setHgrow(this, Priority.ALWAYS);
//        HBox.setMargin(this, new Insets(0, 2, 0, 2));


        // Header
        headerLabel = new Label(header);
        // Style
        headerLabel.setBorder(new Border(new BorderStroke(Color.WHITE, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        headerLabel.setFont(new Font("Arial", 18));
        headerLabel.setStyle("-fx-font-weight: bold");
        headerLabel.setTextFill(Color.rgb(250, 250, 250));
        // Alignment
        headerLabel.setMinHeight(20);
        headerLabel.setAlignment(Pos.CENTER);
        setTopAnchor(headerLabel, 0.0);
        setLeftAnchor(headerLabel, 0.0);
        setRightAnchor(headerLabel, 0.0);

        // Cells
        cellsVBox = new VBox();
        // Set Constraints.
        setTopAnchor(cellsVBox, 20.0);
        setRightAnchor(cellsVBox, 0.0);
        setBottomAnchor(cellsVBox, 0.0);
        setLeftAnchor(cellsVBox, 0.0);
        getChildren().addAll(headerLabel, cellsVBox);
    }

    /**
     * Constructs a table column object.
     * @param header a string representing the header of the column
     */
    public CTableColumn(String header, CTable table) { this(header, new LinkedList<>(), table); }

    public LinkedList<CTableCell> getCellsList() { return cellsList; }

    /**
     * Adds a new cell.
     * @param cell
     */
    public void addCell(CTableCell cell) {
        // Add to to the top of the column
        cellsList.addFirst(cell);
        cellsVBox.getChildren().add(0, cell);
    }

    /**
     * Overwrites the current cells list with a new list.
     * @param cellsList the new list of cells to replace the old list.
     */
    public void setCellsList(LinkedList<CTableCell> cellsList) {
        for(CTableCell cell : cellsList) addCell(cell);
    }

    public String toString() {
        return String.format("Table Column. Cells: %s", cellsList);
    }
}

package main.controllers.lib.table;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class CTableCell extends AnchorPane {

    private Label label;
    private CTable table;
    private CTableColumn tableColumn;

    /**
     * Constructs a TableCell object.
     */
    public CTableCell(String text, CTableColumn column, CTable table) {
        this.tableColumn = column;
        this.table = table;
        label = new Label(text);
        // Style
        label.setFont(new Font("Arial", 12));
        label.setAlignment(Pos.CENTER);
        label.setTextFill(Color.rgb(240, 240, 240));
        // Position
        setMinWidth(10);
        setMinHeight(40);
        setTopAnchor(label, 0.0);
        setRightAnchor(label, 0.0);
        setBottomAnchor(label, 0.0);
        setLeftAnchor(label, 0.0);
        VBox.setMargin(this, new Insets(2, 0, 2, 0));
        getChildren().add(label);

        // Events
        setOnMouseEntered(mouseEvent -> hoverHandler(mouseEvent));
        setOnMouseExited(mouseEvent -> deHoverHandler(mouseEvent));
        setOnMouseClicked(mouseEvent -> mouseClickHandler(mouseEvent));
    }

    public String getLabel() { return label.getText(); }
    public void setLabel(String text) {label.setText(text); }



    // Handlers
    private void hoverHandler(MouseEvent mouseEvent) {
        setCursor(Cursor.HAND);
        ArrayList<CTableCell> row = table.getRowElement(this);
        for(CTableCell cell : row) {
            cell.setBackground(new Background(new BackgroundFill(Color.rgb(100, 100, 100, 0.5), CornerRadii.EMPTY, Insets.EMPTY)));
        }
    }
    private void deHoverHandler(MouseEvent mouseEvent) {
        ArrayList<CTableCell> row = table.getRowElement(this);
        for(CTableCell cell : row) {
            cell.setBackground(Background.EMPTY);
        }
    }
    private void mouseClickHandler(MouseEvent mouseEvent) {
        System.out.println("Cell clicked!");
        System.out.println(table.getRowElement(this));
    }

    @Override
    public String toString() {
        return String.format("Table cell. Content: \"%s\"", label.getText());
    }


}

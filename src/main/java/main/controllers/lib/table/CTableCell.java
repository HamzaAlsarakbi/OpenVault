package main.controllers.lib.table;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class CTableCell extends AnchorPane {

    private Label label;

    /**
     * Constructs a TableCell object.
     */
    public CTableCell(String text) {
        label = new Label(text);
        setMinWidth(10);
        setMinHeight(40);
        label.setFont(new Font("Arial", 12));
        label.setAlignment(Pos.CENTER);
        setTopAnchor(label, 0.0);
        setRightAnchor(label, 0.0);
        setBottomAnchor(label, 0.0);
        setLeftAnchor(label, 0.0);
        getChildren().add(label);


        // Debug
        setBackground(new Background(new BackgroundFill(Color.YELLOW, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public String getLabel() { return label.getText(); }
    public void setLabel(String text) {label.setText(text); }
}

package main.controllers.lib.list;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import main.model.data.log.LogEntry;
import main.model.data.log.LogTitle;

import java.util.ArrayList;
import java.util.Date;

public class CList extends AnchorPane {
    private VBox itemsRootPane;
    private ScrollPane scrollPane;
    private ArrayList<LogEntry> data;
    private ArrayList<CListItem> listItems;

    public CList(ArrayList<LogEntry> data) {
        // root pane
        getStyleClass().add("root");
        // ScrollPane properties
        scrollPane = new ScrollPane();
        setTopAnchor(scrollPane, 0.0);
        setRightAnchor(scrollPane, 0.0);
        setBottomAnchor(scrollPane, 0.0);
        setLeftAnchor(scrollPane, 0.0);
        scrollPane.getStyleClass().add("scroll-pane");
        getChildren().add(scrollPane);

        // VBox
        itemsRootPane = new VBox();
        scrollPane.setContent(itemsRootPane);
        itemsRootPane.getStyleClass().add("vbox-pane");

        updateData(data);
        getStylesheets().add(getClass().getResource("/stylesheets/lib/list.css").toExternalForm());
    }

    private void updateData(ArrayList<LogEntry> data) {
        // Clear list
        this.data = data;
        listItems = new ArrayList<>();
        itemsRootPane.getChildren().clear();
        // Add data entries
        for(LogEntry dataEntry : data) {
            CListItem item = new CListItem(dataEntry.getTitle(), dataEntry.getDescription(), dataEntry.getDate());
            listItems.add(item);
            itemsRootPane.getChildren().add(item);
        }
    }


}

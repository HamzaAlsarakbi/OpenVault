package main.controllers.lib.list;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.util.Date;

public class CListItem extends AnchorPane {
    private Label titleLabel, descriptionLabel, timeLabel;
    private Date date;
    private final static double PADDING = 4.0;

    public CListItem(String title, String description, Date date) {
        // root
        getStyleClass().add("item");
        // Title
        titleLabel = new Label(title);
        setTopAnchor(titleLabel, PADDING);
        setLeftAnchor(titleLabel, PADDING);
        titleLabel.getStyleClass().add("title");
        // Description
        descriptionLabel = new Label(description);
        setBottomAnchor(descriptionLabel, PADDING);
        setLeftAnchor(descriptionLabel, PADDING);
        descriptionLabel.getStyleClass().add("description");
        // Date
        this.date = date;
        timeLabel = new Label(getStringifiedDate(date));
        setBottomAnchor(timeLabel, PADDING);
        setRightAnchor(timeLabel, PADDING);
        timeLabel.getStyleClass().add("date");

        getChildren().addAll(titleLabel, descriptionLabel, timeLabel);
        getStylesheets().add(getClass().getResource("/stylesheets/lib/list.css").toExternalForm());
    }

    // Temp
    private String getStringifiedDate(Date date) {
        return date.toString();
    }
}

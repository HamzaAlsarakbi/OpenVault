package main.controllers.lib;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class PasswordFieldSkin extends AnchorPane {
    private PasswordField passwordField;
    private TextField textField;
    private boolean isVisible;
    private StackPane toggleButton;
    private ImageView icon;
    private final String HIDE_ICON_PATH = "/icons/common/password/hide.png";
    private final String SHOW_ICON_PATH = "/icons/common/password/show.png";
    private final int ICON_SIZE = 20;



    public PasswordFieldSkin(String text) {
        isVisible = false;
        // Password Field
        passwordField = new PasswordField();
        passwordField.setText(text);
        setLeftAnchor(passwordField, 0.0);
        setTopAnchor(passwordField, 0.0);
        setBottomAnchor(passwordField, 0.0);
        setRightAnchor(passwordField, 30.0);

        // Text Field
        textField = new TextField(text);
        textField.setVisible(false);
        setLeftAnchor(textField, 0.0);
        setTopAnchor(textField, 0.0);
        setBottomAnchor(textField, 0.0);
        setRightAnchor(textField, 30.0);
        textField.setVisible(false);

        // Hide/Show Button
        toggleButton = new StackPane();
        setTopAnchor(toggleButton, 0.0);
        setRightAnchor(toggleButton, 0.0);
        setBottomAnchor(toggleButton, 0.0);
        toggleButton.setPrefHeight(30);
        toggleButton.setPrefWidth(30);
        toggleButton.setId("toggle-button");
        icon = new ImageView();

        // Events
        toggleButton.setOnMouseClicked(mouseEvent -> toggleButtonHandler(mouseEvent));


        // Add
        getChildren().addAll(passwordField, textField, toggleButton);
        toggleButton.getChildren().add(icon);

        // Update button
        hidePassword();

        // Load stylesheet
        getStylesheets().add(getClass().getResource("/stylesheets/lib/password_field_skin.css").toExternalForm());
    }

    private void toggleButtonHandler(MouseEvent e) { toggleVisibility(); }


    private TextField getActiveField() { return isVisible ? textField : passwordField; }

    public String getText() { return getActiveField().getText(); }
    public void setText(String text) { getActiveField().setText(text); }

    public void toggleVisibility() {
        if(isVisible) {
            hidePassword();
        } else {
            showPassword();
        }
        isVisible = !isVisible;
    }

    private void hidePassword() {
        passwordField.setText(getText());
        textField.setVisible(false);
        passwordField.setVisible(true);
        icon.setImage(new Image(getClass().getResourceAsStream(SHOW_ICON_PATH), ICON_SIZE, ICON_SIZE, true, true));
    }

    private void showPassword() {
        textField.setText(getText());
        textField.setVisible(true);
        passwordField.setVisible(false);
        icon.setImage(new Image(getClass().getResourceAsStream(HIDE_ICON_PATH), ICON_SIZE, ICON_SIZE, true, true));
    }

}

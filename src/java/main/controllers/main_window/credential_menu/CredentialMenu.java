package main.controllers.main_window.credential_menu;

import main.controllers.main_window.MainWindowController;
import main.model.data.credential.Credential;

import java.util.ArrayList;

public abstract class CredentialMenu {
    private MainWindowController parentController;
    public CredentialMenu() {}


    public void setParentController(MainWindowController mainWindowController) { parentController = mainWindowController; }
    protected MainWindowController getParentController() { return parentController; }

    public abstract void openDetailsPane(Credential credential);
}

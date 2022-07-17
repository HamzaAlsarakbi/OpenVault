module main {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.base;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires org.junit.jupiter.api;

    exports main.model.lib;
    opens main.model.lib to javafx.fxml;
    opens main.controllers to javafx.fxml;
    exports main.controllers;
    opens main.controllers.lib to javafx.fxml;
    exports main.controllers.lib;
    opens main to javafx.fxml;
    exports main;
    exports main.controllers.main_window;
    opens main.controllers.main_window to javafx.fxml;
    exports main.controllers.main_window.credential_menu;
    opens main.controllers.main_window.credential_menu to javafx.fxml;
    exports main.controllers.lib.table;
    opens main.controllers.lib.table to javafx.fxml;
    exports main.controllers.main_window.credential_menu.menus;
    opens main.controllers.main_window.credential_menu.menus to javafx.fxml;
    exports main.controllers.main_window.credential_menu.menus.logins;
    opens main.controllers.main_window.credential_menu.menus.logins to javafx.fxml;
}
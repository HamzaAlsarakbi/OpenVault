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

    exports main.lib;
    opens main.lib to javafx.fxml;
    opens main.controllers to javafx.fxml;
    exports main.controllers;
    opens main.controllers.lib to javafx.fxml;
    exports main.controllers.lib;
    opens main to javafx.fxml;
    exports main;
    exports main.controllers.main;
    opens main.controllers.main to javafx.fxml;
    exports main.controllers.main.components;
    opens main.controllers.main.components to javafx.fxml;
    exports main.controllers.lib.table;
    opens main.controllers.lib.table to javafx.fxml;
}
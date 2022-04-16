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
    opens main to javafx.fxml;
    exports main;
    opens main.controllers to javafx.fxml;
    exports main.controllers;
}
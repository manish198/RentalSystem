/**
 * 
 */
/**
 * @author manish
 *
 */
module RentalSystem {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.media;
    exports gui.config;
    exports gui.controller;
    opens gui.config to javafx.fxml;
    opens gui.controller to javafx.fxml;
    exports gui.utils;
    opens gui.controller.tenant to javafx.fxml;
    opens gui.utils to javafx.fxml;
    exports gui.controller.property;
    exports gui.controller.tenant;
    opens gui.controller.property to javafx.fxml;
    exports gui.controller.lease;
    opens gui.controller.lease to javafx.fxml;

//    requires org.junit.jupiter.api;
}
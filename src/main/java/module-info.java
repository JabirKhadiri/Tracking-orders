module ma.fstt.trackingl {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens ma.fstt.trackingl to javafx.fxml;
    exports ma.fstt.trackingl;

    exports ma.fstt.model;
    exports ma.fstt.viewController;
    opens ma.fstt.viewController to javafx.fxml;
    exports ma.fstt.Controller;

    requires java.sql;
}
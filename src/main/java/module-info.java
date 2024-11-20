module application.demo {
    requires javafx.controls;
    requires javafx.fxml;

    opens application.demo to javafx.fxml;
    exports application.demo;
}

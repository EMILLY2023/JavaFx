module com.example.airfrance {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;


    opens com.example.airfrance to javafx.fxml;
    exports com.example.airfrance;
    exports com.example.airfrance.controllers;
    opens com.example.airfrance.controllers to javafx.fxml;
}
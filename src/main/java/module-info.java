module com.example.airfrance {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.airfrance to javafx.fxml;
    exports com.example.airfrance;
}
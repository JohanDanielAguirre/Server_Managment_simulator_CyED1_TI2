module com.example.servermanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.servermanagement to javafx.fxml;
    exports com.example.servermanagement;
    exports com.example.servermanagement.controller;
    opens com.example.servermanagement.controller to javafx.fxml;
}
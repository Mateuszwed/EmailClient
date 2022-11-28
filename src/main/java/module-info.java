module com.example.emailclientapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens com.example.emailclientapp to javafx.fxml;
    exports com.example.emailclientapp;
    exports com.example.emailclientapp.controller;
    opens com.example.emailclientapp.controller to javafx.fxml;
}
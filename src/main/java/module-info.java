module com.example.emailclientapp {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.web;

    opens com.example.emailclientapp to javafx.fxml;
    exports com.example.emailclientapp;
    exports com.example.emailclientapp.controller;
    opens com.example.emailclientapp.controller to javafx.fxml;
    //exports com.example.emailclientapp.view;
    //opens com.example.emailclientapp.view to javafx.fxml;
}
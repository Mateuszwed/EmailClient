package com.example.emailclientapp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginWindowController {


    public void loginButtonAction(ActionEvent actionEvent) {
        System.out.println("Klik");
    }

    public class LoginWindow {

        @FXML
        private TextField emailAddressField;

        @FXML
        private TextField passwordField;

        @FXML
        private Label errorLabel;

    }

}

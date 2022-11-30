package com.example.emailclientapp;

import javafx.application.Application;
import javafx.stage.Stage;



public class Laucher extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {

        ViewFactory viewFactory = new ViewFactory(new EmailManager());
        viewFactory.showLoginWindow();


    }
}
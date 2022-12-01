package com.example.emailclientapp.controller;

import com.example.emailclientapp.EmailManager;
import com.example.emailclientapp.ViewFactory;
import com.example.emailclientapp.controller.services.LoginService;
import com.example.emailclientapp.model.EmailAccount;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginWindowController extends BaseController implements Initializable {

    @FXML
    private TextField emailAddressField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    public LoginWindowController(EmailManager emailManager, ViewFactory viewFactory, String fxmlName) {
        super(emailManager, viewFactory, fxmlName);
    }
    @FXML
    void loginButtonAction() {
        System.out.println("loginButtonAction");
        if(fieldsAreValid()){
            EmailAccount emailAccount = new EmailAccount(emailAddressField.getText(), passwordField.getText());
            LoginService loginService = new LoginService(emailAccount, emailManager);
            loginService.start();
            loginService.setOnSucceeded(event -> {
                EmailLoginResult emailLoginResult = loginService.getValue();

                switch (emailLoginResult) {
                    case SUCCESS:
                        System.out.println("login succesfull!!!" + emailAccount);
                        if(!viewFactory.isMainViewInitialized()){
                            viewFactory.showMainWindow();
                        }
                        Stage stage = (Stage) errorLabel.getScene().getWindow();
                        viewFactory.closeStage(stage);
                        return;
                    case FAILED_BY_CREDENTIALS:
                        errorLabel.setText("invalid credentials!");
                    case FAILED_BY_UNEXPECTED_ERROR:
                        errorLabel.setText("unexpected error!");
                    default:
                        return;
                }
            });
        }

    }

    private boolean fieldsAreValid() {
        if(emailAddressField.getText().isEmpty()) {
            errorLabel.setText("Please fill email");
            return false;
        }
        if(passwordField.getText().isEmpty()) {
            errorLabel.setText("Please fill password");
            return false;
        }

        return true;

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        emailAddressField.setText("javafxtest@onet.pl");
        passwordField.setText("Everest2020");
    }
}


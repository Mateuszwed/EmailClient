package com.example.emailclientapp;

import com.example.emailclientapp.controller.persistence.PersistenceAccess;
import com.example.emailclientapp.controller.persistence.ValidAccount;
import com.example.emailclientapp.controller.services.LoginService;
import com.example.emailclientapp.model.EmailAccount;
import com.example.emailclientapp.view.ViewFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;


public class Launcher extends Application {


    public static void main(String[] args) {
        launch();
    }

    private PersistenceAccess persistenceAccess = new PersistenceAccess();
    private EmailManager emailManager = new EmailManager();

    @Override
    public void start(Stage stage) {
        ViewFactory viewFactory = new ViewFactory(emailManager);
        List<ValidAccount> validAccountsList = persistenceAccess.loadFromPersistence();
        if(validAccountsList.size() > 0) {
            viewFactory.showMainWindow();
            for(ValidAccount validAccount: validAccountsList){
                EmailAccount emailAccount = new EmailAccount(validAccount.getAddress(), validAccount.getPassword());
                LoginService loginService = new LoginService(emailAccount, emailManager);
                loginService.start();

            }
        }else {
            viewFactory.showLoginWindow();
        }
    }


    @Override
    public void stop() throws Exception {
        List<ValidAccount> validAccountsList = new ArrayList<ValidAccount>();
        for( EmailAccount emailAccount: emailManager.getEmailAccounts() ){
            validAccountsList.add(new ValidAccount(emailAccount.getAddress(), emailAccount.getPassword()));
        }

        persistenceAccess.saveToPersistence(validAccountsList);
    }


}
package com.example.emailclientapp;

import com.example.emailclientapp.controller.services.FetchFoldersService;
import com.example.emailclientapp.model.EmailAccount;
import com.example.emailclientapp.model.EmailTreeItem;

public class EmailManager {

    private EmailTreeItem<String> foldersRoot = new EmailTreeItem<String>("");

    public EmailTreeItem<String> getFoldersRoot() {
        return foldersRoot;
    }

    public void addEmailAccount(EmailAccount emailAccount){
        EmailTreeItem<String> treeItem = new EmailTreeItem<>(emailAccount.getAddress());
        FetchFoldersService fetchFoldersService = new FetchFoldersService(emailAccount.getStore(), treeItem);
        fetchFoldersService.start();
        foldersRoot.getChildren().add(treeItem);

    }
}

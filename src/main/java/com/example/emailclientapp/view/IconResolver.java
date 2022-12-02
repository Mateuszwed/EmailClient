package com.example.emailclientapp.view;

import com.example.emailclientapp.Launcher;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class IconResolver {

    public Node getIconFolder(String folderName) {
        String lowerCaseFolderName = folderName.toLowerCase();
        ImageView imageView;
        try{
            if(lowerCaseFolderName.contains("@")){
                imageView = new ImageView(new Image(Launcher.class.getResourceAsStream("email.png")));
            } else if (lowerCaseFolderName.contains("inbox")) {
                imageView = new ImageView(new Image(Launcher.class.getResourceAsStream("inbox.png")));
            } else if (lowerCaseFolderName.contains("sent")) {
                imageView = new ImageView(new Image(Launcher.class.getResourceAsStream("sent2.png")));
            } else if (lowerCaseFolderName.contains("spam")) {
                imageView = new ImageView(new Image(Launcher.class.getResourceAsStream("spam.png")));
            } else {
                imageView = new ImageView(new Image(Launcher.class.getResourceAsStream("folder.png")));
            }

        } catch (Exception  e){
            e.printStackTrace();
            return null;
        }
        return imageView;
    }
}

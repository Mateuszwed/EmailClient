package com.example.emailclientapp;

import com.example.emailclientapp.controller.BaseController;
import com.example.emailclientapp.controller.LoginWindowController;
import com.example.emailclientapp.controller.MainWindowController;
import com.example.emailclientapp.controller.OptionsWindowController;
import com.example.emailclientapp.view.ColorTheme;
import com.example.emailclientapp.view.FontSize;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ViewFactory {

    private EmailManager emailManager;
    private ArrayList<Stage> activesStages;
    private  boolean mainViewInitialized = false;

    public ViewFactory(EmailManager emailManager) {
        this.emailManager = emailManager;
        activesStages = new ArrayList<Stage>();
    }

    public boolean isMainViewInitialized() {
        return mainViewInitialized;
    }

    private ColorTheme colorTheme = ColorTheme.DARK;
    private FontSize fontSize = FontSize.MEDIUM;

    public ColorTheme getColorTheme() {
        return colorTheme;
    }

    public void setColorTheme(ColorTheme colorTheme) {
        this.colorTheme = colorTheme;
    }

    public FontSize getFontSize() {
        return fontSize;
    }

    public void setFontSize(FontSize fontSize) {
        this.fontSize = fontSize;
    }

    public void showLoginWindow() {
        System.out.println("show login window called");

        BaseController controller = new LoginWindowController(emailManager, this, "LoginWindow.fxml");
        initializeStage(controller);
    }

    public void showMainWindow(){
        System.out.println("show main window called");

        BaseController controller = new MainWindowController(emailManager, this, "MainWindow.fxml");
        initializeStage(controller);
        mainViewInitialized = true;
    }


    public void showOptionWindow(){
        System.out.println("show option window called");

        BaseController controller = new OptionsWindowController(emailManager, this, "OptionsWindow.fxml");
        initializeStage(controller);
    }


    private void initializeStage(BaseController baseController){

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;
        try {
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        activesStages.add(stage);
    }

    public void closeStage(Stage stage){
        stage.close();
        activesStages.remove(stage);
    }

    public void updateStyles() {
        for(Stage stage : activesStages){
            Scene scene = stage.getScene();
            scene.getStylesheets().clear();
            scene.getStylesheets().add(getClass().getResource(ColorTheme.getCssPath(colorTheme)).toExternalForm());
            scene.getStylesheets().add(getClass().getResource(FontSize.getCssPath(fontSize)).toExternalForm());
        }
    }
}


package com.agroassist.agroassistant.controllers;

import com.agroassist.agroassistant.dao.DataBaseHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class BaseController extends DataBaseHandler {

    protected String basePath = "/com/agroassist/agroassistant/";

    protected void setScene(Button button, String path){

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(path));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        button.getScene().getWindow().hide();
    }
}

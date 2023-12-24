package com.agroassist.agroassistant.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class HelloController extends BaseController {

    @FXML
    private Button enterButton;

    @FXML
    void initialize() {
        enterButton.setOnAction(event -> {
            setScene(enterButton, basePath + "forms/Menu.fxml");
        });
    }
}
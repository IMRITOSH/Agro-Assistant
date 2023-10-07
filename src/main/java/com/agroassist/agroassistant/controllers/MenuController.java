package com.agroassist.agroassistant.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuController extends BaseController{

    @FXML
    private Button buttonCrops;

    @FXML
    private Button buttonExit;

    @FXML
    private Button buttonFields;

    @FXML
    void initialize() {
        buttonCrops.setOnAction(event -> {
            setScene(buttonCrops, basePath + "forms/crops/Crops.fxml");
        });

        buttonFields.setOnAction(event ->{
            setScene(buttonFields, basePath + "forms/fields/Fields.fxml");
        });

        buttonExit.setOnAction(event ->{
            Platform.exit();
        });
    }
}

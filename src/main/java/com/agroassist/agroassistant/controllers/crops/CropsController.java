package com.agroassist.agroassistant.controllers.crops;

import com.agroassist.agroassistant.controllers.BaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class CropsController extends BaseController {

    @FXML
    private Button buttonAddCrops;

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonCalculateGrow;

    @FXML
    private Button buttonCompare;

    @FXML
    private Button buttonDeleteCrops;

    @FXML
    private Button buttonEditCrops;

    @FXML
    private Button buttonCalculateCentner;

    @FXML
    void initialize(){
        buttonAddCrops.setOnAction(event -> {
            setScene(buttonAddCrops, basePath + "forms/crops/addCrops.fxml");
        });

        buttonEditCrops.setOnAction(event -> {
            setScene(buttonEditCrops, basePath + "forms/crops/EditCrops.fxml");
        });

        buttonBack.setOnAction(event -> {
            setScene(buttonBack, basePath + "forms/Menu.fxml");
        });
    }
}

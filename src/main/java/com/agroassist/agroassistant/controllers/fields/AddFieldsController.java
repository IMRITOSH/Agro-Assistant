package com.agroassist.agroassistant.controllers.fields;

import com.agroassist.agroassistant.controllers.BaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddFieldsController extends BaseController {

    @FXML
    private Button buttonBack;

    @FXML
    private Button buttonSaveField;

    @FXML
    private TextField textFieldArea;

    @FXML
    private TextField textFieldCrop;

    @FXML
    private TextField textFieldID;

    @FXML
    private TextField textFieldNumberOfField;

    @FXML
    private TextField textFieldSort;

    @FXML
    private TextField textFieldYear;

    @FXML
    void initialize(){
        buttonBack.setOnAction(event -> {
            setScene(buttonBack, basePath + "forms/fields/Fields.fxml");
        });
    }

}


package com.agroassist.agroassistant.controllers.crops;

import com.agroassist.agroassistant.controllers.BaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class EditCropsController extends BaseController {

    @FXML
    private Button buttoSaveCrops;

    @FXML
    private Button buttonBack;

    @FXML
    private ComboBox<?> comboBoxField;

    @FXML
    private TextField textFieldBrutto;

    @FXML
    private TextField textFieldNetto;

    @FXML
    private TextField textFieldTara;

    @FXML
    private TextField textFieldYear;

    @FXML
    void initialize(){
        buttonBack.setOnAction(event -> {
            setScene(buttonBack, basePath + "forms/crops/Crops.fxml");
        });
    }
}

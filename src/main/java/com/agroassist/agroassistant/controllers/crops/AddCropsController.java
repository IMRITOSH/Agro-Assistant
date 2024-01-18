package com.agroassist.agroassistant.controllers.crops;

import com.agroassist.agroassistant.controllers.BaseController;
import com.agroassist.agroassistant.helpers.CropsHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddCropsController extends BaseController {

    @FXML
    private Button buttonSaveCrops;

    @FXML
    private Button buttonBack;

    @FXML
    private TextField textFieldNumber;

    @FXML
    private TextField textFieldBrutto;

    @FXML
    private TextField textFieldNetto;

    @FXML
    private TextField textFieldTara;

    @FXML
    private TextField textFieldDate;

    @FXML
    private Label fieldNumberLabel;

    @FXML
    private Label bruttoLabel;

    @FXML
    private Label nettoLabel;

    @FXML
    private Label taraLabel;

    @FXML
    private Label dateLabel;

    @FXML
    void initialize() {
        buttonSaveCrops.setOnAction(event -> {
            CropsHelper helper = new CropsHelper();
            Label[] labels = new Label[]{
                    fieldNumberLabel,
                    bruttoLabel,
                    taraLabel,
                    nettoLabel,
                    dateLabel
            };

            String fieldNumber = textFieldNumber.getText();
            String brutto = textFieldBrutto.getText();
            String tara = textFieldTara.getText();
            String netto = textFieldNetto.getText();
            String date = textFieldDate.getText();

            if (helper.validateCrop(fieldNumber, brutto, tara, netto, date, labels)) {
                if (addCrop(fieldNumber, Integer.parseInt(brutto), Integer.parseInt(tara), Integer.parseInt(netto), date)) {
                    setScene(buttonBack, basePath + "forms/crops/Crops.fxml");
                }
            } 

        });

        buttonBack.setOnAction(event -> {
            setScene(buttonBack, basePath + "forms/crops/Crops.fxml");
        });
    }
}


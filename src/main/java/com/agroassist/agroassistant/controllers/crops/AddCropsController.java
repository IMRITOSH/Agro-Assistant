package com.agroassist.agroassistant.controllers.crops;

import com.agroassist.agroassistant.controllers.BaseController;
import com.agroassist.agroassistant.helpers.CropsHelper;
import com.agroassist.agroassistant.helpers.FieldsHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddCropsController extends BaseController {

    @FXML
    private Button buttonSaveCrops;

    @FXML
    private Button buttonBack;

    @FXML
    private TextField textFieldNumberField;

    @FXML
    private TextField textFieldBrutto;

    @FXML
    private TextField textFieldNetto;

    @FXML
    private TextField textFieldTara;

    @FXML
    private TextField textFieldYear;

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
    void initialize(){
        buttonSaveCrops.setOnAction(event ->{
            CropsHelper helper = new CropsHelper();
            Label[] labels = new Label[]{
                    fieldNumberLabel,
                    bruttoLabel,
                    taraLabel,
                    nettoLabel,
                    dateLabel
            };
            String fieldNumber = textFieldNumberField.getText();
            String brutto = textFieldBrutto.getText();
            String tara = textFieldTara.getText();
            String netto = textFieldNetto.getText();
            String year = textFieldYear.getText();

            if (!helper.validateCrop(fieldNumber, brutto, tara, netto, year, labels)){
                System.out.println("Ошибка!!!!");
            }
            else if (addCrop(fieldNumber, Integer.parseInt(brutto), Integer.parseInt(tara), Integer.parseInt(netto), year)){
                setScene(buttonBack, basePath + "forms/crops/Crops.fxml");
            }
        });

        buttonBack.setOnAction(event -> {
            setScene(buttonBack, basePath + "forms/crops/Crops.fxml");
        });
    }
}


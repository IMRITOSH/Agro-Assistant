package com.agroassist.agroassistant.controllers.crops;

import com.agroassist.agroassistant.controllers.BaseController;
import com.agroassist.agroassistant.helpers.CropsHelper;
import com.agroassist.agroassistant.helpers.FieldsHelper;
import com.agroassist.agroassistant.models.Crop;
import com.agroassist.agroassistant.models.Field;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static com.agroassist.agroassistant.controllers.crops.CropsController.idCrop;

public class EditCropsController extends BaseController {

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
        CropsHelper helper = new CropsHelper();
        Label[] labels = new Label[]{
                fieldNumberLabel,
                bruttoLabel,
                taraLabel,
                nettoLabel,
                dateLabel
        };
        Crop oldCrop = getCrop(idCrop);
        textFieldNumberField.setText(oldCrop.getFieldNumber());
        textFieldBrutto.setText(oldCrop.getBrutto().toString());
        textFieldNetto.setText(oldCrop.getNetto().toString());
        textFieldTara.setText(oldCrop.getTara().toString());
        textFieldYear.setText(oldCrop.getDate().toString());

        buttonSaveCrops.setOnAction(event ->{
            String fieldNumber = textFieldNumberField.getText();
            String brutto = textFieldBrutto.getText();
            String tara = textFieldTara.getText();
            String netto = textFieldNetto.getText();
            String year = textFieldYear.getText();

            if (!helper.validateCrop(fieldNumber, brutto, tara, netto, year, labels)){
                System.out.println("Ошибка!!!!");
            }
            else if (editCrop(idCrop, fieldNumber, Integer.parseInt(brutto), Integer.parseInt(tara), Integer.parseInt(netto), year)){
//                helper.changeDefaultLabel(labels);
                setScene(buttonBack, basePath + "forms/crops/Crops.fxml");
            }
        });

        buttonBack.setOnAction(event -> {
            setScene(buttonBack, basePath + "forms/crops/Crops.fxml");
        });
    }
}

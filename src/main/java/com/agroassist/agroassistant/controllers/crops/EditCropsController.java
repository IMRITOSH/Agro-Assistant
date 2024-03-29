package com.agroassist.agroassistant.controllers.crops;

import com.agroassist.agroassistant.controllers.BaseController;
import com.agroassist.agroassistant.helpers.CropsHelper;
import com.agroassist.agroassistant.models.Crop;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static com.agroassist.agroassistant.controllers.crops.CropsController.idCrop;

public class EditCropsController extends BaseController {

    @FXML
    private Button buttonSaveCrops;

    @FXML
    private Button buttonBack;

    @FXML
    private TextField textFieldCropId;

    @FXML
    private TextField textFieldNumber;

    @FXML
    private TextField textFieldBrutto;

    @FXML
    private TextField textFieldTara;

    @FXML
    private TextField textFieldYear;

    @FXML
    private Label fieldNumberLabel;

    @FXML
    private Label bruttoLabel;

    @FXML
    private Label taraLabel;

    @FXML
    private Label dateLabel;

    @FXML
    void initialize() {
        CropsHelper helper = new CropsHelper();
        Label[] labels = new Label[]{
                fieldNumberLabel,
                bruttoLabel,
                taraLabel,
                dateLabel
        };

        fillOldCrop();

        buttonSaveCrops.setOnAction(event -> {
            String fieldNumber = textFieldNumber.getText();
            String brutto = textFieldBrutto.getText();
            String tara = textFieldTara.getText();
            int netto;
            String year = textFieldYear.getText();

            if (helper.validateCrop(fieldNumber, brutto, tara, year, labels)) {
                netto = Integer.parseInt(brutto) - Integer.parseInt(tara);
                if (editCrop(idCrop, fieldNumber, Integer.parseInt(brutto), Integer.parseInt(tara), netto, year)) {
                    setScene(buttonBack, basePath + "forms/crops/Crops.fxml");
                }
            }
        });

        buttonBack.setOnAction(event -> {
            setScene(buttonBack, basePath + "forms/crops/Crops.fxml");
        });
    }

    private void fillOldCrop() {
        Crop oldCrop = getCrop(idCrop);
        textFieldCropId.setText(oldCrop.getId().toString());
        textFieldNumber.setText(oldCrop.getFieldNumber());
        textFieldBrutto.setText(oldCrop.getBrutto().toString());
        textFieldTara.setText(oldCrop.getTara().toString());
        textFieldYear.setText(oldCrop.getDate().toString());
    }
}

package com.agroassist.agroassistant.controllers.fields;

import com.agroassist.agroassistant.controllers.BaseController;
import com.agroassist.agroassistant.helpers.FieldsHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Date;

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
    private TextField textFieldNumber;

    @FXML
    private TextField textFieldSort;

    @FXML
    private TextField textFieldDate;

    @FXML
    private Label fieldNumberLabel;

    @FXML
    private Label areaLabel;

    @FXML
    private Label cropLabel;

    @FXML
    private Label kindLabel;

    @FXML
    private Label dateLabel;

    @FXML
    void initialize() {
        buttonSaveField.setOnAction(event -> {
            FieldsHelper helper = new FieldsHelper();
            Label[] labels = new Label[]{
                    fieldNumberLabel,
                    areaLabel,
                    cropLabel,
                    kindLabel,
                    dateLabel
            };

            String fieldNumber = textFieldNumber.getText();
            String area = textFieldArea.getText();
            String crop = textFieldCrop.getText();
            String kind = textFieldSort.getText();
            String date = textFieldDate.getText();

            if (helper.validateField(fieldNumber, area, crop, kind, date, labels)) {
                if (addField(fieldNumber, Integer.parseInt(area), crop, kind, date)) {
                    setScene(buttonBack, basePath + "forms/fields/Fields.fxml");
                }
            }
        });

        buttonBack.setOnAction(event -> {
            setScene(buttonBack, basePath + "forms/fields/Fields.fxml");
        });
    }

}


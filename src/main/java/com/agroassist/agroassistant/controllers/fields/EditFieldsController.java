package com.agroassist.agroassistant.controllers.fields;

import com.agroassist.agroassistant.helpers.FieldsHelper;
import com.agroassist.agroassistant.models.Crop;
import com.agroassist.agroassistant.models.Field;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import static com.agroassist.agroassistant.controllers.crops.CropsController.idCrop;

public class EditFieldsController extends FieldsController {

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
    private TextField textFieldNumber;

    @FXML
    private TextField textFieldSort;

    @FXML
    private TextField textFieldYear;

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
        FieldsHelper helper = new FieldsHelper();
        Label[] labels = new Label[]{
                fieldNumberLabel,
                areaLabel,
                cropLabel,
                kindLabel,
                dateLabel
        };

        fillOldField();

        buttonSaveField.setOnAction(event -> {
            String fieldNumber = textFieldNumber.getText();
            String area = textFieldArea.getText();
            String crop = textFieldCrop.getText();
            String kind = textFieldSort.getText();
            String year = textFieldYear.getText();

            if (!helper.validateField(fieldNumber, area, crop, kind, year, labels)) {
                System.out.println("Ошибка!!!!");
            } else if (editField(idField, fieldNumber, Integer.parseInt(area), crop, kind, year)) {
                setScene(buttonBack, basePath + "forms/fields/Fields.fxml");
            }
        });

        buttonBack.setOnAction(event -> {
            setScene(buttonBack, basePath + "forms/fields/Fields.fxml");
        });
    }

    private void fillOldField() {
        Field oldFiled = getField(idField);
        textFieldID.setText(oldFiled.getId().toString());
        textFieldNumber.setText(oldFiled.getFieldNumber());
        textFieldArea.setText(oldFiled.getArea().toString());
        textFieldCrop.setText(oldFiled.getCrop());
        textFieldSort.setText(oldFiled.getKind());
        textFieldYear.setText(oldFiled.getDate().toString());
    }
}

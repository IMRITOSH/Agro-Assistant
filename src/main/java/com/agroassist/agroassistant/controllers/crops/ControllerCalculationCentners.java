package com.agroassist.agroassistant.controllers.crops;

import com.agroassist.agroassistant.controllers.BaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControllerCalculationCentners extends BaseController {

    @FXML
    private Button buttonCalculate;

    @FXML
    private TextField textFieldYear;

    @FXML
    private Button buttonBack;

    @FXML
    private Label fieldNumberLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private TextField textFieldNumberField;

    @FXML
    private TextArea ResultTextArea;

    @FXML
    void initialize(){
        buttonCalculate.setOnAction(event ->{
            String numberField = textFieldNumberField.getText();
            String year = textFieldYear.getText();

            double x = getAllNettofromOneField(numberField, year);
            double area = getAreaField(numberField);

            double resultCalculate = (x/area)/100;

            String resultText = String.format("С поля %s было получено %.3f центнеров", numberField, resultCalculate);

            ResultTextArea.setText(resultText);
        });

        buttonBack.setOnAction(event -> {
            setScene(buttonBack, basePath + "forms/crops/Crops.fxml");
        });
    }

}

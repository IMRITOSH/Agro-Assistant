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

            int x = getAllNetto(numberField, year);
            int area = getAreaField(numberField);

            int resultCalculate = (x/area)/100;

//            String resultText = String.format("", numberField, resultCalculate);
        });
    }

}

package com.agroassist.agroassistant.controllers.crops;

import com.agroassist.agroassistant.controllers.BaseController;
import com.agroassist.agroassistant.helpers.CalculationsHelper;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CalculationCentnersController extends BaseController {

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
    void initialize() {
        buttonCalculate.setOnAction(event -> {
            CalculationsHelper helper = new CalculationsHelper();
            Label[] labels = new Label[]{
                    fieldNumberLabel,
                    dateLabel
            };
            String numberField = textFieldNumberField.getText();
            String year = textFieldYear.getText();

            if (helper.validateCalculationCentners(numberField, year, labels)) {
                double x = getAllNettofromOneField(numberField, year);
                double area = getAreaField(numberField);

                if (x == 0.0) {
                    dateLabel.setText("Данные по такому полю или году отсутствуют в базе.");
                    dateLabel.setVisible(true);
                } else if (area == 0.0) {
                    fieldNumberLabel.setText("Данные по такому полю отсутствуют в базе.");
                    fieldNumberLabel.setVisible(true);
                } else {
                    double resultCalculate = (x / area) / 100;
                    String resultText = String.format("С одного гектара поля %s было получено %.3f центнеров", numberField, resultCalculate);
                    ResultTextArea.setText(resultText);
                }
            }
        });

        buttonBack.setOnAction(event -> {
            setScene(buttonBack, basePath + "forms/crops/Crops.fxml");
        });
    }

}

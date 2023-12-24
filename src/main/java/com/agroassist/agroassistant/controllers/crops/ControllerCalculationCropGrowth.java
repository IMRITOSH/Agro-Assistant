package com.agroassist.agroassistant.controllers.crops;

import com.agroassist.agroassistant.controllers.BaseController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControllerCalculationCropGrowth extends BaseController {

    @FXML
    private Button buttonCalculate;

    @FXML
    private TextField textFieldYearY;

    @FXML
    private Button buttonBack;

    @FXML
    private Label fieldNumberLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private TextField textFieldYearX;

    @FXML
    private TextArea textAreaResult;

    @FXML
    void initialize() {
        buttonCalculate.setOnAction(event -> {
            String firstYear = textFieldYearX.getText();
            String secondYear = textFieldYearY.getText();
            String resultText;

            int firstYearNetto = getAllNetto(firstYear);
            int secondYearNetto = getAllNetto(secondYear);

            int result = firstYearNetto - secondYearNetto;
            int procentResult = (Math.abs(result) * 100) / firstYearNetto;

            if (result < 0) {
                resultText = String.format("По сравнению с %s годом урожайность в %s году поднялась на %d процентов", firstYear, secondYear, procentResult);
            } else if (result > 0) {
                resultText = String.format("По сравнению с %s годом урожайность в %s году упала на %d процентов", firstYear, secondYear, procentResult);
            } else {
                resultText = String.format("По сравнению с %s годом урожайность в %s году не изменилась", firstYear, secondYear);
            }

            textAreaResult.setText(resultText);
        });


        buttonBack.setOnAction(event -> {
            setScene(buttonBack, basePath + "forms/crops/Crops.fxml");
        });
    }
}

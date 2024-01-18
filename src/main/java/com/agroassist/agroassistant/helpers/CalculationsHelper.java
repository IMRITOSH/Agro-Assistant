package com.agroassist.agroassistant.helpers;

import com.agroassist.agroassistant.validators.ValidateCalculations;
import javafx.scene.control.Label;

public class CalculationsHelper {
    ValidateCalculations validator = new ValidateCalculations();
    public Boolean validateCalculationCentners(String fieldNumber, String year, Label[] labels){
        boolean flag = true;

        String errorFieldNumber = validator.checkFieldNumber(fieldNumber);
        if (!errorFieldNumber.isEmpty()) {
            labels[0].setText(errorFieldNumber);
            labels[0].setVisible(true);
            flag = false;
        } else {
            labels[0].setText(errorFieldNumber);
            labels[0].setVisible(true);
        }

        String errorDate = validator.checkDate(year);
        if (!errorDate.isEmpty()) {
            labels[1].setText(errorDate);
            labels[1].setVisible(true);
            flag = false;
        } else {
            labels[1].setText(errorDate);
            labels[1].setVisible(false);
        }
         return flag;
    }

    public Boolean validateCalculationCropGrowth(String yearX, String yearY, Label[] labels){
        boolean flag = true;

        String errorYearX = validator.checkDate(yearX);
        if (!errorYearX.isEmpty()) {
            labels[0].setText(errorYearX);
            labels[0].setVisible(true);
            flag = false;
        } else {
            labels[0].setText(errorYearX);
            labels[0].setVisible(false);
        }

        String errorYearY = validator.checkDate(yearY);
        if (!errorYearY.isEmpty()) {
            labels[1].setText(errorYearY);
            labels[1].setVisible(true);
            flag = false;
        } else {
            labels[1].setText(errorYearY);
            labels[1].setVisible(false);
        }
        return flag;
    }
}
